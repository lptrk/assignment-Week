package dev.lptrk.horsefeeding.stable;

import java.util.List;

/**
 * Data Transfer Object (DTO) for representing a Stable response.
 */
public class StableResponseDTO {
    private Integer id;               // The unique identifier for the Stable.
    private String name;              // The name of the Stable.
    private List<String> horseIds;    // The list of unique identifiers of the Horses associated with this Stable.

    /**
     * Get the list of unique identifiers of the Horses associated with this Stable.
     *
     * @return The list of horse unique identifiers.
     */
    public List<String> getHorseIds() {
        return horseIds;
    }

    /**
     * Set the list of unique identifiers of the Horses associated with this Stable.
     *
     * @param horseIds The list of horse unique identifiers.
     */
    public void setHorseIds(List<String> horseIds) {
        this.horseIds = horseIds;
    }

    /**
     * Get the unique identifier of the Stable.
     *
     * @return The unique identifier.
     */
    public Integer getId() {
        return id;
    }

    /**
     * Set the unique identifier of the Stable.
     *
     * @param id The unique identifier.
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * Get the name of the Stable.
     *
     * @return The name of the Stable.
     */
    public String getName() {
        return name;
    }

    /**
     * Set the name of the Stable.
     *
     * @param name The name of the Stable.
     */
    public void setName(String name) {
        this.name = name;
    }
}
