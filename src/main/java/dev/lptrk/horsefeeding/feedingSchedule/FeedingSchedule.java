package dev.lptrk.horsefeeding.feedingSchedule;

import dev.lptrk.horsefeeding.horse.Horse;
import dev.lptrk.horsefeeding.horse.HorseDTO;
import jakarta.persistence.*;

import java.time.LocalTime;
import java.util.Objects;

@Entity
public class FeedingSchedule {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Integer id;
    @ManyToOne
    @JoinColumn(name = "horseId")
    private Horse horse;
    private LocalTime minFeedingTime;
    private LocalTime maxFeedingTime;

    @Override
    public String toString() {
        return "FeedingSchedule{" +
                "id=" + id +
                ", horse=" + horse +
                ", minFeedingTime=" + minFeedingTime +
                ", maxFeedingTime=" + maxFeedingTime +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        FeedingSchedule that = (FeedingSchedule) o;
        return Objects.equals(id, that.id) && Objects.equals(horse, that.horse) && Objects.equals(minFeedingTime, that.minFeedingTime) && Objects.equals(maxFeedingTime, that.maxFeedingTime);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, horse, minFeedingTime, maxFeedingTime);
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Horse getHorse() {
        return horse;
    }

    public void setHorse(Horse horse) {
        this.horse = horse;
    }

    public LocalTime getMinFeedingTime() {
        return minFeedingTime;
    }

    public void setMinFeedingTime(LocalTime minFeedingTime) {
        this.minFeedingTime = minFeedingTime;
    }

    public LocalTime getMaxFeedingTime() {
        return maxFeedingTime;
    }

    public void setMaxFeedingTime(LocalTime maxFeedingTime) {
        this.maxFeedingTime = maxFeedingTime;
    }

    public FeedingSchedule(Integer id, Horse horse, LocalTime minFeedingTime, LocalTime maxFeedingTime) {
        this.id = id;
        this.horse = horse;
        this.minFeedingTime = minFeedingTime;
        this.maxFeedingTime = maxFeedingTime;
    }

    public FeedingSchedule() {
    }
}
