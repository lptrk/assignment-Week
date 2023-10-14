package dev.lptrk.horsefeeding.horse;

import dev.lptrk.horsefeeding.feedingSchedule.FeedingSchedule;
import dev.lptrk.horsefeeding.stable.Stable;
import jakarta.persistence.*;

import java.util.List;
import java.util.Objects;

@Entity
public class Horse {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private String rfid;
    private String name;
    private String nickName;
    private String breed;
    private String owner;
    @ManyToOne
    @JoinColumn(name = "stableId")
    private Stable stable;
    @OneToMany(mappedBy = "horse")
    private List<FeedingSchedule> feedingSchedules;

    public List<FeedingSchedule> getFeedingSchedules() {
        return feedingSchedules;
    }

    public void setFeedingSchedules(List<FeedingSchedule> feedingSchedules) {
        this.feedingSchedules = feedingSchedules;
    }

    public Horse() {

    }

    public Stable getStable() {
        return stable;
    }

    public void setStable(Stable stable) {
        this.stable = stable;
    }



    public Horse(Stable stable) {
        this.stable = stable;
    }

    public Horse(String rfid, String name, String nickName, String breed, String owner, String stable, Stable stable1) {
        this.rfid = rfid;
        this.name = name;
        this.nickName = nickName;
        this.breed = breed;
        this.owner = owner;
        this.stable = stable1;
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

    public String getBreed() {
        return breed;
    }

    public void setBreed(String breed) {
        this.breed = breed;
    }

    public String getOwner() {
        return owner;
    }

    public void setOwner(String owner) {
        this.owner = owner;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Horse horse = (Horse) o;
        return Objects.equals(rfid, horse.rfid) && Objects.equals(name, horse.name) && Objects.equals(nickName, horse.nickName) && Objects.equals(breed, horse.breed) && Objects.equals(owner, horse.owner) && Objects.equals(stable, horse.stable);
    }

    @Override
    public int hashCode() {
        return Objects.hash(rfid, name, nickName, breed, owner, stable);
    }

    @Override
    public String toString() {
        return "Horse{" +
                "rfid='" + rfid + '\'' +
                ", name='" + name + '\'' +
                ", nickName='" + nickName + '\'' +
                ", breed='" + breed + '\'' +
                ", owner='" + owner + '\'' +
                '}';
    }
}
