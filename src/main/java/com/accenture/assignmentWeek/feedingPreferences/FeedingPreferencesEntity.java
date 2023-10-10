package com.accenture.assignmentWeek.feedingPreferences;

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
    private HorseEntity horse; // Das Pferd, für das die Präferenzen festgelegt sind

    private String foodType; // Art des Futters (z. B. Heu, Hafer, Müsli)
    private int minFeedingsPerDay; // Mindestanzahl der täglichen Fütterungen
    private int maxFeedingsPerDay; // Maximale Anzahl der täglichen Fütterungen
    private int preferredFeedingsPerDay;

    public FeedingPreferencesEntity() {
    }

    public FeedingPreferencesEntity(Long id, HorseEntity horse, String foodType, int minFeedingsPerDay, int maxFeedingsPerDay, int preferredFeedingsPerDay) {
        this.id = id;
        this.horse = horse;
        this.foodType = foodType;
        this.minFeedingsPerDay = minFeedingsPerDay;
        this.maxFeedingsPerDay = maxFeedingsPerDay;
        this.preferredFeedingsPerDay = preferredFeedingsPerDay;
    }

    @Override
    public String toString() {
        return "FeedingPreferencesEntity{" +
                "id=" + id +
                ", horse=" + horse +
                ", foodType='" + foodType + '\'' +
                ", minFeedingsPerDay=" + minFeedingsPerDay +
                ", maxFeedingsPerDay=" + maxFeedingsPerDay +
                ", preferredFeedingsPerDay=" + preferredFeedingsPerDay +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        FeedingPreferencesEntity that = (FeedingPreferencesEntity) o;
        return minFeedingsPerDay == that.minFeedingsPerDay && maxFeedingsPerDay == that.maxFeedingsPerDay && preferredFeedingsPerDay == that.preferredFeedingsPerDay && Objects.equals(id, that.id) && Objects.equals(horse, that.horse) && Objects.equals(foodType, that.foodType);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, horse, foodType, minFeedingsPerDay, maxFeedingsPerDay, preferredFeedingsPerDay);
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

    public int getMinFeedingsPerDay() {
        return minFeedingsPerDay;
    }

    public void setMinFeedingsPerDay(int minFeedingsPerDay) {
        this.minFeedingsPerDay = minFeedingsPerDay;
    }

    public int getMaxFeedingsPerDay() {
        return maxFeedingsPerDay;
    }

    public void setMaxFeedingsPerDay(int maxFeedingsPerDay) {
        this.maxFeedingsPerDay = maxFeedingsPerDay;
    }

    public int getPreferredFeedingsPerDay() {
        return preferredFeedingsPerDay;
    }

    public void setPreferredFeedingsPerDay(int preferredFeedingsPerDay) {
        this.preferredFeedingsPerDay = preferredFeedingsPerDay;
    }
}
