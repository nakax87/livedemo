package com.example.livedemo.controllers;

import com.example.livedemo.entities.Event;
import com.example.livedemo.services.EventService;
import org.springframework.data.domain.PageRequest;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestBody;

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
        List<Event> events = eventService.getEventsByOrganizerId(organizerId, PageRequest.of(page, size));

        if (events.isEmpty()) {
            throw new RuntimeException("No events found for the given organizer.");
        }

        return events.stream().map(event -> {
            int applicants = event.getApplicantsCount();
            double capacityUtilization = event.getCapacityUtilization();
            return new EventDTO(
                    event.getId(),
                    applicants,
                    event.getTotalCapacity(),
                    event.getStatus(),
                    event.getEventDate(),
                    capacityUtilization
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
        private double capacityUtilization;

        public EventDTO(Long eventId, int applicants, int capacity, String status, LocalDateTime date,
                        double capacityUtilization) {
            this.eventId = eventId;
            this.applicants = applicants;
            this.capacity = capacity;
            this.status = status;
            this.date = date;
            this.capacityUtilization = capacityUtilization;
        }

        // Getters and setters omitted for brevity
    }
}