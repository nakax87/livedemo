package com.example.livedemo.service;

import com.example.livedemo.entity.Event;
import com.example.livedemo.form.EventForm;
import com.example.livedemo.mapper.EventMapper;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class EventService {
    
    private final EventMapper eventMapper;
    
    public EventService(EventMapper eventMapper) {
        this.eventMapper = eventMapper;
    }
    
    public List<Event> getAllEvents() {
        return eventMapper.findAll();
    }
    
    public Event getEvent(Long id) {
        return eventMapper.findById(id);
    }
    
    @Transactional
    public void createEvent(EventForm form) {
        Event event = new Event();
        event.setName(form.getName());
        event.setEventDate(form.getEventDate());
        event.setRegistrations(form.getRegistrations());
        event.setStatus(form.getStatus());
        event.setSatisfactionRate(form.getSatisfactionRate());
        event.setRevenue(form.getRevenue());
        
        eventMapper.insert(event);
    }
    
    @Transactional
    public void updateEvent(Long id, EventForm form) {
        Event event = new Event();
        event.setId(id);
        event.setName(form.getName());
        event.setEventDate(form.getEventDate());
        event.setRegistrations(form.getRegistrations());
        event.setStatus(form.getStatus());
        event.setSatisfactionRate(form.getSatisfactionRate());
        event.setRevenue(form.getRevenue());
        
        eventMapper.update(event);
    }
    
    @Transactional
    public void deleteEvent(Long id) {
        eventMapper.delete(id);
    }
} 