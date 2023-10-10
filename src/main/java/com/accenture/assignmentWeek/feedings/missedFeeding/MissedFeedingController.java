package com.accenture.assignmentWeek.feedings.missedFeeding;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1")
public class MissedFeedingController {
    private final MissedFeedingService missedFeedingService;

    public MissedFeedingController(MissedFeedingService missedFeedingService) {
        this.missedFeedingService = missedFeedingService;
    }

    @GetMapping("/missedFeedings")
    public ResponseEntity<List<MissedFeedingEntity>>getAllMissedFeedings() {
        return ResponseEntity.ok(missedFeedingService.getAllMissedFeedings());
    }
    @GetMapping("/missedFeedings/{id}")
    public ResponseEntity<MissedFeedingEntity>getMissedFeedingById(@PathVariable("id") Long id) {
        return ResponseEntity.ok(missedFeedingService.getMissedFeedingById(id));
    }

    @PutMapping("/missedFeedings/{id}")
    public ResponseEntity<MissedFeedingEntity>updateMissedFeedingById(@PathVariable("id") Long id, @RequestBody MissedFeedingEntity missedFeedingEntity) {
        return ResponseEntity.ok(missedFeedingService.updateMissedFeedingById(id, missedFeedingEntity));
    }

    @PostMapping("/missedFeedings")
    public ResponseEntity<MissedFeedingEntity>saveMissedFeeding(@RequestBody MissedFeedingEntity missedFeedingEntity) {
        return ResponseEntity.ok(missedFeedingService.saveMissedFeeding(missedFeedingEntity));
    }

    @DeleteMapping("/missedFeedings/{id}")
    public ResponseEntity<MissedFeedingEntity>deleteMissedFeedingById(@PathVariable("id") Long id) {
        missedFeedingService.deleteMissedFeedingById(id);
        return ResponseEntity.ok().build();
    }
}
