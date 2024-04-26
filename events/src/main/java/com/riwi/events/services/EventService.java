package com.riwi.events.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.riwi.events.entity.Event;
import com.riwi.events.repositories.EventRepository;
import com.riwi.events.services.abstracService.IEventService;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class EventService implements IEventService{
    @Autowired
    private final EventRepository eventRepository;

    @Override
    public List<Event> findAll() {
        return eventRepository.findAll();
    }

    @Override
    public Event findById(String id) {
        return this.eventRepository.findById(id).orElse(null);
    }

    @Override
    public Event save(Event event) {

        if(!event.getId().equals("")) return null;

        return this.eventRepository.save(event);
    }

    @Override
    public Event update(String id, Event eventUpdate) {
        Event eventFind = this.eventRepository.findById(id).orElse(null);

        if (eventFind == null) return null;        

        eventFind = eventUpdate;
        eventFind.setId(id);

        return this.eventRepository.save(eventFind);        
    }

    @Override
    public void delete(String id) {
        Event event = this.eventRepository.findById(id).orElse(null);
        if (event ==  null) new Exception("ID not found");

        this.eventRepository.delete(event);
    }
    
}
