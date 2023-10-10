package com.accenture.assignmentWeek.feedings.feedingSchedule;

import com.accenture.assignmentWeek.feedings.feeding.FeedingEntity;
import com.accenture.assignmentWeek.feedings.feedingPreferences.FeedingPreferencesEntity;
import com.accenture.assignmentWeek.horse.HorseEntity;
import jakarta.persistence.*;

import java.time.LocalTime;
import java.util.List;
import java.util.Objects;

@Entity
public class FeedingScheduleEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private LocalTime feedingTime;

    @ManyToOne
    @JoinColumn(name = "horse_id")
    private HorseEntity horse;
    @OneToOne
    @JoinColumn(name = "feeding_preferences_id")
    private FeedingPreferencesEntity feedingPreferences;
    @OneToMany(mappedBy = "feedingSchedule")
    private List<FeedingEntity> feedings;
    @Override
    public String toString() {
        return "FeedingScheduleEntity{" +
                "id=" + id +
                ", feedingTime=" + feedingTime +
                ", horse=" + horse +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        FeedingScheduleEntity that = (FeedingScheduleEntity) o;
        return Objects.equals(id, that.id) && Objects.equals(feedingTime, that.feedingTime) && Objects.equals(horse, that.horse);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, feedingTime, horse);
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public LocalTime getFeedingTime() {
        return feedingTime;
    }

    public void setFeedingTime(LocalTime feedingTime) {
        this.feedingTime = feedingTime;
    }


    public HorseEntity getHorse() {
        return horse;
    }

    public void setHorse(HorseEntity horse) {
        this.horse = horse;
    }

    public FeedingScheduleEntity() {
    }

    public FeedingScheduleEntity(Long id, LocalTime feedingTime, HorseEntity horse) {
        this.id = id;
        this.feedingTime = feedingTime;
        this.horse = horse;
    }


}
