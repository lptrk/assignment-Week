package dev.lptrk.horsefeeding.feedingSchedule;

import dev.lptrk.horsefeeding.horse.Horse;
import org.springframework.stereotype.Component;

@Component
public class FeedingScheduleDTOMapper {

    public FeedingScheduleDTO toDTO(FeedingSchedule feedingSchedule) {
        FeedingScheduleDTO dto = new FeedingScheduleDTO();
        dto.setId(feedingSchedule.getId());
        dto.setMaxFeedingTime(feedingSchedule.getMaxFeedingTime());
        dto.setMinFeedingTime(feedingSchedule.getMinFeedingTime());

        if (feedingSchedule.getHorse() != null) {
            dto.setHorseId(feedingSchedule.getHorse().getRfid());
        }

        return dto;
    }

    public FeedingSchedule toEntity(FeedingScheduleDTO dto) {
        FeedingSchedule feedingSchedule = new FeedingSchedule();
        feedingSchedule.setId(dto.getId());
        feedingSchedule.setMaxFeedingTime(dto.getMaxFeedingTime());
        feedingSchedule.setMinFeedingTime(dto.getMinFeedingTime());

        if (dto.getHorseId() != null) {
            Horse horse = new Horse();
            horse.setRfid(dto.getHorseId());
            feedingSchedule.setHorse(horse);
        }

        return feedingSchedule;
    }

}

