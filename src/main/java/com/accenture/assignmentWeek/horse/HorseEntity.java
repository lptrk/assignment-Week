package com.accenture.assignmentWeek.horse;

import com.accenture.assignmentWeek.stable.StableEntity;
import jakarta.persistence.*;

import java.time.LocalDateTime;

@Entity
public class HorseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private String rfid;
    private String name;
    private String nickName;
    private String breed;
    private String owner;

    @ManyToOne
    @JoinColumn(name = "stable_id")
    private StableEntity stable;

    private LocalDateTime lastFeedingTime;
    private Integer numberODailyFeedings;
}
