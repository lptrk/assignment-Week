package dev.lptrk.horsefeeding.horse;

import dev.lptrk.horsefeeding.feedingSchedule.FeedingSchedule;
import dev.lptrk.horsefeeding.feedingSchedule.FeedingScheduleDTO;
import dev.lptrk.horsefeeding.feedingSchedule.FeedingScheduleRepository;
import org.springframework.stereotype.Service;

import java.time.LocalTime;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class HorseService {
    public HorseService(HorseRepository horseRepository, FeedingScheduleRepository feedingScheduleRepository) {
        this.horseRepository = horseRepository;
        this.feedingScheduleRepository = feedingScheduleRepository;
    }

    private final HorseRepository horseRepository;
    private final FeedingScheduleRepository feedingScheduleRepository;

    public HorseDTO createHorse(HorseDTO horseDTO) {
        List<Integer> feedingScheduleIds = horseDTO.getFeedingScheduleIds();
        if (feedingScheduleIds != null && !feedingScheduleIds.isEmpty()) {
            List<FeedingSchedule> feedingSchedules = feedingScheduleRepository.findAllById(feedingScheduleIds);
            Horse horse = HorseDTOMapper.toEntity(horseDTO, feedingScheduleRepository);

            horse.setFeedingSchedules(feedingSchedules);
            Horse createdHorse = horseRepository.save(horse);

            return HorseDTOMapper.toDTO(createdHorse);
        }
        else{
            return null; //TODO: throw exception
        }
    }

    public List<HorseDTO> getHorsesEligibleForFeedingNow() {
        List<HorseDTO> eligibleHorses = null;
        List<HorseDTO> allHorses = getAllHorses();
        LocalTime now = LocalTime.now();
        for(HorseDTO horse: allHorses){
            List<FeedingSchedule> schedulesForThisHorse = feedingScheduleRepository.findAllById(horse.getFeedingScheduleIds());
            for(FeedingSchedule schedule: schedulesForThisHorse){
                if(now.isAfter(schedule.getMinFeedingTime()) && now.isBefore(schedule.getMaxFeedingTime())){
                   eligibleHorses.add(horse);
                }
            }
        }
        return eligibleHorses;
    }
    public List<HorseDTO> getHorsesEligibleForFeedingAtCutsomTime(String timeEntered) {
        List<HorseDTO> eligibleHorses = null;
        List<HorseDTO> allHorses = getAllHorses();
        LocalTime time = LocalTime.parse(timeEntered);
        for(HorseDTO horse: allHorses){
            List<FeedingSchedule> schedulesForThisHorse = feedingScheduleRepository.findAllById(horse.getFeedingScheduleIds());
            for(FeedingSchedule schedule: schedulesForThisHorse){
                if(time.isAfter(schedule.getMinFeedingTime()) && time.isBefore(schedule.getMaxFeedingTime())){
                    eligibleHorses.add(horse);
                }
            }
        }
        return eligibleHorses;
    }
    public List<HorseDTO> getAllHorses() {
        List<Horse> horses = horseRepository.findAll();
        return horses.stream()
                .map(HorseDTOMapper::toDTO)
                .collect(Collectors.toList());
    }

    public HorseDTO getHorse(String rfid) {
        Horse horse = horseRepository.findById(rfid).orElseThrow();
        return HorseDTOMapper.toDTO(horse);
    }

    public HorseDTO updateHorseById(String id, HorseDTO horseDTO) {
        Horse horseToUpdate = horseRepository.findById(id).orElseThrow();
        horseToUpdate = HorseDTOMapper.toEntity(horseDTO,feedingScheduleRepository);
        Horse updatedHorse = horseRepository.save(horseToUpdate);
        return HorseDTOMapper.toDTO(updatedHorse);
    }



    public void deleteHorseById(String id) {
        horseRepository.deleteById(id);
    }
}
