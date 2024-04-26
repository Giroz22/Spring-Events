package com.riwi.events.services.abstracService;

import java.util.List;

import com.riwi.events.entity.Event;

public interface IEventService {
    public List<Event> findAll();
    public Event findById(String id);
    public Event save(Event event);
    public Event update(String id, Event event);
    public void delete(String id);
}
