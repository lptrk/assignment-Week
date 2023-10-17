package dev.lptrk.horsefeeding.feedingSchedule;

import java.time.LocalTime;

/**
 * A Data Transfer Object (DTO) representing a feeding schedule.
 */
public class FeedingScheduleDTO {
    private Integer id;
    private LocalTime minFeedingTime;
    private LocalTime maxFeedingTime;
    private String horseId;

    /**
     * Gets the ID of the feeding schedule.
     *
     * @return The ID of the feeding schedule.
     */
    public Integer getId() {
        return id;
    }

    /**
     * Sets the ID of the feeding schedule.
     *
     * @param id The ID of the feeding schedule.
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * Gets the minimum feeding time for the schedule.
     *
     * @return The minimum feeding time.
     */
    public LocalTime getMinFeedingTime() {
        return minFeedingTime;
    }

    /**
     * Sets the minimum feeding time for the schedule.
     *
     * @param minFeedingTime The minimum feeding time.
     */
    public void setMinFeedingTime(LocalTime minFeedingTime) {
        this.minFeedingTime = minFeedingTime;
    }

    /**
     * Gets the maximum feeding time for the schedule.
     *
     * @return The maximum feeding time.
     */
    public LocalTime getMaxFeedingTime() {
        return maxFeedingTime;
    }

    /**
     * Sets the maximum feeding time for the schedule.
     *
     * @param maxFeedingTime The maximum feeding time.
     */
    public void setMaxFeedingTime(LocalTime maxFeedingTime) {
        this.maxFeedingTime = maxFeedingTime;
    }

    /**
     * Gets the ID of the horse associated with the feeding schedule.
     *
     * @return The horse's ID.
     */
    public String getHorseId() {
        return horseId;
    }

    /**
     * Sets the ID of the horse associated with the feeding schedule.
     *
     * @param horseId The horse's ID.
     */
    public void setHorseId(String horseId) {
        this.horseId = horseId;
    }
}
