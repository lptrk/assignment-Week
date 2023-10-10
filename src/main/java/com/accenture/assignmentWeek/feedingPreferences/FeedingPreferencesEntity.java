package com.accenture.assignmentWeek.feedingPreferences;

import com.accenture.assignmentWeek.horse.HorseEntity;
import jakarta.persistence.*;

@Entity
public class FeedingPreferencesEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id; // Eindeutige Kennung (ID) für die Fütterungspräferenzen

    @ManyToOne
    @JoinColumn(name = "horse_id")
    private HorseEntity horse; // Das Pferd, für das die Präferenzen festgelegt sind

    private String foodType; // Art des Futters (z. B. Heu, Hafer, Müsli)
    private int minFeedingsPerDay; // Mindestanzahl der täglichen Fütterungen
    private int maxFeedingsPerDay; // Maximale Anzahl der täglichen Fütterungen
    private int preferredFeedingsPerDay;
}
