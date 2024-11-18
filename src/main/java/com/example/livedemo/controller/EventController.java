package com.example.livedemo.controller;

import com.example.livedemo.form.EventForm;
import com.example.livedemo.service.EventService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/events")
public class EventController {
    
    private final EventService eventService;
    
    public EventController(EventService eventService) {
        this.eventService = eventService;
    }
    
    @GetMapping
    public String list(Model model) {
        model.addAttribute("events", eventService.getAllEvents());
        return "events/list";
    }
    
    @GetMapping("/create")
    public String createForm(@ModelAttribute EventForm form) {
        return "events/create";
    }
    
    @PostMapping("/create")
    public String create(@ModelAttribute EventForm form) {
        eventService.createEvent(form);
        return "redirect:/events";
    }
    
    @GetMapping("/{id}/edit")
    public String editForm(@PathVariable Long id, Model model) {
        model.addAttribute("event", eventService.getEvent(id));
        return "events/edit";
    }
    
    @PostMapping("/{id}/edit")
    public String edit(@PathVariable Long id, @ModelAttribute EventForm form) {
        eventService.updateEvent(id, form);
        return "redirect:/events";
    }
    
    @PostMapping("/{id}/delete")
    public String delete(@PathVariable Long id) {
        eventService.deleteEvent(id);
        return "redirect:/events";
    }
} 