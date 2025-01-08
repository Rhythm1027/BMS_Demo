package com.bms.book_my_show.model;

import jakarta.persistence.Entity;

@Entity
public class Booking {
    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public Movie getMovie() {
        return movie;
    }

    public void setMovie(Movie movie) {
        this.movie = movie;
    }

    public TimeSlot getTimeSlot() {
        return timeSlot;
    }

    public void setTimeSlot(TimeSlot timeSlot) {
        this.timeSlot = timeSlot;
    }

    private Long id;
    private String userName;
    private Movie movie;
    private TimeSlot timeSlot;

    public Booking(String userName, Movie movie, TimeSlot timeSlot) {
        this.userName = userName;
        this.movie = movie;
        this.timeSlot = timeSlot;
    }
}
