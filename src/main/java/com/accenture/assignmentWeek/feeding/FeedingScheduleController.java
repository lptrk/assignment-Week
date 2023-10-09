package com.accenture.assignmentWeek.feeding;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1/")
public class FeedingScheduleController {
    public FeedingScheduleController(FeedingScheduleService feedingScheduleService) {
        this.feedingScheduleService = feedingScheduleService;
    }

    private final FeedingScheduleService feedingScheduleService;


    @GetMapping("feeding-schedules")
    public ResponseEntity<List<FeedingScheduleEntity>> getAllFeedingSchedules() {
        return new ResponseEntity<>(feedingScheduleService.getAllFeedingSchedules(), HttpStatus.OK);
    }

    @GetMapping("feeding-schedules/{id}")
    public ResponseEntity<FeedingScheduleEntity> getFeedingScheduleById(@PathVariable("id") Long id) {
        return new ResponseEntity<>(feedingScheduleService.getFeedingScheduleById(id), HttpStatus.OK);
    }

    @PutMapping("feeding-schedules/{id}")
    public ResponseEntity<FeedingScheduleEntity> updateFeedingScheduleById(@PathVariable("id") Long id, @RequestBody FeedingScheduleEntity feedingScheduleEntity) {
        return new ResponseEntity<>(feedingScheduleService.updateFeedingScheduleById(id, feedingScheduleEntity), HttpStatus.OK);
    }

    @DeleteMapping("feeding-schedules/{id}")
    public void deleteFeedingScheduleById(@PathVariable("id")Long id) {
        feedingScheduleService.deleteFeedingScheduleById(id);
    }
}
