package vttp5_paf_day22w.utils;

public class Queries {
    
    // task 2A
    public static final String SQL_GET_ALL_RSVP = 
    """
        SELECT * 
            FROM rsvp;
    """;

    // task 2B 
    public static final String SQL_GET_RSVP_BY_NAME = 
    """
        SELECT * 
            FROM rsvp 
            WHERE name LIKE ?; 
    """;

    // task 2C 
    public static final String SQL_INSERT_RSVP = 
    """
        INSERT INTO rsvp (name, email, phone, confirm_date, comments)
            VALUES (?, ?, ?, ?, ?);
    """;

    // helper method 
    // return id if email exists in db
    public static final String SQL_GET_RSVP_ID = 
    """
        SELECT rsvp_id
            FROM rsvp 
            WHERE email = ?;
    """;

    // task 2D 
    public static final String SQL_UPDATE_RSVP = 
    """
        UPDATE rsvp 
        SET 
            name = ?, 
            phone = ?,
            confirm_date = ?,
            comments = ?
        WHERE 
            email = ?;
    """;

    // task 2E 
    public static final String SQL_COUNT_RSVP = 
    """
        SELECT COUNT(*) 
            FROM rsvp; 
    """;

}
