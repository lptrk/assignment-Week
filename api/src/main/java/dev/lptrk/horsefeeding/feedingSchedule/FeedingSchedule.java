package dev.lptrk.horsefeeding.feedingSchedule;

import dev.lptrk.horsefeeding.horse.Horse;
import jakarta.persistence.*;

import java.time.LocalTime;
import java.util.Objects;

/**
 * Represents a feeding schedule for a specific horse, specifying the minimum and maximum feeding times.
 */
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

    /**
     * Returns a string representation of the FeedingSchedule object.
     *
     * @return A string containing the FeedingSchedule's ID, associated Horse, and feeding time range.
     */
    @Override
    public String toString() {
        return "FeedingSchedule{" +
                "id=" + id +
                ", horse=" + horse +
                ", minFeedingTime=" + minFeedingTime +
                ", maxFeedingTime=" + maxFeedingTime +
                '}';
    }

    /**
     * Checks if this FeedingSchedule is equal to another object.
     *
     * @param o The object to compare with this FeedingSchedule.
     * @return true if the objects are equal, false otherwise.
     */
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        FeedingSchedule that = (FeedingSchedule) o;
        return Objects.equals(id, that.id) && Objects.equals(horse, that.horse) && Objects.equals(minFeedingTime, that.minFeedingTime) && Objects.equals(maxFeedingTime, that.maxFeedingTime);
    }

    /**
     * Generates a hash code for this FeedingSchedule object.
     *
     * @return An integer hash code based on the FeedingSchedule's attributes.
     */
    @Override
    public int hashCode() {
        return Objects.hash(id, horse, minFeedingTime, maxFeedingTime);
    }

    /**
     * Gets the ID of the FeedingSchedule.
     *
     * @return The ID of the FeedingSchedule.
     */
    public Integer getId() {
        return id;
    }

    /**
     * Sets the ID of the FeedingSchedule.
     *
     * @param id The ID to set for the FeedingSchedule.
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * Gets the Horse associated with this FeedingSchedule.
     *
     * @return The associated Horse.
     */
    public Horse getHorse() {
        return horse;
    }

    /**
     * Sets the Horse associated with this FeedingSchedule.
     *
     * @param horse The Horse to associate with this FeedingSchedule.
     */
    public void setHorse(Horse horse) {
        this.horse = horse;
    }

    /**
     * Gets the minimum feeding time for this schedule.
     *
     * @return The minimum feeding time.
     */
    public LocalTime getMinFeedingTime() {
        return minFeedingTime;
    }

    /**
     * Sets the minimum feeding time for this schedule.
     *
     * @param minFeedingTime The minimum feeding time to set.
     */
    public void setMinFeedingTime(LocalTime minFeedingTime) {
        this.minFeedingTime = minFeedingTime;
    }

    /**
     * Gets the maximum feeding time for this schedule.
     *
     * @return The maximum feeding time.
     */
    public LocalTime getMaxFeedingTime() {
        return maxFeedingTime;
    }

    /**
     * Sets the maximum feeding time for this schedule.
     *
     * @param maxFeedingTime The maximum feeding time to set.
     */
    public void setMaxFeedingTime(LocalTime maxFeedingTime) {
        this.maxFeedingTime = maxFeedingTime;
    }

    /**
     * Constructs a new FeedingSchedule with the provided attributes.
     *
     * @param id            The ID of the FeedingSchedule.
     * @param horse         The associated Horse.
     * @param minFeedingTime The minimum feeding time.
     * @param maxFeedingTime The maximum feeding time.
     */
    public FeedingSchedule(Integer id, Horse horse, LocalTime minFeedingTime, LocalTime maxFeedingTime) {
        this.id = id;
        this.horse = horse;
        this.minFeedingTime = minFeedingTime;
        this.maxFeedingTime = maxFeedingTime;
    }

    /**
     * Constructs a new, empty FeedingSchedule.
     */
    public FeedingSchedule() {
    }
}
