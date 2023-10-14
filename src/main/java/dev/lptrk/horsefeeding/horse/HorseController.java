package dev.lptrk.horsefeeding.horse;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/horses")
public class HorseController {
    private final HorseService horseService;

    public HorseController(HorseService horseService) {
        this.horseService = horseService;
    }

    @GetMapping("")
    public ResponseEntity<List<HorseDTO>> getAllHorses() {
        return ResponseEntity.ok(horseService.getAllHorses());
    }

    @GetMapping("{id}")
    public ResponseEntity<HorseDTO> getHorseById(@PathVariable("id") String id) {
        return ResponseEntity.ok(horseService.getHorse(id));
    }

    @GetMapping("/eligible")
    public ResponseEntity<List<HorseDTO>> getHorsesEligibleForFeeding() {
        return ResponseEntity.ok(horseService.getHorsesEligibleForFeedingNow());
    }
    @GetMapping("/eligible/")
    public ResponseEntity<List<HorseDTO>> getHorsesEligibleForFeedingAtCutsomTime(@RequestParam("time") String time) {
        return ResponseEntity.ok(horseService.getHorsesEligibleForFeedingAtCutsomTime(time));
    }
    @PostMapping("")
    public ResponseEntity<HorseDTO> createHorse(@RequestBody HorseDTO horseDTO) {
        return ResponseEntity.ok(horseService.createHorse(horseDTO));
    }

    @PutMapping("{id}")
    public ResponseEntity<HorseDTO> updateHorseById(@PathVariable("id") String id, @RequestBody HorseDTO horseDTO) {
        return ResponseEntity.ok(horseService.updateHorseById(id, horseDTO));
    }

    @DeleteMapping("{id}")
    public ResponseEntity<Void> deleteHorseById(@PathVariable("id") String id) {
        horseService.deleteHorseById(id);
        return ResponseEntity.ok().build();
    }

}
