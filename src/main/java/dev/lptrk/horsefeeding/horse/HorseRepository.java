package dev.lptrk.horsefeeding.horse;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface HorseRepository extends JpaRepository<Horse, String> {
    List<Horse> getHorsesByStableId(Integer stableId);
}

