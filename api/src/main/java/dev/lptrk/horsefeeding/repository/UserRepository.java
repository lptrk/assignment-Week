package dev.lptrk.horsefeeding.repository;

import dev.lptrk.horsefeeding.entity.UserEty;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepository extends JpaRepository<UserEty, Long> {
    Optional<UserEty> findByEmail(String email);
}
