package com.bms.book_my_show.model;


public class TimeSlot {
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTimeSlot() {
        return timeSlot;
    }

    public void setTimeSlot(String timeSlot) {
        this.timeSlot = timeSlot;
    }

    public Theatre getTheatre() {
        return theatre;
    }

    public void setTheatre(Theatre theatre) {
        this.theatre = theatre;
    }

    private Long id;
    private String timeSlot;
    private Theatre theatre;

    public TimeSlot(Long id, String timeSlot, Theatre theatre) {
        this.id = id;
        this.timeSlot = timeSlot;
        this.theatre = theatre;
    }

}
