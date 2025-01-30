package vttp5_paf_day22w.repo;

import java.util.LinkedList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
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
    public List<Rsvp> getAlLRsvps() { 

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
    
}
