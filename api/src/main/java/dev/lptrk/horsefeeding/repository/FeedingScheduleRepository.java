package dev.lptrk.horsefeeding.repository;

import dev.lptrk.horsefeeding.entity.FeedingSchedule;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FeedingScheduleRepository extends JpaRepository<FeedingSchedule, Integer> {

}
