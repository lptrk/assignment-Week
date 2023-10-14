package dev.lptrk.horsefeeding.feedingSchedule;

import dev.lptrk.horsefeeding.horse.Horse;
import dev.lptrk.horsefeeding.horse.HorseDTO;
import jakarta.persistence.*;

import java.time.LocalDateTime;
import java.util.Objects;

@Entity
public class FeedingSchedule {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Integer id;
    @ManyToOne
    @JoinColumn(name = "horseId")
    private Horse horse;
    private LocalDateTime minFeedingTime;
    private LocalDateTime maxFeedingTime;

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

    public LocalDateTime getMinFeedingTime() {
        return minFeedingTime;
    }

    public void setMinFeedingTime(LocalDateTime minFeedingTime) {
        this.minFeedingTime = minFeedingTime;
    }

    public LocalDateTime getMaxFeedingTime() {
        return maxFeedingTime;
    }

    public void setMaxFeedingTime(LocalDateTime maxFeedingTime) {
        this.maxFeedingTime = maxFeedingTime;
    }

    public FeedingSchedule(Integer id, Horse horse, LocalDateTime minFeedingTime, LocalDateTime maxFeedingTime) {
        this.id = id;
        this.horse = horse;
        this.minFeedingTime = minFeedingTime;
        this.maxFeedingTime = maxFeedingTime;
    }

    public FeedingSchedule() {
    }
}
