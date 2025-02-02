package vttp5_paf_day22w.service;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Map;
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
    public List<Rsvp> getAllRsvps() { 

        return rsvpRepository.getAllRsvps();

    }

    // task 2B 
    public Optional<List<Rsvp>> getRsvpByName(String in) { 

        return rsvpRepository.getRsvpByName(in);

    }

    // task 2C 
    public int insertRsvp(Map<String, String> data) { 

        Rsvp r = mapToRsvpPojo(data);
        return rsvpRepository.insertRsvp(r);

    }
    
    // helper method 
    // yyyy-MM-dd
    private Date stringToDate(String in) {

        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");

        try { 
            Date date= sdf.parse(in);
            return date; 

        } catch (Exception e) { 
            return null;

        }

    }

    // task 2D
    public int updateRsvp(String email, Map<String, String> data) { 

        if (rsvpRepository.getId(email) == 0) {
            return 0;

        } else { 
            Rsvp r = mapToRsvpPojo(data);
            return rsvpRepository.updateRsvp(r);

        }

    }

    // helper method 
    // Map<String, String> to Rsvp POJO 
    private Rsvp mapToRsvpPojo(Map<String, String> data) { 

        Rsvp r = new Rsvp(); 
        r.setName(data.get("name"));
        r.setEmail(data.get("email"));
        r.setPhone(data.get("phone"));

        Date date = stringToDate(data.get("confirmDate"));
        r.setConfirmDate(date);
        r.setComments(data.get("comments"));

        return r; 

    }

    // task 2D 
    public int countAllRsvps() { 

        return rsvpRepository.countAllRsvps();

    }
    
}
