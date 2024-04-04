package com.edu.uptc.apieventos.repositories;

import com.edu.uptc.apieventos.entities.Event;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EventRepository extends JpaRepository<Event, Integer> {
}
