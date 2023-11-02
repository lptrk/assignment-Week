package dev.lptrk.horsefeeding.repository;

import dev.lptrk.horsefeeding.entity.Horse;
import org.springframework.data.jpa.repository.JpaRepository;

public interface HorseRepository extends JpaRepository<Horse, String> {
}

