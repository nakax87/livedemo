package com.example.livedemo.mapper;

import com.example.livedemo.model.Event;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import java.util.List;

@Mapper
public interface EventMapper {
    @Select("SELECT " +
           "e.id, e.name, e.description, e.event_date, e.created_at, e.updated_at, " +
           "t.id as \"ticket.id\", " +
           "t.event_id as \"ticket.eventId\", " +
           "t.price as \"ticket.price\", " +
           "t.total_count as \"ticket.totalCount\", " +
           "t.remaining_count as \"ticket.remainingCount\", " +
           "t.created_at as \"ticket.createdAt\", " +
           "t.updated_at as \"ticket.updatedAt\" " +
           "FROM events e " +
           "LEFT JOIN tickets t ON e.id = t.event_id " +
           "ORDER BY e.event_date")
    List<Event> findAll();
} 