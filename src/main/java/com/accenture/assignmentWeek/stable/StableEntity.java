package com.accenture.assignmentWeek.stable;

import com.accenture.assignmentWeek.horse.HorseEntity;
import jakarta.persistence.*;

import java.util.List;

@Entity
public class StableEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @OneToMany(mappedBy = "stable")
    private List<HorseEntity> horses;
}
