package com.bms.book_my_show.model;

import com.bms.book_my_show.repository.BookingRepository;

public class BookingRequest {
    private String userName;
    private Long movieId;
    private Long timeSlotId;

    // Getters and Setters
    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public Long getMovieId() {
        return movieId;
    }

    public void setMovieId(Long movieId) {
        this.movieId = movieId;
    }

    public Long getTimeSlotId() {
        return timeSlotId;
    }

    public void setTimeSlotId(Long timeSlotId) {
        this.timeSlotId = timeSlotId;
    }

    @Override
    public String toString() {
        return "BookingRequest{" +
                "userName='" + userName + '\'' +
                ", movieId=" + movieId +
                ", timeSlotId=" + timeSlotId +
                '}';
    }
}
