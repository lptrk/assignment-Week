package com.accenture.assignmentWeek.horse;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1")
public class HorseController {
    private final HorseService horseService;

    public HorseController(HorseService horseService) {
        this.horseService = horseService;
    }

    @GetMapping("horses")
    public ResponseEntity<List<HorseEntity>> getAllHorses() {
        return new ResponseEntity<>(horseService.getAllHorses(), HttpStatus.OK);
    }

    @GetMapping("horses/{id}")
    public ResponseEntity<HorseEntity>getHorseById(@PathVariable("id")String id) {
        return new ResponseEntity<>(horseService.getHorseById(id), HttpStatus.OK);
    }

    @PostMapping("horses")
    public ResponseEntity<HorseEntity> saveHorse(HorseEntity horse) {
        return new ResponseEntity<>(horseService.saveHorse(horse), HttpStatus.CREATED);
    }

    @PutMapping("horses/{id}")
    public ResponseEntity<HorseEntity> updateHorseById(@PathVariable("id") String id, @RequestBody HorseEntity horse) {
        return new ResponseEntity<>(horseService.updateHorseById(id, horse), HttpStatus.OK);
    }

    @DeleteMapping("horses/{id}")
    public void deleteHorseById(@PathVariable("id")String id) {
        horseService.deleteHorseById(id);
    }

}
