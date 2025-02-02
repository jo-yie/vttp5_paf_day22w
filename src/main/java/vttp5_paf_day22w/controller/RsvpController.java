package vttp5_paf_day22w.controller;

import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import vttp5_paf_day22w.model.Rsvp;
import vttp5_paf_day22w.service.RsvpService;

@RestController
public class RsvpController {

    @Autowired
    private RsvpService rsvpService;

    // task 2A
    // all rsvps from database
    // GET /api/rsvps
    @GetMapping(value = "/api/rsvps")
    public ResponseEntity<Object> getAlLRsvps() { 

        try {
            return ResponseEntity
                .ok()
                .body(rsvpService.getAllRsvps()); 

        } catch (Exception e) { 
            return ResponseEntity
                .badRequest()
                .body(e.getMessage());

        }

    }

    // task 2B 
    // search for rsvp by name 
    // GET /api/rsvp?q=fred
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


    /*
        {
            "name": "string",
            "email": "string",
            "phone": "string",
            "confirmDate": "string",
            "comments": "string"
        }   
     */
    // task 2C 
    // add or update rsvp 
    // POST /api/rsvp
    @PostMapping(value = "/api/rsvp", consumes = "application/x-www-form-urlencoded")
    public ResponseEntity<Object> insertRsvp(@RequestParam Map<String, String> data) { 

        int isAdded = rsvpService.insertRsvp(data);

        if (isAdded == 0) {

            return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                .body(Map.of("Error", "Add/Update is unsuccessful"));

        } else {

            return ResponseEntity.ok()
                .body(Map.of("RSVP", "Successfully added/updated"));

        }

    }

    // task 2D 
    // update rsvp 
    // PUT /api/rsvp/fred@gmail.com
    @PutMapping(value = "/api/rsvp/{email}", consumes = "application/x-www-form-urlencoded")
    public ResponseEntity<Object> updateRsvp(@PathVariable String email, @RequestParam Map<String, String> data) { 

        int isUpdated = rsvpService.updateRsvp(email, data);

        if (isUpdated == 0) { 

            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                .body(Map.of("Error","Email is not found"));

        } else {

            return ResponseEntity.ok()
                .body(Map.of("RSVP", "Successfully updated"));

        }
        
    }

}
