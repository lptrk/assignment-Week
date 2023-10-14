package dev.lptrk.horsefeeding.stable;

import dev.lptrk.horsefeeding.horse.Horse;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class StableDTOMapper {
    public static Stable toEntity(StableCreationDTO creationDTO) {
        Stable stable = new Stable();
        stable.setName(creationDTO.getName());
        // Setzen Sie die Pferde-Ids im Entity, falls vorhanden
        if (creationDTO.getHorses() != null) {
            List<Horse> horses = new ArrayList<>();
            for (String rfid : creationDTO.getHorses()) {
                Horse horse = new Horse();
                horse.setRfid(rfid);
                horses.add(horse);
            }
            stable.setHorses(horses);
        }
        return stable;
    }

    public static StableResponseDTO toResponseDTO(Stable stable) {
        StableResponseDTO responseDTO = new StableResponseDTO();
        responseDTO.setId(stable.getId());
        responseDTO.setName(stable.getName());
        // Extrahieren Sie die Pferde-Ids aus dem Entity, falls vorhanden
        if (stable.getHorses() != null) {
            List<String> horseIds = stable.getHorses().stream()
                    .map(Horse::getRfid)
                    .collect(Collectors.toList());
            responseDTO.setHorseIds(horseIds);
        }
        return responseDTO;
    }
}
