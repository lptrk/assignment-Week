package dev.lptrk.horsefeeding.feeding;

import dev.lptrk.horsefeeding.horse.Horse;
import jakarta.persistence.*;

import java.time.LocalTime;
import java.util.Objects;

@Entity
public class Feeding {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Integer id;
    @ManyToOne
    @JoinColumn(name = "horseId")
    private Horse horse;
    private LocalTime feedingTime;

    @Override
    public String toString() {
        return "Feeding{" +
                "id=" + id +
                ", horse=" + horse +
                ", feedingTime=" + feedingTime +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Feeding feeding = (Feeding) o;
        return Objects.equals(id, feeding.id) && Objects.equals(horse, feeding.horse) && Objects.equals(feedingTime, feeding.feedingTime);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, horse, feedingTime);
    }

    public Horse getHorse() {
        return horse;
    }

    public void setHorse(Horse horse) {
        this.horse = horse;
    }

    public Feeding(Integer id, Horse horse, LocalTime feedingTime) {
        this.id = id;
        this.horse = horse;
        this.feedingTime = feedingTime;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }


    public LocalTime getFeedingTime() {
        return feedingTime;
    }

    public void setFeedingTime(LocalTime feedingTime) {
        this.feedingTime = feedingTime;
    }

    public Feeding(Integer id, LocalTime feedingTime) {
        this.id = id;
        this.feedingTime = feedingTime;
    }

    public Feeding() {
    }
}
