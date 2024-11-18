package com.example.livedemo.entities;

import javax.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.Set;

@Entity
@Table(name = "tickets")
public class Ticket {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "created_at", nullable = false)
    private LocalDateTime createdAt;

    @Column(name = "updated_at", nullable = false)
    private LocalDateTime updatedAt;

    @Column(name = "type", nullable = false)
    private String type;

    @Column(name = "price", nullable = false)
    private BigDecimal price;

    @Column(name = "is_free", nullable = false)
    private Boolean isFree;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "event_id", nullable = false)
    private Event event;

    @OneToMany(mappedBy = "ticket", fetch = FetchType.LAZY)
    private Set<Participant> participants;

    // Getters and setters omitted for brevity
}