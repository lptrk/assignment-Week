package dev.lptrk.horsefeeding.feedingSchedule;

import java.time.LocalTime;

public class FeedingScheduleDTO {
    private Integer id;
    private LocalTime minFeedingTime;
    private LocalTime maxFeedingTime;
    private String horseId;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
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

    public String getHorseId() {
        return horseId;
    }

    public void setHorseId(String horseId) {
        this.horseId = horseId;
    }
}
