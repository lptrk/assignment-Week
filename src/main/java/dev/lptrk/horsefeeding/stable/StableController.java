package dev.lptrk.horsefeeding.stable;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/stables")
public class StableController {
    private final StableService stableService;

    public StableController(StableService stableService) {
        this.stableService = stableService;
    }

    @PostMapping("")
    public ResponseEntity<StableResponseDTO> createStable(@RequestBody StableCreationDTO stableCreationDTO) {
        StableResponseDTO stableResponseDTO = stableService.createStable(stableCreationDTO);
        return ResponseEntity.ok(stableResponseDTO);
    }

    @GetMapping("")
    public ResponseEntity<List<StableResponseDTO>> getAllStables() {
        List<StableResponseDTO> stableResponseDTOs = stableService.getAllStables();
        return ResponseEntity.ok(stableResponseDTOs);
    }

    @GetMapping("/{id}")
    public ResponseEntity<StableResponseDTO> getStable(@PathVariable Integer id) {
        StableResponseDTO stableResponseDTO = stableService.getStable(id);
        return ResponseEntity.ok(stableResponseDTO);
    }

    @PutMapping("/{id}")
    public ResponseEntity<StableResponseDTO> updateStableById(@PathVariable Integer id, StableCreationDTO stableCreationDTO) {
        StableResponseDTO stableResponseDTO = stableService.updateStableById(id, stableCreationDTO);
        return ResponseEntity.ok(stableResponseDTO);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteStableById(@PathVariable Integer id) {
        stableService.deleteStableById(id);
        return ResponseEntity.ok().build();
    }
}
