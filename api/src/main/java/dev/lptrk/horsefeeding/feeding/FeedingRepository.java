package dev.lptrk.horsefeeding.feeding;

import org.springframework.data.jpa.repository.JpaRepository;

public interface FeedingRepository extends JpaRepository<Feeding, Integer> {
}
