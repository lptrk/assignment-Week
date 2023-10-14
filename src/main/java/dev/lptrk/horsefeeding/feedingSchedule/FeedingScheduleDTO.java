package dev.lptrk.horsefeeding.feedingSchedule;

import java.time.LocalDateTime;

public class FeedingScheduleDTO {
    private Integer id;
    private LocalDateTime minFeedingTime;
    private LocalDateTime maxFeedingTime;
    private String horseId;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
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

    public String getHorseId() {
        return horseId;
    }

    public void setHorseId(String horseId) {
        this.horseId = horseId;
    }
}
