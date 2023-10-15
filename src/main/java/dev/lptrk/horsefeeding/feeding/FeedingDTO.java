package dev.lptrk.horsefeeding.feeding;

import java.time.LocalTime;

public class FeedingDTO {
    private LocalTime feedingTime;
    private String horseId;

    public LocalTime getFeedingTime() {
        return feedingTime;
    }

    public void setFeedingTime(LocalTime feedingTime) {
        this.feedingTime = feedingTime;
    }

    public String getHorseId() {
        return horseId;
    }

    public void setHorseId(String horseId) {
        this.horseId = horseId;
    }
}
