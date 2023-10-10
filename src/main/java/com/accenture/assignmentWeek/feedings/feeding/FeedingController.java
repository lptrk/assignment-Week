package com.accenture.assignmentWeek.feedings.feeding;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1/")
public class FeedingController {
    private final FeedingService feedingService;

    public FeedingController(FeedingService feedingService) {
        this.feedingService = feedingService;
    }

    @GetMapping("feedings")
    public ResponseEntity<List<FeedingEntity>> getAllFeedings() {
        return ResponseEntity.ok(feedingService.getAllFeedings());
    }

    @GetMapping("feedings/{id}")
    public ResponseEntity<FeedingEntity> getFeedingById(@PathVariable("id") Long id) {
        return ResponseEntity.ok(feedingService.getFeedingById(id));
    }

    @PutMapping("feedings/{id}")
    public ResponseEntity<FeedingEntity> updateFeedingById(@PathVariable("id") Long id,@RequestBody FeedingEntity feedingEntity) {
        return ResponseEntity.ok(feedingService.updateFeedingById(id, feedingEntity));
    }

    @PostMapping("feedings")
    public ResponseEntity<FeedingEntity> saveFeeding(@RequestBody FeedingEntity feedingEntity) {
        return ResponseEntity.ok(feedingService.saveFeeding(feedingEntity));
    }

    @DeleteMapping("feedings/{id}")
    public void deleteFeedingById(@PathVariable("id") Long id) {
        feedingService.deleteFeedingById(id);
    }


}
