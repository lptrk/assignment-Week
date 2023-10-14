package dev.lptrk.horsefeeding.stable;

import java.util.List;

public class StableCreationDTO {
    private String name;
    private List<String> horses;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<String> getHorses() {
        return horses;
    }

    public void setHorses(List<String> horses) {
        this.horses = horses;
    }
}

