package dev.lptrk.horsefeeding.report;

import dev.lptrk.horsefeeding.feeding.FeedingDTO;
import dev.lptrk.horsefeeding.feeding.FeedingDTOMapper;
import dev.lptrk.horsefeeding.feeding.FeedingService;
import dev.lptrk.horsefeeding.feedingSchedule.FeedingScheduleDTO;
import dev.lptrk.horsefeeding.feedingSchedule.FeedingScheduleDTOMapper;
import dev.lptrk.horsefeeding.feedingSchedule.FeedingScheduleService;
import dev.lptrk.horsefeeding.horse.HorseDTO;
import dev.lptrk.horsefeeding.horse.HorseService;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

/**
 * This service class provides methods for generating reports related to horse feedings.
 */
@Service
public class ReportService {
    private final HorseService horseService;
    private final FeedingService feedingService;
    private final FeedingScheduleService feedingScheduleService;
    private final FeedingDTOMapper feedingDTOMapper;
    private final FeedingScheduleDTOMapper feedingScheduleDTOMapper;

    public ReportService(HorseService horseService, FeedingService feedingService, FeedingScheduleService feedingScheduleService, FeedingDTOMapper feedingDTOMapper, FeedingScheduleDTOMapper feedingScheduleDTOMapper) {
        this.horseService = horseService;
        this.feedingService = feedingService;
        this.feedingScheduleService = feedingScheduleService;
        this.feedingDTOMapper = feedingDTOMapper;
        this.feedingScheduleDTOMapper = feedingScheduleDTOMapper;
    }

    /**
     * Retrieves a list of horses that have missed feedings within a specified time range.
     *
     * @return A list of {@link HorseDTO} objects representing horses with missed feedings.
     */
    public List<HorseDTO> getHorsesWithMissedFeedingRange() {
        // Step 1: Create a set to store the IDs of horses with completed feedings.
        Set<String> completedHorseIds = feedingService.getAllFeedings().stream()
                .filter(feeding -> isFeedingWithinAnySchedule(feeding, feedingScheduleService.getAllFeedingSchedules()))
                .map(FeedingDTO::getHorseId)
                .collect(Collectors.toSet());

        // Step 2: Retrieve a list of all available horses from the horse service.
        List<HorseDTO> allHorses = horseService.getAllHorses();

        // Step 3: Filter horses based on completed or missed feedings and collect the result into a list.
        return allHorses.stream()
                .filter(horse -> !completedHorseIds.contains(horse.getRfid()))
                .collect(Collectors.toList());
    }

    /**
     * Checks if a feeding falls within any of the provided feeding schedules.
     *
     * @param feeding          The feeding to check.
     * @param feedingSchedules A list of {@link FeedingScheduleDTO} objects to check against.
     * @return {@code true} if the feeding falls within any schedule, {@code false} otherwise.
     */
    private boolean isFeedingWithinAnySchedule(FeedingDTO feeding, List<FeedingScheduleDTO> feedingSchedules) {
        LocalDateTime feedingTime = feeding.getFeedingTime();
        return feedingSchedules.stream()
                .anyMatch(schedule ->
                        schedule.getMinFeedingTime().isBefore(feedingTime.toLocalTime()) &&
                                schedule.getMaxFeedingTime().isAfter(feedingTime.toLocalTime())
                );
    }

}
