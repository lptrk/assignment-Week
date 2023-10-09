package com.accenture.assignmentWeek.horse;

import com.accenture.assignmentWeek.feeding.FeedingScheduleEntity;
import com.accenture.assignmentWeek.stable.StableEntity;
import jakarta.persistence.*;

import java.time.LocalDateTime;
import java.util.List;

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

    @OneToMany(mappedBy = "horse")
    private List<FeedingScheduleEntity> feedingSchedules;


    private LocalDateTime lastFeedingTime;
    private Integer numberOfDailyFeedings;
}
