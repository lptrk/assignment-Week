package dev.lptrk.horsefeeding.feedingSchedule;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/feeding-schedules")
public class FeedingScheduleController {
    private final FeedingScheduleService feedingScheduleService;

    public FeedingScheduleController(FeedingScheduleService feedingScheduleService) {
        this.feedingScheduleService = feedingScheduleService;
    }

    @GetMapping("")
    public ResponseEntity<List<FeedingScheduleDTO>> getAllFeedingSchedules() {
        return ResponseEntity.ok(feedingScheduleService.getAllFeedingSchedules());
    }

    @GetMapping("{id}")
    public ResponseEntity<FeedingScheduleDTO> getFeedingScheduleById(@PathVariable("id") Integer id) {
        return ResponseEntity.ok(feedingScheduleService.getFeedingSchedule(id));
    }
    @PostMapping("")
    public ResponseEntity<FeedingScheduleDTO> createFeedingSchedule(@RequestBody FeedingScheduleDTO feedingScheduleDTO) {
        return ResponseEntity.ok(feedingScheduleService.createFeedingSchedule(feedingScheduleDTO));
    }
    @PutMapping("{id}")
    public ResponseEntity<FeedingScheduleDTO> updateFeedingScheduleById(@PathVariable("id") Integer id, @RequestBody FeedingScheduleDTO feedingScheduleDTO) {
        return ResponseEntity.ok(feedingScheduleService.updateFeedingScheduleById(id, feedingScheduleDTO));
    }

    @DeleteMapping("{id}")
    public ResponseEntity<Void> deleteFeedingScheduleById(@PathVariable("id") Integer id) {
        feedingScheduleService.deleteFeedingScheduleById(id);
        return ResponseEntity.ok().build();
    }
}
