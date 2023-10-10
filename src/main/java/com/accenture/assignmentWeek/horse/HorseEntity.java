package com.accenture.assignmentWeek.horse;

import com.accenture.assignmentWeek.feedings.feeding.FeedingEntity;
import com.accenture.assignmentWeek.feedings.feedingPreferences.FeedingPreferencesEntity;
import com.accenture.assignmentWeek.feedings.feedingSchedule.FeedingScheduleEntity;
import com.accenture.assignmentWeek.stable.StableEntity;
import jakarta.persistence.*;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Objects;

@Entity
public class HorseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private String rfid;
    private String name;
    private String nickName;
    private Breed breed;
    private String owner;
    @ManyToOne
    @JoinColumn(name = "stable_id")
    private StableEntity stable;

    @OneToMany(mappedBy = "horse")
    private List<FeedingScheduleEntity> feedingSchedules;

    @ManyToOne
    @JoinColumn(name = "feeding_preferences_id")
    private FeedingPreferencesEntity feedingPreferences;

    @OneToMany(mappedBy = "horse")
    private List<FeedingEntity> feedings;

    public HorseEntity() {

    }

    @Override
    public String toString() {
        return "HorseEntity{" +
                "rfid='" + rfid + '\'' +
                ", name='" + name + '\'' +
                ", nickName='" + nickName + '\'' +
                ", breed='" + breed + '\'' +
                ", owner='" + owner + '\'' +
                ", stable=" + stable +
                ", feedingSchedules=" + feedingSchedules +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        HorseEntity that = (HorseEntity) o;
        return Objects.equals(rfid, that.rfid) && Objects.equals(name, that.name) && Objects.equals(nickName, that.nickName) && Objects.equals(breed, that.breed) && Objects.equals(owner, that.owner) && Objects.equals(stable, that.stable) && Objects.equals(feedingSchedules, that.feedingSchedules);
    }

    @Override
    public int hashCode() {
        return Objects.hash(rfid, name, nickName, breed, owner, stable, feedingSchedules);
    }

    public String getRfid() {
        return rfid;
    }

    public void setRfid(String rfid) {
        this.rfid = rfid;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getNickName() {
        return nickName;
    }

    public void setNickName(String nickName) {
        this.nickName = nickName;
    }

    public Breed getBreed() {
        return breed;
    }

    public void setBreed(Breed breed) {
        this.breed = breed;
    }

    public String getOwner() {
        return owner;
    }

    public void setOwner(String owner) {
        this.owner = owner;
    }

    public StableEntity getStable() {
        return stable;
    }

    public void setStable(StableEntity stable) {
        this.stable = stable;
    }

    public List<FeedingScheduleEntity> getFeedingSchedules() {
        return feedingSchedules;
    }

    public void setFeedingSchedules(List<FeedingScheduleEntity> feedingSchedules) {
        this.feedingSchedules = feedingSchedules;
    }


    public HorseEntity(String rfid, String name, String nickName, Breed breed, String owner, StableEntity stable, List<FeedingScheduleEntity> feedingSchedules, List<FeedingPreferencesEntity> feedingPreferences, LocalDateTime lastFeedingTime, Integer numberOfDailyFeedings) {
        this.rfid = rfid;
        this.name = name;
        this.nickName = nickName;
        this.breed = breed;
        this.owner = owner;
        this.stable = stable;
        this.feedingSchedules = feedingSchedules;
    }


}
