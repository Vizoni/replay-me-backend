package com.raphaelvizoni.replayme.repository;

import com.raphaelvizoni.replayme.entity.Replay;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ReplayRepository
        extends JpaRepository<Replay, Long> {
}