package dev.lptrk.horsefeeding.repository;

import dev.lptrk.horsefeeding.entity.Stable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

public interface StableRepository extends JpaRepository<Stable, Integer> {
}
