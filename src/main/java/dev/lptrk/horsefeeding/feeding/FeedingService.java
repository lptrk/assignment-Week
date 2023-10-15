package dev.lptrk.horsefeeding.feeding;

import dev.lptrk.horsefeeding.feedingSchedule.FeedingSchedule;
import dev.lptrk.horsefeeding.feedingSchedule.FeedingScheduleRepository;
import dev.lptrk.horsefeeding.horse.HorseDTO;
import dev.lptrk.horsefeeding.horse.HorseDTOMapper;
import dev.lptrk.horsefeeding.horse.HorseService;
import org.springframework.stereotype.Service;

import java.time.LocalTime;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class FeedingService {
    private final FeedingRepository feedingRepository;
    private final FeedingDTOMapper mapper;
    private final HorseService horseService;
    private final FeedingScheduleRepository feedingScheduleRepository;


    public FeedingService(FeedingRepository feedingRepository, FeedingDTOMapper mapper, HorseService horseService, HorseDTOMapper horseDTOMapper, FeedingScheduleRepository feedingScheduleRepository) {
        this.feedingRepository = feedingRepository;
        this.mapper = mapper;
        this.horseService = horseService;
        this.feedingScheduleRepository = feedingScheduleRepository;
    }

    public List<FeedingDTO> getAllFeedings() {
        List<Feeding> feedings = feedingRepository.findAll();
        return feedings.stream()
                .map(mapper::toDTO)
                .collect(Collectors.toList());
    }

    public FeedingDTO getFeeding(Integer id) {
        Feeding feeding = feedingRepository.findById(id).orElseThrow();
        return mapper.toDTO(feeding);
    }

    public FeedingDTO createFeeding(FeedingDTO feedingDTO) {
    LocalTime time = feedingDTO.getFeedingTime();
        HorseDTO horseToFeed = horseService.getHorse(feedingDTO.getHorseId());
        List<FeedingSchedule> feedingSchedulesOfHorseToFeed = feedingScheduleRepository.findAllById(horseToFeed.getFeedingScheduleIds());
        Feeding createdFeeding = null;
        for(FeedingSchedule feedingSchedule : feedingSchedulesOfHorseToFeed){
            if(time.isAfter(feedingSchedule.getMinFeedingTime()) && time.isBefore(feedingSchedule.getMaxFeedingTime())){
                feedingDTO.setHorseId(horseToFeed.getRfid());
                createdFeeding = feedingRepository.save(mapper.toEntity(feedingDTO));
            }
        }
        if (createdFeeding != null) {
            return mapper.toDTO(createdFeeding);
        }
        else {
            return null;
        }
    }

    public FeedingDTO updateFeeding(Integer id, FeedingDTO feedingDTO) {
        Feeding feedingToUpdate = feedingRepository.findById(id).orElseThrow();
        Feeding updatedFeeding = mapper.toEntity(feedingDTO);
        updatedFeeding.setId(id);
        updatedFeeding = feedingRepository.save(updatedFeeding);
        return mapper.toDTO(updatedFeeding);
    }

    public void deleteFeeding(Integer id) {
        feedingRepository.deleteById(id);
    }


}
