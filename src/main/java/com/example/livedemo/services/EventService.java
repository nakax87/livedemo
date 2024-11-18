package com.example.livedemo.services;

import com.example.livedemo.entities.Event;
import com.example.livedemo.repositories.EventRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class EventService {

    private final EventRepository eventRepository;

    @Autowired
    public EventService(EventRepository eventRepository) {
        this.eventRepository = eventRepository;
    }

    public List<Event> getEventsByOrganizerId(Long organizerId, Pageable pageable) {
        Page<Event> eventPage = eventRepository.findByOrganizerId(organizerId, pageable);
        List<Event> events = eventPage.getContent();

        // Calculate the number of applicants and capacity utilization for each event
        return events.stream().map(event -> {
            int applicants = event.getTickets().size();
            double capacityUtilization = calculateCapacityUtilization(event, applicants);
            event.setApplicants(applicants);
            event.setCapacityUtilization(capacityUtilization);
            return event;
        }).collect(Collectors.toList());
    }

    private double calculateCapacityUtilization(Event event, int applicants) {
        if (event.getTotalCapacity() != null && event.getTotalCapacity() > 0) {
            return (double) applicants / event.getTotalCapacity() * 100;
        }
        return 0;
    }
}