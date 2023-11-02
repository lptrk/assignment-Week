package dev.lptrk.horsefeeding.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.persistence.*;

import java.time.LocalDateTime;
import java.util.Objects;

/**
 * Represents a feeding event for a horse at a specific time.
 */
@Entity
public class Feeding {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Integer id;

    /**
     * The horse associated with this feeding event.
     */
    @ManyToOne
    @JoinColumn(name = "horseId")
    private Horse horse;

    /**
     * The time and date at which the feeding event occurred.
     */
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm")
    private LocalDateTime feedingTime;

    /**
     * Constructs a new Feeding instance.
     */
    public Feeding() {
    }

    /**
     * Constructs a new Feeding instance with the specified ID and feeding time.
     *
     * @param id           The unique identifier for the feeding event.
     * @param feedingTime  The time at which the feeding event occurred.
     */
    public Feeding(Integer id, LocalDateTime feedingTime) {
        this.id = id;
        this.feedingTime = feedingTime;
    }

    /**
     * Constructs a new Feeding instance with the specified ID, associated horse, and feeding time.
     *
     * @param id           The unique identifier for the feeding event.
     * @param horse        The horse associated with the feeding event.
     * @param feedingTime  The time at which the feeding event occurred.
     */
    public Feeding(Integer id, Horse horse, LocalDateTime feedingTime) {
        this.id = id;
        this.horse = horse;
        this.feedingTime = feedingTime;
    }

    /**
     * Gets the unique identifier of the feeding event.
     *
     * @return The ID of the feeding event.
     */
    public Integer getId() {
        return id;
    }

    /**
     * Sets the unique identifier of the feeding event.
     *
     * @param id The ID of the feeding event.
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * Gets the associated horse of the feeding event.
     *
     * @return The associated horse.
     */
    public Horse getHorse() {
        return horse;
    }

    /**
     * Sets the associated horse of the feeding event.
     *
     * @param horse The associated horse.
     */
    public void setHorse(Horse horse) {
        this.horse = horse;
    }

    /**
     * Gets the time at which the feeding event occurred.
     *
     * @return The feeding time.
     */
    public LocalDateTime getFeedingTime() {
        return feedingTime;
    }

    /**
     * Sets the time at which the feeding event occurred.
     *
     * @param feedingTime The feeding time.
     */
    public void setFeedingTime(LocalDateTime feedingTime) {
        this.feedingTime = feedingTime;
    }

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
}
