package vttp5_paf_day22w.model;

import java.sql.Date;

import org.springframework.jdbc.support.rowset.SqlRowSet;

public class Rsvp {

    private int rsvpId; 
    private String name;
    private String phone;
    private Date confirmDate; 
    private String comments;
    public Rsvp() {
    }
    public Rsvp(int rsvpId, String name, String phone, Date confirmDate, String comments) {
        this.rsvpId = rsvpId;
        this.name = name;
        this.phone = phone;
        this.confirmDate = confirmDate;
        this.comments = comments;
    }
    public int getRsvpId() {
        return rsvpId;
    }
    public void setRsvpId(int rsvpId) {
        this.rsvpId = rsvpId;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public String getPhone() {
        return phone;
    }
    public void setPhone(String phone) {
        this.phone = phone;
    }
    public Date getConfirmDate() {
        return confirmDate;
    }
    public void setConfirmDate(Date confirmDate) {
        this.confirmDate = confirmDate;
    }
    public String getComments() {
        return comments;
    }
    public void setComments(String comments) {
        this.comments = comments;
    } 

    public static Rsvp toRsvp(SqlRowSet rs) { 

        Rsvp r = new Rsvp(); 

        r.setRsvpId(rs.getInt("rsvp_id"));
        r.setName(rs.getString("name"));
        r.setPhone(rs.getString("phone"));
        r.setConfirmDate(rs.getDate("confirm_date"));
        r.setComments(rs.getString("comments"));

        return r;

    }
    
}
