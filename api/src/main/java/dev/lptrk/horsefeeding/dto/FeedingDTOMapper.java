package dev.lptrk.horsefeeding.dto;

import dev.lptrk.horsefeeding.entity.Feeding;
import dev.lptrk.horsefeeding.entity.Horse;
import dev.lptrk.horsefeeding.repository.HorseRepository;

import jakarta.persistence.EntityNotFoundException;

import org.springframework.stereotype.Component;

import java.util.Optional;

/**
 * Mapper class responsible for converting between Feeding and FeedingDTO objects.
 */
@Component
public class FeedingDTOMapper {
    private final HorseRepository horseRepository;

    /**
     * Constructs a new FeedingDTOMapper with the provided HorseRepository.
     *
     * @param horseRepository The repository for accessing horse information.
     */
    public FeedingDTOMapper(HorseRepository horseRepository) {
        this.horseRepository = horseRepository;
    }

    /**
     * Converts a Feeding object to a FeedingDTO.
     *
     * @param feeding The Feeding object to be converted.
     * @return The corresponding FeedingDTO.
     */
    public FeedingDTO toDTO(Feeding feeding) {
        FeedingDTO dto = new FeedingDTO();
        dto.setFeedingTime(feeding.getFeedingTime());
        dto.setHorseId(feeding.getHorse().getRfid());
        return dto;
    }

    /**
     * Converts a FeedingDTO object to a Feeding entity.
     *
     * @param dto The FeedingDTO object to be converted.
     * @return The corresponding Feeding entity.
     * @throws EntityNotFoundException If the associated horse with the given RFID is not found.
     */
    public Feeding toEntity(FeedingDTO dto) {
        Feeding feeding = new Feeding();
        feeding.setFeedingTime(dto.getFeedingTime());

        Optional<Horse> optionalHorse = horseRepository.findById(dto.getHorseId());
        if (optionalHorse.isPresent()) {
            feeding.setHorse(optionalHorse.get());
        } else {
            throw new EntityNotFoundException("Horse with RFID " + dto.getHorseId() + " was not found.");
        }

        return feeding;
    }
}
