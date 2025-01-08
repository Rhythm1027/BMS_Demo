package com.bms.book_my_show.controller;

import com.bms.book_my_show.model.*;
import com.bms.book_my_show.service.BookingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class BookingController {
    @Autowired
    private BookingService bookingService;
    private BookingRequest bookingRequest;

    @GetMapping("/movies")
    public List<Movie> getAllMovies() {
        return bookingService.getAllMovies();
    }

    @GetMapping("/theatres")
    public List<Theatre> getAllTheatres() {
        return bookingService.getAllTheatres();
    }

    @GetMapping("/movies/{movieId}/time-slots")
    public List<TimeSlot> getTimeSlots(@PathVariable Long movieId) {
        return bookingService.getTimeSlotsForMovie(movieId);
    }

    @PostMapping("/bookings")
    public Booking bookTimeSlot(@RequestBody BookingRequest bookingRequest) {
        return bookingService.bookTimeSlot(bookingRequest);
    }

    @PostMapping("/addMovies")
    public void addMovie(@RequestBody Movie movie) {
        return bookingService.addMovie(movie);
    }

    @GetMapping("/movies/{movieId}")
    public String getMovieById(@PathVariable Long movieId) {
        return bookingService.getMovieById(movieId);
    }

    @PutMapping("/movies")
    public void updateMovie(@RequestBody Movie movie){
        bookingService.updateMovie(movie);
    }

    @DeleteMapping("/deleteMovie/{id}")
    public void deleteMovie(@PathVariable Long id){
        bookingService.deleteMovie(id);
    }

    @RequestMapping(value = "/error")
    public String error() {
        return "Error handling";
    }
}
