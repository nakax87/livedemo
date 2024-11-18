package com.example.livedemo.entity;

import lombok.Data;
import javax.persistence.*;
import java.time.LocalDateTime;

@Data
@Entity
@Table(name = "event_custom_fields")
public class EventCustomField {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "created_at")
    private LocalDateTime createdAt;

    @Column(name = "updated_at")
    private LocalDateTime updatedAt;

    @Column(name = "field_name", nullable = false)
    private String fieldName;

    @Column(name = "field_type", nullable = false)
    private String fieldType;

    @Column(name = "is_required", nullable = false)
    private Boolean isRequired;

    @ManyToOne
    @JoinColumn(name = "event_id", referencedColumnName = "id")
    private Event event;
}