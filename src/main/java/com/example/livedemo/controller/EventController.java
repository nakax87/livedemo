package com.example.livedemo.controller;

import com.example.livedemo.mapper.EventMapper;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

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
} 