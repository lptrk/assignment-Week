package com.accenture.assignmentWeek.feedings.feedingPreferences;

import com.accenture.assignmentWeek.feedings.feedingSchedule.FeedingScheduleEntity;
import com.accenture.assignmentWeek.horse.HorseEntity;
import jakarta.persistence.*;

import java.util.Objects;

@Entity
public class FeedingPreferencesEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id; // Eindeutige Kennung (ID) für die Fütterungspräferenzen

    @ManyToOne
    @JoinColumn(name = "horse_id")
    private HorseEntity horse;

    private String foodType; //TODO: Add FoodTypeEntity
    @OneToOne(mappedBy = "feedingPreferences")
    private FeedingScheduleEntity feedingSchedule;
    public FeedingPreferencesEntity() {
    }

    public FeedingPreferencesEntity(Long id, HorseEntity horse, String foodType, int maxFeedingsPerDay, int preferredFeedingsPerDay) {
        this.id = id;
        this.horse = horse;
        this.foodType = foodType;
    }

    @Override
    public String toString() {
        return "FeedingPreferencesEntity{" +
                "id=" + id +
                ", horse=" + horse +
                ", foodType='" + foodType + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        FeedingPreferencesEntity that = (FeedingPreferencesEntity) o;
        return  Objects.equals(id, that.id) && Objects.equals(horse, that.horse) && Objects.equals(foodType, that.foodType);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, horse, foodType);
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public HorseEntity getHorse() {
        return horse;
    }

    public void setHorse(HorseEntity horse) {
        this.horse = horse;
    }

    public String getFoodType() {
        return foodType;
    }

    public void setFoodType(String foodType) {
        this.foodType = foodType;
    }

}
