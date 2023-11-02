package dev.lptrk.horsefeeding.repository;

import dev.lptrk.horsefeeding.entity.Stable;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StableRepository extends JpaRepository<Stable, Integer> {
}
