package dev.lptrk.horsefeeding.core;

import dev.lptrk.horsefeeding.dto.FeedingDTO;
import dev.lptrk.horsefeeding.dto.FeedingDTOMapper;
import dev.lptrk.horsefeeding.dto.HorseDTO;
import dev.lptrk.horsefeeding.entity.Feeding;
import dev.lptrk.horsefeeding.entity.FeedingSchedule;
import dev.lptrk.horsefeeding.repository.FeedingScheduleRepository;
import dev.lptrk.horsefeeding.dto.HorseDTOMapper;
import dev.lptrk.horsefeeding.repository.FeedingRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Service class for managing Feeding resources and business logic.
 */
@Service
public class FeedingService {
    private final FeedingRepository feedingRepository;
    private final FeedingDTOMapper mapper;
    private final HorseService horseService;
    private final FeedingScheduleRepository feedingScheduleRepository;

    /**
     * Constructs a new FeedingService with the provided dependencies.
     *
     * @param feedingRepository        The repository for managing Feedings.
     * @param mapper                   The mapper for converting between Feeding and FeedingDTO.
     * @param horseService             The service for managing Horse resources.
     * @param feedingScheduleRepository The repository for managing FeedingSchedules.
     */
    public FeedingService(FeedingRepository feedingRepository, FeedingDTOMapper mapper, HorseService horseService, HorseDTOMapper horseDTOMapper, FeedingScheduleRepository feedingScheduleRepository) {
        this.feedingRepository = feedingRepository;
        this.mapper = mapper;
        this.horseService = horseService;
        this.feedingScheduleRepository = feedingScheduleRepository;
    }

    /**
     * Retrieves a list of all Feedings.
     *
     * @return A list of FeedingDTO objects representing all Feedings.
     */
    public List<FeedingDTO> getAllFeedings() {
        List<Feeding> feedings = feedingRepository.findAll();
        return feedings.stream()
                .map(mapper::toDTO)
                .collect(Collectors.toList());
    }

    /**
     * Retrieves a specific Feeding by its ID.
     *
     * @param id The ID of the Feeding to retrieve.
     * @return The FeedingDTO representing the requested Feeding.
     */
    public FeedingDTO getFeeding(Integer id) {
        Feeding feeding = feedingRepository.findById(id).orElseThrow();
        return mapper.toDTO(feeding);
    }

    /**
     * Creates a new Feeding.
     *
     * @param feedingDTO The FeedingDTO object representing the new Feeding to be created.
     * @return The created FeedingDTO.
     */
    public FeedingDTO createFeeding(FeedingDTO feedingDTO) {
        LocalDateTime time = feedingDTO.getFeedingTime();
        HorseDTO horseToFeed = horseService.getHorse(feedingDTO.getHorseId());
        List<FeedingSchedule> feedingSchedulesOfHorseToFeed = feedingScheduleRepository.findAllById(horseToFeed.getFeedingScheduleIds());
        Feeding createdFeeding = null;
        for (FeedingSchedule feedingSchedule : feedingSchedulesOfHorseToFeed) {
            if (time.toLocalTime().isAfter(feedingSchedule.getMinFeedingTime()) && time.toLocalTime().isBefore(feedingSchedule.getMaxFeedingTime())) {
                feedingDTO.setHorseId(horseToFeed.getRfid());
                createdFeeding = feedingRepository.save(mapper.toEntity(feedingDTO));
            }
        }
        if (createdFeeding != null) {
            return mapper.toDTO(createdFeeding);
        } else {
            return null;
        }
    }

    /**
     * Updates an existing Feeding by its ID.
     *
     * @param id         The ID of the Feeding to be updated.
     * @param feedingDTO The FeedingDTO object representing the updated Feeding information.
     * @return The updated FeedingDTO.
     */
    public FeedingDTO updateFeeding(Integer id, FeedingDTO feedingDTO) {
        Feeding feedingToUpdate = feedingRepository.findById(id).orElseThrow();
        Feeding updatedFeeding = mapper.toEntity(feedingDTO);
        updatedFeeding.setId(id);
        updatedFeeding = feedingRepository.save(updatedFeeding);
        return mapper.toDTO(updatedFeeding);
    }

    /**
     * Deletes a specific Feeding by its ID.
     *
     * @param id The ID of the Feeding to be deleted.
     */
    public void deleteFeeding(Integer id) {
        feedingRepository.deleteById(id);
    }
}
