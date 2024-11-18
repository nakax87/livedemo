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
    private LocalDateTime updatedAt; // This field matches the schema

    @Column(name = "title", nullable = false)
    private String title;

    @Column(name = "is_online", nullable = false)
    private Boolean isOnline; // Corrected the data type to Boolean

    @Column(name = "is_onsite", nullable = false)
    private Boolean isOnsite; // Corrected the data type to Boolean

    @Column(name = "online_capacity", nullable = false)
    private Integer onlineCapacity; // Corrected the nullable attribute

    @Column(name = "onsite_capacity", nullable = false)
    private Integer onsiteCapacity; // Corrected the nullable attribute

    @Column(name = "status", nullable = false)
    private String status; // Corrected the data type to String

    @Column(name = "event_date", nullable = false)
    private LocalDateTime eventDate; // Corrected the field name and data type

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
        if (isOnline != null && isOnline && onlineCapacity != null && onlineCapacity > 0) { // Corrected the variable name
            return (double) getApplicantsCount() / onlineCapacity * 100;
        }
        return 0;
    }

    // Method to calculate capacity utilization for onsite events
    public double getOnsiteCapacityUtilization() {
        if (isOnsite != null && isOnsite && onsiteCapacity != null && onsiteCapacity > 0) { // Corrected the variable name
            return (double) getApplicantsCount() / onsiteCapacity * 100;
        }
        return 0;
    }
}