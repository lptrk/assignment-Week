package dev.lptrk.horsefeeding.core;

import dev.lptrk.horsefeeding.dto.StableCreationDTO;
import dev.lptrk.horsefeeding.dto.StableDTOMapper;
import dev.lptrk.horsefeeding.dto.StableResponseDTO;
import dev.lptrk.horsefeeding.repository.StableRepository;
import dev.lptrk.horsefeeding.entity.Stable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

/**
 * Service class for handling Stable-related operations.
 */
@Service
public class StableService {
    private final StableRepository stableRepository;

    public StableService(StableRepository stableRepository) {
        this.stableRepository = stableRepository;
    }

    /**
     * Create a new Stable.
     *
     * @param stableCreationDTO The data for creating the Stable.
     * @return A response DTO for the created Stable.
     */
    public StableResponseDTO createStable(StableCreationDTO stableCreationDTO) {
        Stable stable = StableDTOMapper.toEntity(stableCreationDTO);
        Stable createdStable = stableRepository.save(stable);
        return StableDTOMapper.toResponseDTO(createdStable);
    }

    /**
     * Get a list of all Stables.
     *
     * @return A list of response DTOs for all available Stables.
     */
    public List<StableResponseDTO> getAllStables() {
        List<Stable> stables = stableRepository.findAll();
        List<StableResponseDTO> responseDTOs = stables.stream()
                .map(StableDTOMapper::toResponseDTO)
                .collect(Collectors.toList());
        return responseDTOs;
    }

    /**
     * Get a specific Stable by its unique identifier.
     *
     * @param id The unique identifier of the Stable to retrieve.
     * @return A response DTO for the specified Stable.
     * @throws Exception if the Stable with the given identifier is not found.
     */
    public StableResponseDTO getStable(Integer id) {
        Stable stable = stableRepository.findById(id).orElseThrow();
        return StableDTOMapper.toResponseDTO(stable);
    }

    /**
     * Update an existing Stable with new data.
     *
     * @param id               The unique identifier of the Stable to update.
     * @param stableCreationDTO The data for updating the Stable.
     * @return A response DTO for the updated Stable.
     * @throws Exception if the Stable with the given identifier is not found.
     */
    public StableResponseDTO updateStableById(Integer id, StableCreationDTO stableCreationDTO) {
        Stable stableToUpdate = stableRepository.findById(id).orElseThrow();
        stableToUpdate = StableDTOMapper.toEntity(stableCreationDTO);
        Stable updatedStable = stableRepository.save(stableToUpdate);
        return StableDTOMapper.toResponseDTO(updatedStable);
    }

    /**
     * Delete a specific Stable by its unique identifier.
     *
     * @param id The unique identifier of the Stable to delete.
     */
    public void deleteStableById(Integer id) {
        stableRepository.deleteById(id);
    }
}
