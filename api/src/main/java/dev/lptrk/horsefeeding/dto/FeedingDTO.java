package dev.lptrk.horsefeeding.dto;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;

/**
 * Data Transfer Object (DTO) representing feeding information.
 */
public class FeedingDTO {
    /**
     * The time at which the feeding event occurred.
     *
     * @return The feeding time.
     */
    private LocalDateTime feedingTime;

    /**
     * The unique identifier of the horse associated with the feeding event.
     *
     * @return The horse's unique identifier (RFID).
     */
    private String horseId;

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

    /**
     * Gets the unique identifier of the horse associated with the feeding event.
     *
     * @return The horse's unique identifier (RFID).
     */
    public String getHorseId() {
        return horseId;
    }

    /**
     * Sets the unique identifier of the horse associated with the feeding event.
     *
     * @param horseId The horse's unique identifier (RFID).
     */
    public void setHorseId(String horseId) {
        this.horseId = horseId;
    }
}
