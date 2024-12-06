package com.example.livedemo.repositories;

import com.example.livedemo.entities.Event;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface EventRepository extends JpaRepository<Event, Long> {
    Page<Event> findByOrganizerId(Long organizerId, Pageable pageable);

    Optional<Event> findEventById(Long id);
}