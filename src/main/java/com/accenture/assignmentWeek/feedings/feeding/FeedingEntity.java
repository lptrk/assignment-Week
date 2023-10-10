package com.accenture.assignmentWeek.feedings.feeding;

import com.accenture.assignmentWeek.feedings.feedingPreferences.FeedingPreferencesEntity;
import com.accenture.assignmentWeek.feedings.feedingSchedule.FeedingScheduleEntity;
import com.accenture.assignmentWeek.feedings.foodType.FoodTypeEntity;
import com.accenture.assignmentWeek.horse.HorseEntity;
import jakarta.persistence.*;

import java.time.LocalDateTime;

@Entity
public class FeedingEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private LocalDateTime feedingTime;
    private double quantityInGrams;

    @ManyToOne
    @JoinColumn(name = "horse_id")
    private HorseEntity horse;

    @ManyToOne
    @JoinColumn(name = "food_type_id")
    private FoodTypeEntity foodType;


    @ManyToOne
    @JoinColumn(name = "feeding_preferences_id")
    private FeedingPreferencesEntity feedingPreferences;

    @ManyToOne
    @JoinColumn(name = "feeding_schedule_id")
    private FeedingScheduleEntity feedingSchedule;

    public FeedingEntity(Long id, LocalDateTime feedingTime, double quantityInGrams, HorseEntity horse, FoodTypeEntity foodType, FeedingPreferencesEntity feedingPreferences, FeedingScheduleEntity feedingSchedule) {
        this.id = id;
        this.feedingTime = feedingTime;
        this.quantityInGrams = quantityInGrams;
        this.horse = horse;
        this.foodType = foodType;
        this.feedingPreferences = feedingPreferences;
        this.feedingSchedule = feedingSchedule;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public LocalDateTime getFeedingTime() {
        return feedingTime;
    }

    public void setFeedingTime(LocalDateTime feedingTime) {
        this.feedingTime = feedingTime;
    }

    public double getQuantityInGrams() {
        return quantityInGrams;
    }

    public void setQuantityInGrams(double quantityInGrams) {
        this.quantityInGrams = quantityInGrams;
    }

    public HorseEntity getHorse() {
        return horse;
    }

    public void setHorse(HorseEntity horse) {
        this.horse = horse;
    }

    public FoodTypeEntity getFoodType() {
        return foodType;
    }

    public void setFoodType(FoodTypeEntity foodType) {
        this.foodType = foodType;
    }

    public FeedingPreferencesEntity getFeedingPreferences() {
        return feedingPreferences;
    }

    public void setFeedingPreferences(FeedingPreferencesEntity feedingPreferences) {
        this.feedingPreferences = feedingPreferences;
    }

    public FeedingScheduleEntity getFeedingSchedule() {
        return feedingSchedule;
    }

    public void setFeedingSchedule(FeedingScheduleEntity feedingSchedule) {
        this.feedingSchedule = feedingSchedule;
    }

    public FeedingEntity() {

    }
}
