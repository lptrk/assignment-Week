package dev.lptrk.horsefeeding.controller;

import dev.lptrk.horsefeeding.dto.HorseDTO;
import dev.lptrk.horsefeeding.core.HorseService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * This class represents the REST API controller for managing Horse entities.
 */
@RestController
@RequestMapping("/api/v1/horses")
public class HorseController {
    private final HorseService horseService;

    /**
     * Constructor to initialize the HorseController with a HorseService.
     *
     * @param horseService The HorseService used for handling horse-related operations.
     */
    public HorseController(HorseService horseService) {
        this.horseService = horseService;
    }

    /**
     * Retrieves a list of all horses.
     *
     * @return A ResponseEntity containing a list of HorseDTO representing all horses.
     */
    @GetMapping("")
    public ResponseEntity<List<HorseDTO>> getAllHorses() {
        return ResponseEntity.ok(horseService.getAllHorses());
    }

    /**
     * Retrieves a specific horse by its ID.
     *
     * @param id The unique ID of the horse to retrieve.
     * @return A ResponseEntity containing the HorseDTO representing the requested horse.
     */
    @GetMapping("{id}")
    public ResponseEntity<HorseDTO> getHorseById(@PathVariable("id") String id) {
        return ResponseEntity.ok(horseService.getHorse(id));
    }

    /**
     * Retrieves a list of horses eligible for feeding at the current time.
     *
     * @return A ResponseEntity containing a list of HorseDTO representing eligible horses.
     */
    @GetMapping("/eligible")
    public ResponseEntity<List<HorseDTO>> getHorsesEligibleForFeeding() {
        try {
            return ResponseEntity.ok(horseService.getHorsesEligibleForFeedingNow());
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

    /**
     * Retrieves a list of horses eligible for feeding at a custom time.
     *
     * @param time The custom time for which to check eligibility.
     * @return A ResponseEntity containing a list of HorseDTO representing eligible horses.
     */
    @GetMapping("/eligible/")
    public ResponseEntity<List<HorseDTO>> getHorsesEligibleForFeedingAtCustomTime(@RequestParam("time") String time) {
        try {
            return ResponseEntity.ok(horseService.getHorsesEligibleForFeedingAtCutsomTime(time));
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

    /**
     * Creates a new horse entity.
     *
     * @param horseDTO The HorseDTO representing the horse to be created.
     * @return A ResponseEntity containing the created HorseDTO.
     */
    @PostMapping("")
    public ResponseEntity<HorseDTO> createHorse(@RequestBody HorseDTO horseDTO) {
        return ResponseEntity.ok(horseService.createHorse(horseDTO));
    }

    /**
     * Updates an existing horse entity by its ID.
     *
     * @param id       The unique ID of the horse to be updated.
     * @param horseDTO The HorseDTO representing the updated horse details.
     * @return A ResponseEntity containing the updated HorseDTO.
     */
    @PutMapping("{id}")
    public ResponseEntity<HorseDTO> updateHorseById(@PathVariable("id") String id, @RequestBody HorseDTO horseDTO) {
        return ResponseEntity.ok(horseService.updateHorseById(id, horseDTO));
    }

    /**
     * Deletes a horse entity by its ID.
     *
     * @param id The unique ID of the horse to be deleted.
     * @return A ResponseEntity with a success status indicating the horse has been deleted.
     */
    @DeleteMapping("{id}")
    public ResponseEntity<Void> deleteHorseById(@PathVariable("id") String id) {
        horseService.deleteHorseById(id);
        return ResponseEntity.ok().build();
    }
}
