package com.accenture.assignmentWeek.feedings.foodType;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1")
public class FoodTypeController {
    private final FoodTypeService foodTypeService;

    public FoodTypeController(FoodTypeService foodTypeService) {
        this.foodTypeService = foodTypeService;
    }

    @GetMapping("/food-types")
    public ResponseEntity<List<FoodTypeEntity>> getAllFoodTypes() {
        return ResponseEntity.ok(foodTypeService.getAllFoodTypes());
    }

    @GetMapping("/food-types/{id}")
    public ResponseEntity<FoodTypeEntity> getFoodTypeById(@PathVariable("id") Long id) {
        return ResponseEntity.ok(foodTypeService.getFoodTypeById(id));
    }
    @PostMapping("/food-types")
    public ResponseEntity<FoodTypeEntity> saveFoodType(@RequestBody FoodTypeEntity foodTypeEntity) {
        return ResponseEntity.ok(foodTypeService.saveFoodType(foodTypeEntity));
    }
    @PutMapping("/food-types/{id}")
    public ResponseEntity<FoodTypeEntity> updateFoodTypeById(@PathVariable("id") Long id,@RequestBody FoodTypeEntity foodTypeEntity) {
        return ResponseEntity.ok(foodTypeService.updateFoodTypeById(id, foodTypeEntity));
    }

    @DeleteMapping("/food-types/{id}")
    public ResponseEntity<Void> deleteFoodTypeById(@PathVariable("id") Long id) {
        foodTypeService.deleteFoodTypeById(id);
        return ResponseEntity.ok().build();
    }

}
