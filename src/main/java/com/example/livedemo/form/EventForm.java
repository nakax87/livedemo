package com.example.livedemo.form;

import lombok.Data;
import java.time.LocalDate;

@Data
public class EventForm {
    private Long id;
    private String name;
    private LocalDate eventDate;
    private Integer registrations;
    private String status;
    private Double satisfactionRate;
    private Integer revenue;
} 