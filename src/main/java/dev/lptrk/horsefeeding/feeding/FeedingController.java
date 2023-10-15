package dev.lptrk.horsefeeding.feeding;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Controller class for managing Feeding resources via REST endpoints.
 */
@RestController
@RequestMapping("/api/v1/feedings")
public class FeedingController {
    private final FeedingService feedingService;

    /**
     * Constructs a new FeedingController with the provided FeedingService.
     *
     * @param feedingService The service for managing Feeding resources.
     */
    public FeedingController(FeedingService feedingService) {
        this.feedingService = feedingService;
    }

    /**
     * Retrieves a list of all Feedings.
     *
     * @return A ResponseEntity containing a list of FeedingDTO objects.
     */
    @GetMapping("")
    public ResponseEntity<List<FeedingDTO>> getAllFeedings() {
        return ResponseEntity.ok(feedingService.getAllFeedings());
    }

    /**
     * Retrieves a specific Feeding by its ID.
     *
     * @param id The ID of the Feeding to retrieve.
     * @return A ResponseEntity containing the requested FeedingDTO.
     */
    @GetMapping("/{id}")
    public ResponseEntity<FeedingDTO> getFeeding(@PathVariable("id") Integer id) {
        return ResponseEntity.ok(feedingService.getFeeding(id));
    }

    /**
     * Creates a new Feeding.
     *
     * @param feedingDTO The FeedingDTO object representing the new Feeding to be created.
     * @return A ResponseEntity containing the created FeedingDTO.
     */
    @PostMapping("")
    public ResponseEntity<FeedingDTO> createFeeding(@RequestBody FeedingDTO feedingDTO) {
        return ResponseEntity.ok(feedingService.createFeeding(feedingDTO));
    }

    /**
     * Updates an existing Feeding by its ID.
     *
     * @param id         The ID of the Feeding to be updated.
     * @param feedingDTO The FeedingDTO object representing the updated Feeding information.
     * @return A ResponseEntity containing the updated FeedingDTO.
     */
    @PutMapping("/{id}")
    public ResponseEntity<FeedingDTO> updateFeeding(@PathVariable("id") Integer id, @RequestBody FeedingDTO feedingDTO) {
        return ResponseEntity.ok(feedingService.updateFeeding(id, feedingDTO));
    }

    /**
     * Deletes a specific Feeding by its ID.
     *
     * @param id The ID of the Feeding to be deleted.
     * @return A ResponseEntity with no content to indicate a successful deletion.
     */
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteFeeding(@PathVariable("id") Integer id) {
        feedingService.deleteFeeding(id);
        return ResponseEntity.ok().build();
    }
}
