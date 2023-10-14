package dev.lptrk.horsefeeding.stable;

import dev.lptrk.horsefeeding.horse.Horse;
import jakarta.persistence.*;

import java.util.List;
import java.util.Objects;

@Entity
public class Stable {
   @Id
   @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
   private String name;
    @OneToMany(mappedBy = "stable")
    private List<Horse> horses;

    @Override
    public String toString() {
        return "Stable{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", horses=" + horses +
                '}';
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

    public List<Horse> getHorses() {
        return horses;
    }

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

    public Stable(Integer id, String name, List<Horse> horses) {
        this.id = id;
        this.name = name;
        this.horses = horses;
    }

    public Stable() {
    }
}
