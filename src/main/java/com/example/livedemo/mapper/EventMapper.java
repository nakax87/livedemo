package com.example.livedemo.mapper;

import com.example.livedemo.entity.Event;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface EventMapper {
    
    @Select("SELECT * FROM events ORDER BY event_date DESC")
    List<Event> findAll();
    
    @Select("SELECT * FROM events WHERE id = #{id}")
    Event findById(Long id);
    
    @Insert("INSERT INTO events (name, event_date, registrations, status, satisfaction_rate, revenue) " +
            "VALUES (#{name}, #{eventDate}, #{registrations}, #{status}, #{satisfactionRate}, #{revenue})")
    @Options(useGeneratedKeys = true, keyProperty = "id")
    void insert(Event event);
    
    @Update("UPDATE events SET name = #{name}, event_date = #{eventDate}, " +
            "registrations = #{registrations}, status = #{status}, " +
            "satisfaction_rate = #{satisfactionRate}, revenue = #{revenue} " +
            "WHERE id = #{id}")
    void update(Event event);
    
    @Delete("DELETE FROM events WHERE id = #{id}")
    void delete(Long id);
} 