package com.example.livedemo.model;

import java.time.LocalDateTime;
import lombok.Data;

@Data
public class Ticket {
    private Long id;
    private Long eventId;
    private Integer price;
    private Integer totalCount;
    private Integer remainingCount;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
} 