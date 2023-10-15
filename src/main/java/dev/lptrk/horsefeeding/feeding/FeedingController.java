package dev.lptrk.horsefeeding.feeding;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/feedings")
public class FeedingController {
    private final FeedingService feedingService;

    public FeedingController(FeedingService feedingService) {
        this.feedingService = feedingService;
    }

    @GetMapping("")
    public ResponseEntity<List<FeedingDTO>> getAllFeedings() {
        return ResponseEntity.ok(feedingService.getAllFeedings());
    }

    @GetMapping("/{id}")
    public ResponseEntity<FeedingDTO> getFeeding(@PathVariable("id")Integer id) {
        return ResponseEntity.ok(feedingService.getFeeding(id));
    }

    @PostMapping("")
    public ResponseEntity<FeedingDTO> createFeeding(@RequestBody FeedingDTO feedingDTO) {
        return ResponseEntity.ok(feedingService.createFeeding(feedingDTO));
    }

    @PutMapping("/{id}")
    public ResponseEntity<FeedingDTO> updateFeeding(@PathVariable("id")Integer id, @RequestBody FeedingDTO feedingDTO) {
        return ResponseEntity.ok(feedingService.updateFeeding(id, feedingDTO));
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteFeeding(@PathVariable("id")Integer id) {
        feedingService.deleteFeeding(id);
        return ResponseEntity.ok().build();
    }

}
