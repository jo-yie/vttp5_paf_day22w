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
            WHERE name like ?; 
    """;

}
