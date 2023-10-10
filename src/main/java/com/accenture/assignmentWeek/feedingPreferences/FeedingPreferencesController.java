package com.accenture.assignmentWeek.feedingPreferences;

import org.apache.coyote.Response;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1")
public class FeedingPreferencesController {
    private final FeedingPreferencesService feedingPreferencesService;

    public FeedingPreferencesController(FeedingPreferencesService feedingPreferencesService) {
        this.feedingPreferencesService = feedingPreferencesService;
    }

    @GetMapping("feeding-preferences")
    public ResponseEntity<List<FeedingPreferencesEntity>> getAllFeedingPreferences() {
        return new ResponseEntity<>(feedingPreferencesService.getAlleedingPreferences()
                , HttpStatus.OK);
    }

    @GetMapping("feeding-preferences/{id}")
    public ResponseEntity<FeedingPreferencesEntity> getFeedingPreferencesById(@PathVariable("id") Long id) {
        return new ResponseEntity<>(feedingPreferencesService.getFeedingPreferencesByID(id), HttpStatus.OK);
    }

    @PutMapping("feedin-preferences/{id}")
    public ResponseEntity<FeedingPreferencesEntity> updateFeedingPreferencesById(@PathVariable("id") Long id, @RequestBody FeedingPreferencesEntity feedingPreferencesEntity) {
        return new ResponseEntity<>(feedingPreferencesService.updateFeedingPreferencesById(id, feedingPreferencesEntity), HttpStatus.OK);
    }

    @PostMapping("feeding-preferences")
    public ResponseEntity<FeedingPreferencesEntity> saveFeedingPreferences(@RequestBody FeedingPreferencesEntity feedingPreferencesEntity) {
        return new ResponseEntity<>(feedingPreferencesService.saveFeedingPreerences(feedingPreferencesEntity), HttpStatus.CREATED);
    }

    @DeleteMapping("feeding-preferences/{id}")
    public void deleteFeedingPreferencesById(@PathVariable("id") Long id) {
        feedingPreferencesService.deleteFeedingPreferencesById(id);
    }
}




