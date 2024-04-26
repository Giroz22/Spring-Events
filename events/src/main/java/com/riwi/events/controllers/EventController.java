package com.riwi.events.controllers;

import org.springframework.web.bind.annotation.RestController;

import com.riwi.events.entity.Event;
import com.riwi.events.services.abstracService.IEventService;

import lombok.AllArgsConstructor;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.PutMapping;

@RestController
@RequestMapping("/api/v1/events")
@AllArgsConstructor
public class EventController {

    private final IEventService eventService;

    @GetMapping("")
    public ResponseEntity<List<Event>> getAll() {
        return ResponseEntity.ok(this.eventService.findAll());
    }
    
    @GetMapping("/{id}")
    public ResponseEntity<Event> findById(@PathVariable String id){
        return ResponseEntity.ok(this.eventService.findById(id));
    }

    @PostMapping("")
    public ResponseEntity<Event> save(@RequestBody Event event) {
        Event objEvent = this.eventService.save(event);

        if (objEvent == null) return ResponseEntity.badRequest().build();

        return ResponseEntity.ok(objEvent);
    }
    
    @PutMapping("/{id}")
    public ResponseEntity<Event> update(@PathVariable String id, @RequestBody Event event) {   

        return ResponseEntity.ok(this.eventService.update(id, event));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable String id) {
        this.eventService.delete(id);
        return ResponseEntity.ok().build();
    }
}
