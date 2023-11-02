package dev.lptrk.horsefeeding.entity;

import jakarta.persistence.*;

import java.util.List;
import java.util.Objects;

/**
 * Represents a Horse entity, including its attributes and relationships.
 */
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

    @OneToMany(mappedBy = "horse")
    private List<Feeding> feedings;

    /**
     * Gets the list of FeedingSchedules associated with this horse.
     *
     * @return The list of FeedingSchedules.
     */
    public List<FeedingSchedule> getFeedingSchedules() {
        return feedingSchedules;
    }

    /**
     * Sets the list of FeedingSchedules associated with this horse.
     *
     * @param feedingSchedules The list of FeedingSchedules to set.
     */
    public void setFeedingSchedules(List<FeedingSchedule> feedingSchedules) {
        this.feedingSchedules = feedingSchedules;
    }

    /**
     * Default constructor for the Horse entity.
     */
    public Horse() {

    }

    /**
     * Gets the stable associated with this horse.
     *
     * @return The associated Stable.
     */
    public Stable getStable() {
        return stable;
    }

    /**
     * Sets the stable associated with this horse.
     *
     * @param stable The Stable to set.
     */
    public void setStable(Stable stable) {
        this.stable = stable;
    }

    /**
     * Constructor for creating a horse with an associated stable.
     *
     * @param stable The associated Stable.
     */
    public Horse(Stable stable) {
        this.stable = stable;
    }

    /**
     * Constructor for creating a horse with various attributes.
     *
     * @param rfid    The RFID of the horse.
     * @param name    The name of the horse.
     * @param nickName The nickname of the horse.
     * @param breed   The breed of the horse.
     * @param owner   The owner of the horse.
     * @param stable1 The associated Stable.
     */
    public Horse(String rfid, String name, String nickName, String breed, String owner, String stable, Stable stable1) {
        this.rfid = rfid;
        this.name = name;
        this.nickName = nickName;
        this.breed = breed;
        this.owner = owner;
        this.stable = stable1;
    }

    /**
     * Gets the RFID of the horse.
     *
     * @return The RFID of the horse.
     */
    public String getRfid() {
        return rfid;
    }

    /**
     * Sets the RFID of the horse.
     *
     * @param rfid The RFID to set.
     */
    public void setRfid(String rfid) {
        this.rfid = rfid;
    }

    /**
     * Gets the name of the horse.
     *
     * @return The name of the horse.
     */
    public String getName() {
        return name;
    }

    /**
     * Sets the name of the horse.
     *
     * @param name The name to set.
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Gets the nickname of the horse.
     *
     * @return The nickname of the horse.
     */
    public String getNickName() {
        return nickName;
    }

    /**
     * Sets the nickname of the horse.
     *
     * @param nickName The nickname to set.
     */
    public void setNickName(String nickName) {
        this.nickName = nickName;
    }

    /**
     * Gets the breed of the horse.
     *
     * @return The breed of the horse.
     */
    public String getBreed() {
        return breed;
    }

    /**
     * Sets the breed of the horse.
     *
     * @param breed The breed to set.
     */
    public void setBreed(String breed) {
        this.breed = breed;
    }

    /**
     * Gets the owner of the horse.
     *
     * @return The owner of the horse.
     */
    public String getOwner() {
        return owner;
    }

    /**
     * Sets the owner of the horse.
     *
     * @param owner The owner to set.
     */
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
