package com.example.livedemo.controller;

import com.example.livedemo.mapper.EventMapper;
import com.example.livedemo.model.Event;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@Controller
public class EventController {
    private final EventMapper eventMapper;

    public EventController(EventMapper eventMapper) {
        this.eventMapper = eventMapper;
    }

    @GetMapping("/")
    public String index(Model model) {
        model.addAttribute("events", eventMapper.findAll());
        return "index";
    }

    @GetMapping("/events/{id}")
    public String detail(@PathVariable("id") Long id, Model model) {
        Event event = eventMapper.findById(id);
        model.addAttribute("event", event);
        return "detail";
    }
}
