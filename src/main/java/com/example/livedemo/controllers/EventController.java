package com.example.livedemo.controllers;

import com.example.livedemo.entities.Event;
import com.example.livedemo.services.EventService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.stream.Collectors;

@RestController
public class EventController {

    @Autowired
    private EventService eventService;

    @GetMapping("/events")
    public List<EventDTO> getEventList(@RequestParam Long organizerId,
                                       @RequestParam(defaultValue = "0") int page,
                                       @RequestParam(defaultValue = "10") int size) {
        Page<Event> eventsPage = eventService.getEventsByOrganizerId(organizerId, page, size);
        List<Event> events = eventsPage.getContent();

        if (events.isEmpty()) {
            throw new RuntimeException("No events found for the given organizer.");
        }

        return events.stream().map(event -> {
            int applicants = event.getTickets().size();
            double capacityUtilizationOnline = event.getIsOnline() ? (double) applicants / event.getOnlineCapacity() * 100 : 0;
            double capacityUtilizationOnsite = event.getIsOnsite() ? (double) applicants / event.getOnsiteCapacity() * 100 : 0;
            return new EventDTO(
                    event.getId(),
                    applicants,
                    event.getTotalCapacity(),
                    event.getStatus(),
                    event.getEventDate(),
                    capacityUtilizationOnline,
                    capacityUtilizationOnsite
            );
        }).collect(Collectors.toList());
    }

    // DTO class to represent event data
    public static class EventDTO {
        private Long eventId;
        private int applicants;
        private int capacity;
        private String status;
        private LocalDateTime date;
        private double onlineCapacityUtilization;
        private double onsiteCapacityUtilization;

        public EventDTO(Long eventId, int applicants, int capacity, String status, LocalDateTime date,
                        double onlineCapacityUtilization, double onsiteCapacityUtilization) {
            this.eventId = eventId;
            this.applicants = applicants;
            this.capacity = capacity;
            this.status = status;
            this.date = date;
            this.onlineCapacityUtilization = onlineCapacityUtilization;
            this.onsiteCapacityUtilization = onsiteCapacityUtilization;
        }

        // Getters and setters omitted for brevity
    }
}