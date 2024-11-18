package com.example.livedemo.entity;

import lombok.Data;
// import com.example.livedemo.entity.EventCustomField; // Removed unused import
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.time.LocalDate;
import java.time.LocalDateTime;

@Entity
@Table(name = "events")
@Data
public class Event {
    @Id
    private Long id;
    private String name;
    @Column(name = "title", nullable = false)
    private String title;
    @Column(name = "description")
    private String description;
    @Column(name = "start_date")
    private LocalDate startDate;
    @Column(name = "end_date")
    private LocalDate endDate;
    @Column(name = "recruitment_start_date")
    private LocalDate recruitmentStartDate;
    @Column(name = "recruitment_end_date")
    private LocalDate recruitmentEndDate;
    private LocalDate eventDate;
    private Integer registrations;
    @Column(name = "status")
    private String status; // Assuming status is kept for backward compatibility
    @Column(name = "event_type")
    private String eventType;
    private Double satisfactionRate;
    private Integer revenue;
    private LocalDateTime createdAt;
}