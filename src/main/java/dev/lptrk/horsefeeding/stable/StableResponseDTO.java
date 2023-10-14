package dev.lptrk.horsefeeding.stable;

import java.util.List;

public class StableResponseDTO {
    private Integer id;
    private String name;
    private List<String> horseIds;

    public List<String> getHorseIds() {
        return horseIds;
    }

    public void setHorseIds(List<String> horseIds) {
        this.horseIds = horseIds;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
