package dev.lptrk.horsefeeding.stable;

import dev.lptrk.horsefeeding.horse.Horse;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class StableDTOMapper {
    public static Stable toEntity(StableCreationDTO creationDTO) {
        Stable stable = new Stable();
        stable.setName(creationDTO.getName());
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
        if (stable.getHorses() != null) {
            List<String> horseIds = stable.getHorses().stream()
                    .map(Horse::getRfid)
                    .collect(Collectors.toList());
            responseDTO.setHorseIds(horseIds);
        }
        return responseDTO;
    }
}
