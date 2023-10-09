package com.accenture.assignmentWeek.feeding;

import com.accenture.assignmentWeek.horse.HorseEntity;
import jakarta.persistence.*;

import java.time.LocalTime;
import java.util.List;

@Entity
public class FeedingScheduleEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private LocalTime feedingTime;
    private int numberOfFeedings;

    @ManyToOne
    @JoinColumn(name = "horse_id")
    private HorseEntity horse;


}
