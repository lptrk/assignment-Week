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

import java.util.ArrayList;
import java.util.List;

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
     * Retrieves a list of HorseDTOs whose feeding times fall outside of their scheduled feeding ranges.
     *
     * @return A list of HorseDTOs with missed feeding ranges.
     */
    public List<HorseDTO> getHorsesWithMissedFeedingRange() {
        List<HorseDTO> reportedHorses = new ArrayList<>();
        List<FeedingDTO> completedFeedings = new ArrayList();
        List<FeedingDTO> allFeedings = feedingService.getAllFeedings();
        List<FeedingScheduleDTO> allFeedingSchedules = feedingScheduleService.getAllFeedingSchedules();

        for (FeedingDTO feeding : allFeedings) {
            boolean isCompleted = false;

            for (FeedingScheduleDTO feedingSchedule : allFeedingSchedules) {
                if (feedingSchedule.getMinFeedingTime().isBefore(feeding.getFeedingTime()) &&
                        feedingSchedule.getMaxFeedingTime().isAfter(feeding.getFeedingTime())) {
                    isCompleted = true;
                    break;
                }
            }

            if (!isCompleted) {
                reportedHorses.add(horseService.getHorse(feeding.getHorseId()));
            } else {
                completedFeedings.add(feeding);
            }
        }
        return reportedHorses;
    }
}
