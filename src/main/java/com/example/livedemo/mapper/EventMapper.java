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
    
    @Select("SELECT * FROM events WHERE title = #{title}")
    Event findByTitle(String title);

    @Insert("INSERT INTO events (title, description, start_date, end_date, recruitment_start_date, recruitment_end_date, status, event_type) " +
            "VALUES (#{title}, #{description}, #{startDate}, #{endDate}, #{recruitmentStartDate}, #{recruitmentEndDate}, #{status}, #{eventType})")
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