package com.example.livedemo.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
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
    private Integer onlineCapacity; // This field matches the schema

    @Column(name = "is_onsite", nullable = false)
    private Integer onsiteCapacity; // This field matches the schema

    @Column(name = "online_capacity")
    private Integer onlineCapacity;

    @Column(name = "onsite_capacity")
    private Integer onsiteCapacity;

    @Column(name = "status") // This field was added in the update migration
    private LocalDateTime recruitmentStartDate;

    @Column(name = "event_date") // This field was added in the update migration
    private LocalDateTime recruitmentEndDate;

    @Column(name = "status")
    private String status;

    @Column(name = "event_date")
    private LocalDateTime eventDate;

    @Column(name = "total_capacity")
    private Integer totalCapacity;

    @OneToMany(mappedBy = "event")
    private Set<Ticket> tickets;

    // Getters and setters for existing fields are omitted for brevity

    // Method to calculate the number of applicants
    public int getApplicantsCount() {
        return tickets != null ? tickets.size() : 0;
    }

    // Method to calculate capacity utilization for online events
    public double getOnlineCapacityUtilization() {
        if (isOnline != null && isOnline && onlineCapacity != null && onlineCapacity > 0) {
            return (double) getApplicantsCount() / onlineCapacity * 100;
        }
        return 0;
    }

    // Method to calculate capacity utilization for onsite events
    public double getOnsiteCapacityUtilization() {
        if (isOnsite != null && isOnsite && onsiteCapacity != null && onsiteCapacity > 0) {
            return (double) getApplicantsCount() / onsiteCapacity * 100;
        }
        return 0;
    }
}