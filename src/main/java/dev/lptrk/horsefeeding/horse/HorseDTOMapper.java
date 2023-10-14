package dev.lptrk.horsefeeding.horse;

import dev.lptrk.horsefeeding.feedingSchedule.FeedingSchedule;
import dev.lptrk.horsefeeding.feedingSchedule.FeedingScheduleRepository;
import dev.lptrk.horsefeeding.stable.Stable;

import java.util.ArrayList;
import java.util.List;

public class HorseDTOMapper {

    public static HorseDTO toDTO(Horse horse) {
        HorseDTO horseDTO = new HorseDTO();
        horseDTO.setRfid(horse.getRfid());
        horseDTO.setName(horse.getName());
        horseDTO.setNickName(horse.getNickName());
        horseDTO.setBreed(horse.getBreed());
        horseDTO.setOwner(horse.getOwner());
        if (horse.getStable() != null) {
            horseDTO.setStableId(horse.getStable().getId());
        }
        if (horse.getFeedingSchedules() != null) {
            List<Integer> feedingScheduleIds = new ArrayList<>();
            for (FeedingSchedule feedingSchedule : horse.getFeedingSchedules()) {
                feedingScheduleIds.add(feedingSchedule.getId());
            }
            horseDTO.setFeedingScheduleIds(feedingScheduleIds);
        }


        return horseDTO;
    }

    public static Horse toEntity(HorseDTO horseDTO, FeedingScheduleRepository feedingScheduleRepository) {
        Horse horse = new Horse();
        horse.setRfid(horseDTO.getRfid());
        horse.setName(horseDTO.getName());
        horse.setNickName(horseDTO.getNickName());
        horse.setBreed(horseDTO.getBreed());
        horse.setOwner(horseDTO.getOwner());

        if (horseDTO.getStableId() != null) {
            Stable stable = new Stable();
            stable.setId(horseDTO.getStableId());
            horse.setStable(stable);
        }

        if (horseDTO.getFeedingScheduleIds() != null) {
            List<FeedingSchedule> feedingSchedules = feedingScheduleRepository.findAllById(horseDTO.getFeedingScheduleIds());
            horse.setFeedingSchedules(feedingSchedules);
        }

        return horse;
    }

}
