package com.accenture.assignmentWeek.stable;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1/")
public class StableController {
    public StableController(StableService stableService) {
        this.stableService = stableService;
    }

    private final StableService stableService;

    @GetMapping("stables")
    public ResponseEntity<List<StableEntity>> getStables() {
        return new ResponseEntity<>(
                stableService.getAllStables(), HttpStatus.OK
        );
    }

    @GetMapping("stables/{id}")
    public ResponseEntity<StableEntity> getStableById(@PathVariable("id")Long id) {
        return new ResponseEntity<>(stableService.getStableById(id), HttpStatus.OK);
    }

    @PostMapping("stables")
    public ResponseEntity<StableEntity> saveStable(StableEntity stableEntity) {
        return new ResponseEntity<>(stableService.saveStable(stableEntity), HttpStatus.CREATED);
    }

    @PutMapping("stables/{id}")
    public ResponseEntity<StableEntity> updateStableById(@PathVariable("id") Long id, @RequestBody StableEntity stable) {
        return new ResponseEntity<>(stableService.updateStableById(id, stable), HttpStatus.OK);
    }

    @DeleteMapping("stables/{id}")
    public void deleteStableById(@PathVariable("id") Long id) {
        stableService.deleteStableById(id);
    }

}
