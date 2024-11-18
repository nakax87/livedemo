package com.example.livedemo.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import com.example.livedemo.entity.Event;
import com.example.livedemo.form.EventForm;
import com.example.livedemo.mapper.EventMapper;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

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
    
    @Transactional(rollbackFor = Exception.class)
    public Map<String, Object> createEvent(EventForm form) {
        // Validate the input EventForm to ensure all required fields are present and valid
        if (form.getTitle() == null || form.getDescription() == null || form.getStart_date() == null ||
            form.getEnd_date() == null || form.getRecruitment_start_date() == null || form.getRecruitment_end_date() == null ||
            form.getStatus() == null || form.getEvent_type() == null) {
            throw new IllegalArgumentException("Missing required fields");
        }

        // Check if an event with the same title already exists
        Event existingEvent = eventMapper.findByTitle(form.getTitle());
        if (existingEvent != null) {
            throw new IllegalArgumentException("An event with the same title already exists");
        }

        // Create a new Event object and map the properties from EventForm to the Event object
        Event event = new Event();
        event.setTitle(form.getTitle());
        event.setDescription(form.getDescription());
        event.setStart_date(form.getStart_date());
        event.setEnd_date(form.getEnd_date());
        event.setRecruitment_start_date(form.getRecruitment_start_date());
        event.setRecruitment_end_date(form.getRecruitment_end_date());
        event.setStatus(form.getStatus());
        event.setEvent_type(form.getEvent_type());

        // Use the EventMapper's insert method to save the Event object to the database
        eventMapper.insert(event);

        // After insertion, retrieve the generated event ID and include it in the response map along with a success message
        Map<String, Object> response = new HashMap<>();
        response.put("message", "イベントが正常に作成されました");
        response.put("eventId", event.getId());
        return response;
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