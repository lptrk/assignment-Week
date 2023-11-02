package dev.lptrk.horsefeeding.core;

import dev.lptrk.horsefeeding.dto.FeedingScheduleDTO;
import dev.lptrk.horsefeeding.dto.FeedingScheduleDTOMapper;
import dev.lptrk.horsefeeding.entity.FeedingSchedule;
import dev.lptrk.horsefeeding.repository.FeedingScheduleRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

/**
 * A service class for managing FeedingSchedule entities and DTOs.
 */
@Service
public class FeedingScheduleService {
    private final FeedingScheduleRepository feedingScheduleRepository;
    private final FeedingScheduleDTOMapper feedingScheduleDTOMapper;

    /**
     * Constructs a new FeedingScheduleService with the specified repositories and mappers.
     *
     * @param feedingScheduleRepository   The repository for FeedingSchedule entities.
     * @param feedingScheduleDTOMapper    The mapper for converting between FeedingSchedule and FeedingScheduleDTO objects.
     */
    public FeedingScheduleService(FeedingScheduleRepository feedingScheduleRepository, FeedingScheduleDTOMapper feedingScheduleDTOMapper) {
        this.feedingScheduleRepository = feedingScheduleRepository;
        this.feedingScheduleDTOMapper = feedingScheduleDTOMapper;
    }

    /**
     * Creates a new FeedingSchedule based on the provided FeedingScheduleDTO.
     *
     * @param feedingScheduleDTO The FeedingScheduleDTO to create a FeedingSchedule from.
     * @return The created FeedingScheduleDTO.
     */
    public FeedingScheduleDTO createFeedingSchedule(FeedingScheduleDTO feedingScheduleDTO) {
        FeedingSchedule feedingSchedule = feedingScheduleDTOMapper.toEntity(feedingScheduleDTO);
        FeedingSchedule createdFeedingSchedule = feedingScheduleRepository.save(feedingSchedule);
        return feedingScheduleDTOMapper.toDTO(createdFeedingSchedule);
    }

    /**
     * Retrieves a list of all FeedingScheduleDTO objects.
     *
     * @return A list of FeedingScheduleDTO objects.
     */
    public List<FeedingScheduleDTO> getAllFeedingSchedules() {
        List<FeedingSchedule> feedingSchedules = feedingScheduleRepository.findAll();
        return feedingSchedules.stream()
                .map(feedingScheduleDTOMapper::toDTO)
                .collect(Collectors.toList());
    }

    /**
     * Retrieves a specific FeedingScheduleDTO by its ID.
     *
     * @param id The ID of the FeedingSchedule to retrieve.
     * @return The corresponding FeedingScheduleDTO.
     * @throws EntityNotFoundException if the specified FeedingSchedule is not found.
     */
    public FeedingScheduleDTO getFeedingSchedule(Integer id) {
        FeedingSchedule feedingSchedule = feedingScheduleRepository.findById(id).orElseThrow();
        return feedingScheduleDTOMapper.toDTO(feedingSchedule);
    }

    /**
     * Updates a specific FeedingSchedule based on the provided FeedingScheduleDTO.
     *
     * @param id                The ID of the FeedingSchedule to update.
     * @param feedingScheduleDTO The FeedingScheduleDTO containing the updated data.
     * @return The updated FeedingScheduleDTO.
     * @throws EntityNotFoundException if the specified FeedingSchedule is not found.
     */
    public FeedingScheduleDTO updateFeedingScheduleById(Integer id, FeedingScheduleDTO feedingScheduleDTO) {
        FeedingSchedule feedingScheduleToUpdate = feedingScheduleRepository.findById(id).orElseThrow();
        FeedingSchedule updatedFeedingSchedule = feedingScheduleDTOMapper.toEntity(feedingScheduleDTO);
        updatedFeedingSchedule.setId(id);
        updatedFeedingSchedule = feedingScheduleRepository.save(updatedFeedingSchedule);
        return feedingScheduleDTOMapper.toDTO(updatedFeedingSchedule);
    }

    /**
     * Deletes a specific FeedingSchedule by its ID.
     *
     * @param id The ID of the FeedingSchedule to delete.
     */
    public void deleteFeedingScheduleById(Integer id) {
        feedingScheduleRepository.deleteById(id);
    }
}
