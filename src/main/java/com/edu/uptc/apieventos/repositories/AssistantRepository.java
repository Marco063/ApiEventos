package com.edu.uptc.apieventos.repositories;

import com.edu.uptc.apieventos.entities.Assistant;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface AssistantRepository extends JpaRepository<Assistant, Integer> {

    @Query("SELECT a.email FROM Assistant a WHERE a.event.id=:eventId")
    List<String> findEmailsByEventId(@Param("eventId") Integer eventId);

}
