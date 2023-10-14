package dev.lptrk.horsefeeding.feedingSchedule;

import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class FeedingScheduleService {
    private final FeedingScheduleRepository feedingScheduleRepository;
    private final FeedingScheduleDTOMapper feedingScheduleDTOMapper;

    public FeedingScheduleService(FeedingScheduleRepository feedingScheduleRepository, FeedingScheduleDTOMapper feedingScheduleDTOMapper) {
        this.feedingScheduleRepository = feedingScheduleRepository;
        this.feedingScheduleDTOMapper = feedingScheduleDTOMapper;
    }

    public FeedingScheduleDTO createFeedingSchedule(FeedingScheduleDTO feedingScheduleDTO) {
        FeedingSchedule feedingSchedule = feedingScheduleDTOMapper.toEntity(feedingScheduleDTO);
        FeedingSchedule createdFeedingSchedule = feedingScheduleRepository.save(feedingSchedule);
        return feedingScheduleDTOMapper.toDTO(createdFeedingSchedule);
    }

    public List<FeedingScheduleDTO> getAllFeedingSchedules() {
        List<FeedingSchedule> feedingSchedules = feedingScheduleRepository.findAll();
        return feedingSchedules.stream()
                .map(feedingScheduleDTOMapper::toDTO)
                .collect(Collectors.toList());
    }

    public FeedingScheduleDTO getFeedingSchedule(Integer id) {
        FeedingSchedule feedingSchedule = feedingScheduleRepository.findById(id).orElseThrow();
        return feedingScheduleDTOMapper.toDTO(feedingSchedule);
    }

    public FeedingScheduleDTO updateFeedingScheduleById(Integer id, FeedingScheduleDTO feedingScheduleDTO) {
        FeedingSchedule feedingScheduleToUpdate = feedingScheduleRepository.findById(id).orElseThrow();
        FeedingSchedule updatedFeedingSchedule = feedingScheduleDTOMapper.toEntity(feedingScheduleDTO);
        updatedFeedingSchedule.setId(id);
        updatedFeedingSchedule = feedingScheduleRepository.save(updatedFeedingSchedule);
        return feedingScheduleDTOMapper.toDTO(updatedFeedingSchedule);
    }


    public void deleteFeedingScheduleById(Integer id) {
        feedingScheduleRepository.deleteById(id);
    }


}
