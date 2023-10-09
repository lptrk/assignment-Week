package com.accenture.assignmentWeek.feeding;

import com.accenture.assignmentWeek.horse.HorseEntity;
import jakarta.persistence.*;

import java.time.LocalTime;

@Entity
public class FeedingScheduleEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private LocalTime feedingTime; // Zeitpunkt der Fütterung
    private int numberOfFeedings; // Anzahl der Fütterungen pro Tag

    @ManyToOne
    @JoinColumn(name = "horse_id")
    private HorseEntity horse; // Verweis auf das betreffende Pferd

}
