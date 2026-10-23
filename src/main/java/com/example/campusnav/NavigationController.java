
package com.example.campusnav;

import org.springframework.web.bind.annotation.*;
import java.util.Map;

@RestController
@CrossOrigin
public class NavigationController {

    private final Graph graph = new Graph();

    public NavigationController() {
        graph.addPath("Main Gate", "Library", 100);
        graph.addPath("Main Gate", "CSE Block", 300);
        graph.addPath("Library", "CSE Block", 120);
        graph.addPath("Library", "Canteen", 80);
        graph.addPath("Canteen", "CSE Block", 100);
        graph.addPath("CSE Block", "Admin Block", 150);
        graph.addPath("Library", "Admin Block", 350);
    }

    @GetMapping("/api/locations")
    public Object locations() {
        return graph.getLocations();
    }

    @GetMapping("/api/route")
    public Map<String, Object> route(
            @RequestParam String start,
            @RequestParam String end) {
        return graph.shortestPath(start, end);
    }
}
