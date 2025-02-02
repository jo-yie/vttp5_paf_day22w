package vttp5_paf_day22w.repo;

import java.util.LinkedList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;
import org.springframework.stereotype.Repository;

import vttp5_paf_day22w.model.Rsvp;
import vttp5_paf_day22w.utils.Queries;

@Repository
public class RsvpRepository {

    @Autowired
    private JdbcTemplate template; 

    // task 2A
    public List<Rsvp> getAllRsvps() { 

        SqlRowSet rs = template.queryForRowSet(Queries.SQL_GET_ALL_RSVP);
        List<Rsvp> results = new LinkedList<>();

        while (rs.next()) {
            results.add(Rsvp.toRsvp(rs));

        }

        return results;

    }

    // task 2B 
    public Optional<List<Rsvp>> getRsvpByName(String in) { 

        SqlRowSet rs = template.queryForRowSet(Queries.SQL_GET_RSVP_BY_NAME,
            "%" + in + "%");
        List<Rsvp> results = new LinkedList<>();

        while (rs.next()) {
            results.add(Rsvp.toRsvp(rs));

        }

        if (results.isEmpty() || results.equals(null)) {
            return Optional.empty();

        }

        return Optional.ofNullable(results);

    }

    // task 2C 
    public int insertRsvp(Rsvp rsvp) { 

        int idFromDb = getId(rsvp.getEmail());

        // email is not in db 
        if (idFromDb == 0) { 
            return template.update(Queries.SQL_INSERT_RSVP,
                rsvp.getName(),
                rsvp.getEmail(),
                rsvp.getPhone(),
                rsvp.getConfirmDate(), 
                rsvp.getComments());

        }

        // email is in db 
        // update existing entry
        else { 
            return updateRsvp(rsvp);

        }

    }

    // helper method 
    // return 0 if email not in db
    public int getId(String email) { 

        try { 
            int idFromDb = template.queryForObject(Queries.SQL_GET_RSVP_ID, 
            Integer.class, email);
            return idFromDb;

        } catch (EmptyResultDataAccessException e) {
            return 0;

        }

    }

    // task 2D 
    public int updateRsvp(Rsvp rsvp) {

        return template.update(Queries.SQL_UPDATE_RSVP,
            rsvp.getName(), 
            rsvp.getPhone(), 
            rsvp.getConfirmDate(), 
            rsvp.getComments(), 
            rsvp.getEmail());

    }
    
}
