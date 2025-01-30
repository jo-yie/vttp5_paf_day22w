package vttp5_paf_day22w.controller;

import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import vttp5_paf_day22w.model.Rsvp;
import vttp5_paf_day22w.service.RsvpService;

@RestController
public class RsvpController {

    @Autowired
    private RsvpService rsvpService;

    // task 2A
    @GetMapping("/api/rsvps")
    public ResponseEntity<Object> getAlLRsvps() { 

        try {
            return ResponseEntity
                .ok()
                .body(rsvpService.getAlLRsvps()); 

        } catch (Exception e) { 
            return ResponseEntity
                .badRequest()
                .body(e.getMessage());

        }

    }

    // task 2B 
    @GetMapping("/api/rsvp")
    public ResponseEntity<Object> getRsvpByName(@RequestParam String q) { 

        Optional<List<Rsvp>> results = rsvpService.getRsvpByName(q);

        try { 
            return ResponseEntity
                .ok()
                .body(results.get());
            
        } catch (Exception e) { 
            return ResponseEntity
                .status(HttpStatus.NOT_FOUND)
                .body(Map.of("Error", e.getMessage()));

        }

    }
    
}
