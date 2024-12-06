package com.example.livedemo.model;

import java.time.LocalDateTime;
import lombok.Data;

@Data
public class Event {
    private Long id;
    private String name;
    private String description;
    private LocalDateTime eventDate;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
    private Ticket ticket;
} 