package com.example.livedemo.controllers;

import com.example.livedemo.entities.Event;
import com.example.livedemo.services.EventService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

@RestController
public class EventController {

    private final EventService eventService;

    public EventController(EventService eventService) {
        this.eventService = eventService;
    }

    @GetMapping("/events")
    public List<EventDTO> getEventList(@RequestParam Long organizerId,
                                       @RequestParam(defaultValue = "0") int page,
                                       @RequestParam(defaultValue = "10") int size) {
        Page<Event> eventsPage = eventService.getEventsByOrganizerId(organizerId, PageRequest.of(page, size));
        List<Event> events = eventsPage.getContent();

        if (events.isEmpty()) {
            throw new RuntimeException("No events found for the given organizer.");
        }

        return events.stream().map(event -> {
            int applicants = event.getApplicantsCount();
            double capacityUtilizationOnline = event.getOnlineCapacityUtilization();
            double capacityUtilizationOnsite = event.getOnsiteCapacityUtilization();
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