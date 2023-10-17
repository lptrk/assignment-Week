package dev.lptrk.horsefeeding.feedingSchedule;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * A controller class for managing feeding schedules via REST API endpoints.
 */
@RestController
@RequestMapping("/api/v1/feeding-schedules")
public class FeedingScheduleController {
    private final FeedingScheduleService feedingScheduleService;

    /**
     * Constructs a new FeedingScheduleController with the provided FeedingScheduleService.
     *
     * @param feedingScheduleService The service responsible for managing feeding schedules.
     */
    public FeedingScheduleController(FeedingScheduleService feedingScheduleService) {
        this.feedingScheduleService = feedingScheduleService;
    }

    /**
     * Retrieves a list of all feeding schedules via a GET request.
     *
     * @return A ResponseEntity containing a list of FeedingScheduleDTO objects.
     */
    @GetMapping("")
    public ResponseEntity<List<FeedingScheduleDTO>> getAllFeedingSchedules() {
        return ResponseEntity.ok(feedingScheduleService.getAllFeedingSchedules());
    }

    /**
     * Retrieves a specific feeding schedule by its ID via a GET request.
     *
     * @param id The ID of the feeding schedule to retrieve.
     * @return A ResponseEntity containing the requested FeedingScheduleDTO.
     */
    @GetMapping("{id}")
    public ResponseEntity<FeedingScheduleDTO> getFeedingScheduleById(@PathVariable("id") Integer id) {
        return ResponseEntity.ok(feedingScheduleService.getFeedingSchedule(id));
    }

    /**
     * Creates a new feeding schedule via a POST request.
     *
     * @param feedingScheduleDTO The FeedingScheduleDTO object representing the new schedule.
     * @return A ResponseEntity containing the created FeedingScheduleDTO.
     */
    @PostMapping("")
    public ResponseEntity<FeedingScheduleDTO> createFeedingSchedule(@RequestBody FeedingScheduleDTO feedingScheduleDTO) {
        return ResponseEntity.ok(feedingScheduleService.createFeedingSchedule(feedingScheduleDTO));
    }

    /**
     * Updates an existing feeding schedule by its ID via a PUT request.
     *
     * @param id                The ID of the feeding schedule to update.
     * @param feedingScheduleDTO The updated FeedingScheduleDTO object.
     * @return A ResponseEntity containing the updated FeedingScheduleDTO.
     */
    @PutMapping("{id}")
    public ResponseEntity<FeedingScheduleDTO> updateFeedingScheduleById(@PathVariable("id") Integer id, @RequestBody FeedingScheduleDTO feedingScheduleDTO) {
        return ResponseEntity.ok(feedingScheduleService.updateFeedingScheduleById(id, feedingScheduleDTO));
    }

    /**
     * Deletes a feeding schedule by its ID via a DELETE request.
     *
     * @param id The ID of the feeding schedule to delete.
     * @return A ResponseEntity with no content to indicate a successful deletion.
     */
    @DeleteMapping("{id}")
    public ResponseEntity<Void> deleteFeedingScheduleById(@PathVariable("id") Integer id) {
        feedingScheduleService.deleteFeedingScheduleById(id);
        return ResponseEntity.ok().build();
    }
}
