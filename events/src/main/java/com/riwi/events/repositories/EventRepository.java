package com.riwi.events.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.riwi.events.entity.Event;

@Repository
public interface EventRepository extends JpaRepository<Event, String> {
    
}
