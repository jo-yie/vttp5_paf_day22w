package vttp5_paf_day22w.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import vttp5_paf_day22w.model.Rsvp;
import vttp5_paf_day22w.repo.RsvpRepository;

@Service
public class RsvpService {

    @Autowired
    private RsvpRepository rsvpRepository; 

    // task 2A
    public List<Rsvp> getAlLRsvps() { 

        return rsvpRepository.getAlLRsvps();

    }

    // task 2B 
    public Optional<List<Rsvp>> getRsvpByName(String in) { 

        return rsvpRepository.getRsvpByName(in);

    }
    
}
