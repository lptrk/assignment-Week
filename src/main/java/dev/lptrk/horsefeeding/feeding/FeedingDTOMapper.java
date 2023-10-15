package dev.lptrk.horsefeeding.feeding;

import dev.lptrk.horsefeeding.horse.Horse;
import dev.lptrk.horsefeeding.horse.HorseRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public class FeedingDTOMapper {
    private final HorseRepository horseRepository;

    public FeedingDTOMapper(HorseRepository horseRepository) {
        this.horseRepository = horseRepository;
    }

    public FeedingDTO toDTO(Feeding feeding) {
            FeedingDTO dto = new FeedingDTO();
            dto.setFeedingTime(feeding.getFeedingTime());
            dto.setHorseId(feeding.getHorse().getRfid());
            return dto;
        }

    public Feeding toEntity(FeedingDTO dto) {
        Feeding feeding = new Feeding();
        feeding.setFeedingTime(dto.getFeedingTime());

        Optional<Horse> optionalHorse = horseRepository.findById(dto.getHorseId());
        if (optionalHorse.isPresent()) {
            feeding.setHorse(optionalHorse.get());
        } else {
            throw new EntityNotFoundException("Pferd mit RFID " + dto.getHorseId() + " wurde nicht gefunden.");
        }

        return feeding;
    }

}
