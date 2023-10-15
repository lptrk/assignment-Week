package dev.lptrk.horsefeeding.horse;

import dev.lptrk.horsefeeding.feedingSchedule.FeedingSchedule;
import dev.lptrk.horsefeeding.feedingSchedule.FeedingScheduleRepository;
import org.springframework.stereotype.Service;

import java.time.LocalTime;
import java.util.List;
import java.util.stream.Collectors;

/**
 * This service class provides methods for handling Horse entities and their corresponding DTOs.
 */
@Service
public class HorseService {
    private final HorseRepository horseRepository;
    private final FeedingScheduleRepository feedingScheduleRepository;

    public HorseService(HorseRepository horseRepository, FeedingScheduleRepository feedingScheduleRepository) {
        this.horseRepository = horseRepository;
        this.feedingScheduleRepository = feedingScheduleRepository;
    }

    /**
     * Creates a new Horse entity from a HorseDTO.
     *
     * @param horseDTO The HorseDTO containing the data for the new Horse.
     * @return A HorseDTO representing the created Horse entity.
     */
    public HorseDTO createHorse(HorseDTO horseDTO) {
        List<Integer> feedingScheduleIds = horseDTO.getFeedingScheduleIds();
        if (feedingScheduleIds != null && !feedingScheduleIds.isEmpty()) {
            List<FeedingSchedule> feedingSchedules = feedingScheduleRepository.findAllById(feedingScheduleIds);
            Horse horse = HorseDTOMapper.toEntity(horseDTO, feedingScheduleRepository);

            horse.setFeedingSchedules(feedingSchedules);
            Horse createdHorse = horseRepository.save(horse);

            return HorseDTOMapper.toDTO(createdHorse);
        } else {
            return null; //TODO: throw exception
        }
    }

    /**
     * Retrieves a list of HorseDTOs that are eligible for feeding at the current time.
     *
     * @return A list of eligible HorseDTOs.
     */
    public List<HorseDTO> getHorsesEligibleForFeedingNow() {
        List<HorseDTO> eligibleHorses = null;
        List<HorseDTO> allHorses = getAllHorses();
        LocalTime now = LocalTime.now();
        for (HorseDTO horse : allHorses) {
            List<FeedingSchedule> schedulesForThisHorse = feedingScheduleRepository.findAllById(horse.getFeedingScheduleIds());
            for (FeedingSchedule schedule : schedulesForThisHorse) {
                if (now.isAfter(schedule.getMinFeedingTime()) && now.isBefore(schedule.getMaxFeedingTime())) {
                    eligibleHorses.add(horse);
                }
            }
        }
        return eligibleHorses;
    }

    /**
     * Retrieves a list of HorseDTOs that are eligible for feeding at a custom time.
     *
     * @param timeEntered A custom time in the format "HH:mm".
     * @return A list of eligible HorseDTOs.
     */
    public List<HorseDTO> getHorsesEligibleForFeedingAtCutsomTime(String timeEntered) {
        List<HorseDTO> eligibleHorses = null;
        List<HorseDTO> allHorses = getAllHorses();
        LocalTime time = LocalTime.parse(timeEntered);
        for (HorseDTO horse : allHorses) {
            List<FeedingSchedule> schedulesForThisHorse = feedingScheduleRepository.findAllById(horse.getFeedingScheduleIds());
            for (FeedingSchedule schedule : schedulesForThisHorse) {
                if (time.isAfter(schedule.getMinFeedingTime()) && time.isBefore(schedule.getMaxFeedingTime())) {
                    eligibleHorses.add(horse);
                }
            }
        }
        return eligibleHorses;
    }

    /**
     * Retrieves a list of all HorseDTOs.
     *
     * @return A list of all HorseDTOs.
     */
    public List<HorseDTO> getAllHorses() {
        List<Horse> horses = horseRepository.findAll();
        return horses.stream()
                .map(HorseDTOMapper::toDTO)
                .collect(Collectors.toList());
    }

    /**
     * Retrieves a HorseDTO by its RFID.
     *
     * @param rfid The RFID of the Horse.
     * @return A HorseDTO representing the specified Horse entity.
     */
    public HorseDTO getHorse(String rfid) {
        Horse horse = horseRepository.findById(rfid).orElseThrow();
        return HorseDTOMapper.toDTO(horse);
    }

    /**
     * Updates a Horse entity by its RFID with data from a HorseDTO.
     *
     * @param id       The RFID of the Horse to be updated.
     * @param horseDTO The HorseDTO containing the updated data.
     * @return A HorseDTO representing the updated Horse entity.
     */
    public HorseDTO updateHorseById(String id, HorseDTO horseDTO) {
        Horse horseToUpdate = horseRepository.findById(id).orElseThrow();
        horseToUpdate = HorseDTOMapper.toEntity(horseDTO, feedingScheduleRepository);
        Horse updatedHorse = horseRepository.save(horseToUpdate);
        return HorseDTOMapper.toDTO(updatedHorse);
    }

    /**
     * Deletes a Horse entity by its RFID.
     *
     * @param id The RFID of the Horse to be deleted.
     */
    public void deleteHorseById(String id) {
        horseRepository.deleteById(id);
    }
}
