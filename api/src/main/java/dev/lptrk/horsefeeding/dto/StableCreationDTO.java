package dev.lptrk.horsefeeding.dto;

import java.util.List;

/**
 * Data Transfer Object (DTO) for creating or updating a stable.
 */
public class StableCreationDTO {
    /**
     * The name of the stable.
     */
    private String name;

    /**
     * A list of horse IDs associated with the stable.
     */
    private List<String> horses;

    /**
     * Get the name of the stable.
     *
     * @return The name of the stable.
     */
    public String getName() {
        return name;
    }

    /**
     * Set the name of the stable.
     *
     * @param name The name of the stable.
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Get the list of horse IDs associated with the stable.
     *
     * @return A list of horse IDs.
     */
    public List<String> getHorses() {
        return horses;
    }

    /**
     * Set the list of horse IDs associated with the stable.
     *
     * @param horses A list of horse IDs.
     */
    public void setHorses(List<String> horses) {
        this.horses = horses;
    }
}
