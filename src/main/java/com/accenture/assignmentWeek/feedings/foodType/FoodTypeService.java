package com.accenture.assignmentWeek.feedings.foodType;

import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FoodTypeService {
    private final FoodTypeRepository foodTypeRepository;

    public FoodTypeService(FoodTypeRepository foodTypeRepository) {
        this.foodTypeRepository = foodTypeRepository;
    }

    public List<FoodTypeEntity> getAllFoodTypes() {
        return foodTypeRepository.findAll();
    }
    public FoodTypeEntity getFoodTypeById(Long id) {
        return foodTypeRepository.findById(id).orElseThrow();
    }

    public FoodTypeEntity saveFoodType(FoodTypeEntity foodTypeEntity) {
        return foodTypeRepository.save(foodTypeEntity);
    }

    public void deleteFoodTypeById(Long id) {
        foodTypeRepository.deleteById(id);
    }

    public FoodTypeEntity updateFoodTypeById(Long id, FoodTypeEntity foodTypeEntity) {
        FoodTypeEntity foodTypeEntityToUpdate = foodTypeRepository.findById(id).orElseThrow();
        foodTypeEntityToUpdate.setName(foodTypeEntity.getName());
        return foodTypeRepository.save(foodTypeEntityToUpdate);
    }
}
