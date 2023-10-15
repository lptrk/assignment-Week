package dev.lptrk.horsefeeding.feedingSchedule;

import dev.lptrk.horsefeeding.horse.Horse;
import org.springframework.stereotype.Component;

/**
 * A mapper class for converting between FeedingSchedule and FeedingScheduleDTO objects.
 */
@Component
public class FeedingScheduleDTOMapper {

    /**
     * Converts a FeedingSchedule object to a FeedingScheduleDTO object.
     *
     * @param feedingSchedule The FeedingSchedule object to convert.
     * @return The corresponding FeedingScheduleDTO object.
     */
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

    /**
     * Converts a FeedingScheduleDTO object to a FeedingSchedule object.
     *
     * @param dto The FeedingScheduleDTO object to convert.
     * @return The corresponding FeedingSchedule object.
     */
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
