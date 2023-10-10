package com.accenture.assignmentWeek.feedings.missedFeeding;

import com.accenture.assignmentWeek.horse.HorseEntity;
import jakarta.persistence.*;

import java.time.LocalDateTime;
import java.util.Objects;

@Entity
public class MissedFeedingEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private LocalDateTime missedFeedingTime;
    @ManyToOne
    @JoinColumn(name = "horse_id")
    private HorseEntity horse;

    public MissedFeedingEntity(LocalDateTime missedFeedingTime, HorseEntity horse) {
        this.missedFeedingTime = missedFeedingTime;
        this.horse = horse;
    }

    public MissedFeedingEntity() {

    }

    @Override
    public String toString() {
        return "MissedFeedingEntity{" +
                "id=" + id +
                ", missedFeedingTime=" + missedFeedingTime +
                ", horse=" + horse +
                '}';
    }

    @Override
    public boolean equals(Object o) {

        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        MissedFeedingEntity that = (MissedFeedingEntity) o;
        return Objects.equals(id, that.id) && Objects.equals(missedFeedingTime, that.missedFeedingTime) && Objects.equals(horse, that.horse);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, missedFeedingTime, horse);
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public LocalDateTime getMissedFeedingTime() {
        return missedFeedingTime;
    }

    public void setMissedFeedingTime(LocalDateTime missedFeedingTime) {
        this.missedFeedingTime = missedFeedingTime;
    }

    public HorseEntity getHorse() {
        return horse;
    }

    public void setHorse(HorseEntity horse) {
        this.horse = horse;
    }
}
