package com.example.livedemo.entities;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.Set;

@Entity
@Table(name = "events")
public class Event {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "created_at", nullable = false)
    private LocalDateTime createdAt;

    @Column(name = "updated_at", nullable = false)
    private LocalDateTime updatedAt;

    @Column(name = "title", nullable = false)
    private String title;

    @Column(name = "is_online", nullable = false)
    private Boolean isOnline;

    @Column(name = "is_onsite", nullable = false)
    private Boolean isOnsite;

    @Column(name = "online_capacity")
    private Integer onlineCapacity;

    @Column(name = "onsite_capacity")
    private Integer onsiteCapacity;

    @Column(name = "recruitment_start_date", nullable = false)
    private LocalDateTime recruitmentStartDate;

    @Column(name = "recruitment_end_date", nullable = false)
    private LocalDateTime recruitmentEndDate;

    @Column(name = "total_capacity")
    private Integer totalCapacity;

    @OneToMany(mappedBy = "event")
    private Set<Ticket> tickets;

    // Getters and setters are omitted for brevity
}