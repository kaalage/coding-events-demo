package org.launchcode.codingevents.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * Created by Chris Bay
 */
@Controller
@RequestMapping("events")
public class EventController {

    private static HashMap<String, String> events = new HashMap<>();

    @GetMapping
    public String displayAllEvents(Model model) {
        events.put("SLAM Underground", "The Saint Louis Art Museum collects, presents, interprets, and conserves works of art of the highest quality.");
        events.put("One-Day Folk Fest", "Don’t miss this festival dedicated to folk music! Through live musical performances, activities for all ages.");
        events.put("Zootoberfest", "Visit the Zoo for a free, family-friendly Oktoberfest!");
        model.addAttribute("events", events);
        return "events/index";
    }

    @GetMapping("create")
    public String displayCreateEventForm(Model model) {
        model.addAttribute("title", "Create Event");
        return "events/create";
    }

    @PostMapping("create")
    public String processCreateEventForm(@RequestParam String eventName, String eventDescription) {
        events.put(eventName, eventDescription);
        return "redirect:";
    }

}
