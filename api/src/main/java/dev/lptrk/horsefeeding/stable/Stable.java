package dev.lptrk.horsefeeding.stable;

import dev.lptrk.horsefeeding.horse.Horse;
import jakarta.persistence.*;

import java.util.List;
import java.util.Objects;

/**
 * This entity class represents a stable where horses are kept.
 */
@Entity
public class Stable {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
    private String name;
    @OneToMany(mappedBy = "stable")
    private List<Horse> horses;

    /**
     * Gets the ID of the stable.
     *
     * @return The stable's ID.
     */
    public Integer getId() {
        return id;
    }

    /**
     * Sets the ID of the stable.
     *
     * @param id The stable's ID.
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * Gets the name of the stable.
     *
     * @return The stable's name.
     */
    public String getName() {
        return name;
    }

    /**
     * Sets the name of the stable.
     *
     * @param name The stable's name.
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Gets the list of horses in the stable.
     *
     * @return The list of horses in the stable.
     */
    public List<Horse> getHorses() {
        return horses;
    }

    /**
     * Sets the list of horses in the stable.
     *
     * @param horses The list of horses in the stable.
     */
    public void setHorses(List<Horse> horses) {
        this.horses = horses;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Stable stable = (Stable) o;
        return Objects.equals(id, stable.id) && Objects.equals(name, stable.name) && Objects.equals(horses, stable.horses);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, horses);
    }

    /**
     * Default constructor for the Stable class.
     */
    public Stable() {
    }
}
