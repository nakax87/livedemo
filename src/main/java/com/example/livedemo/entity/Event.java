package com.example.livedemo.entity;

import lombok.Data;
import java.time.LocalDate;
import java.time.LocalDateTime;

@Data
public class Event {
    private Long id;
    private String name;
    private LocalDate eventDate;
    private Integer registrations;
    private String status;
    private Double satisfactionRate;
    private Integer revenue;
    private LocalDateTime createdAt;
} 