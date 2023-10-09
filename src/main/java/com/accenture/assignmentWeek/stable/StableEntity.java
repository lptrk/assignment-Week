package com.accenture.assignmentWeek.stable;

import com.accenture.assignmentWeek.horse.HorseEntity;
import jakarta.persistence.*;

import java.util.List;
import java.util.Objects;

@Entity
public class StableEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @OneToMany(mappedBy = "stable")
    private List<HorseEntity> horses;
    public StableEntity() {

    }

    @Override
    public String toString() {
        return "StableEntity{" +
                "id=" + id +
                ", horses=" + horses +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        StableEntity that = (StableEntity) o;
        return Objects.equals(id, that.id) && Objects.equals(horses, that.horses);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, horses);
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public List<HorseEntity> getHorses() {
        return horses;
    }

    public void setHorses(List<HorseEntity> horses) {
        this.horses = horses;
    }

    public StableEntity(Long id, List<HorseEntity> horses) {
        this.id = id;
        this.horses = horses;
    }


}
