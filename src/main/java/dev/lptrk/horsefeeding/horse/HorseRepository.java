package dev.lptrk.horsefeeding.horse;

import org.springframework.data.jpa.repository.JpaRepository;

public interface HorseRepository extends JpaRepository<Horse, String> {
}

