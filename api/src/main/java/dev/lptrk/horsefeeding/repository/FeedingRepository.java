package dev.lptrk.horsefeeding.repository;

import dev.lptrk.horsefeeding.entity.Feeding;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FeedingRepository extends JpaRepository<Feeding, Integer> {
}
