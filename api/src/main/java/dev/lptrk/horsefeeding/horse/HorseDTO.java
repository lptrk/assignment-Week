package dev.lptrk.horsefeeding.horse;

import java.util.List;

/**
 * This class represents a Data Transfer Object (DTO) for Horse entities.
 */
public class HorseDTO {
    private String rfid; // RFID identifier for the horse
    private String name; // Name of the horse
    private String nickName; // Nickname of the horse
    private String breed; // Breed of the horse
    private String owner; // Owner of the horse
    private Integer stableId; // ID of the stable where the horse is kept
    private List<Integer> feedingScheduleIds; // List of IDs for feeding schedules associated with the horse

    /**
     * Default constructor for creating an instance of HorseDTO.
     */
    public HorseDTO() {
    }

    /**
     * Get the RFID identifier of the horse.
     *
     * @return The RFID identifier of the horse.
     */
    public String getRfid() {
        return rfid;
    }

    /**
     * Set the RFID identifier of the horse.
     *
     * @param rfid The RFID identifier to set.
     */
    public void setRfid(String rfid) {
        this.rfid = rfid;
    }

    /**
     * Get the name of the horse.
     *
     * @return The name of the horse.
     */
    public String getName() {
        return name;
    }

    /**
     * Set the name of the horse.
     *
     * @param name The name to set.
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Get the nickname of the horse.
     *
     * @return The nickname of the horse.
     */
    public String getNickName() {
        return nickName;
    }

    /**
     * Set the nickname of the horse.
     *
     * @param nickName The nickname to set.
     */
    public void setNickName(String nickName) {
        this.nickName = nickName;
    }

    /**
     * Get the breed of the horse.
     *
     * @return The breed of the horse.
     */
    public String getBreed() {
        return breed;
    }

    /**
     * Set the breed of the horse.
     *
     * @param breed The breed to set.
     */
    public void setBreed(String breed) {
        this.breed = breed;
    }

    /**
     * Get the owner of the horse.
     *
     * @return The owner of the horse.
     */
    public String getOwner() {
        return owner;
    }

    /**
     * Set the owner of the horse.
     *
     * @param owner The owner to set.
     */
    public void setOwner(String owner) {
        this.owner = owner;
    }

    /**
     * Get the ID of the stable where the horse is kept.
     *
     * @return The stable ID.
     */
    public Integer getStableId() {
        return stableId;
    }

    /**
     * Set the ID of the stable where the horse is kept.
     *
     * @param stableId The stable ID to set.
     */
    public void setStableId(Integer stableId) {
        this.stableId = stableId;
    }

    /**
     * Get a list of IDs for feeding schedules associated with the horse.
     *
     * @return A list of feeding schedule IDs.
     */
    public List<Integer> getFeedingScheduleIds() {
        return feedingScheduleIds;
    }

    /**
     * Set a list of IDs for feeding schedules associated with the horse.
     *
     * @param feedingScheduleIds The list of feeding schedule IDs to set.
     */
    public void setFeedingScheduleIds(List<Integer> feedingScheduleIds) {
        this.feedingScheduleIds = feedingScheduleIds;
    }
}

