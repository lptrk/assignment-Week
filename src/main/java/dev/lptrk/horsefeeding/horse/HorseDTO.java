package dev.lptrk.horsefeeding.horse;


import java.util.List;

public class HorseDTO {
    private String rfid;
    private String name;
    private String nickName;
    private String breed;
    private String owner;
    private Integer stableId;
    private List<Integer> feedingScheduleIds;

    public List<Integer> getFeedingScheduleIds() {
        return feedingScheduleIds;
    }

    public void setFeedingScheduleIds(List<Integer> feedingScheduleIds) {
        this.feedingScheduleIds = feedingScheduleIds;
    }



    public HorseDTO() {
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


    public Integer getStableId() {
        return stableId;
    }

    public void setStableId(Integer stableId) {
        this.stableId = stableId;
    }
}
