package dev.lptrk.horsefeeding.stable;

import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class StableService {
    private final StableRepository stableRepository;

    public StableService(StableRepository stableRepository) {
        this.stableRepository = stableRepository;
    }

    public StableResponseDTO createStable(StableCreationDTO stableCreationDTO) {
        Stable stable = StableDTOMapper.toEntity(stableCreationDTO);
        Stable createdStable = stableRepository.save(stable);
        return StableDTOMapper.toResponseDTO(createdStable);
    }

    public List<StableResponseDTO> getAllStables() {
        List<Stable> stables = stableRepository.findAll();
        List<StableResponseDTO> responseDTOs = stables.stream()
                .map(StableDTOMapper::toResponseDTO)
                .collect(Collectors.toList());
        return responseDTOs;
    }


    public StableResponseDTO getStable(Integer id) {
        Stable stable = stableRepository.findById(id).orElseThrow();
        return StableDTOMapper.toResponseDTO(stable);
    }

    public StableResponseDTO updateStableById(Integer id, StableCreationDTO stableCreationDTO) {
        Stable stableToUpdate = stableRepository.findById(id).orElseThrow();
        stableToUpdate = StableDTOMapper.toEntity(stableCreationDTO);
        Stable updatedStable = stableRepository.save(stableToUpdate);
        return StableDTOMapper.toResponseDTO(updatedStable);
    }

    public void deleteStableById(Integer id) {
        stableRepository.deleteById(id);
    }
}
