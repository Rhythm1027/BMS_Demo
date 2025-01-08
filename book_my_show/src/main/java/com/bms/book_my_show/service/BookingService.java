package com.bms.book_my_show.service;

import com.bms.book_my_show.model.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.*;

@Service
public class BookingService {
    private static final Logger log = LoggerFactory.getLogger(BookingService.class);
    private final List<Movie> movies = new ArrayList<>();
    private final List<Theatre> theatres = new ArrayList<>();
    private final Map<Long, List<TimeSlot>> timeSlots = new HashMap<>();
    private final List<Booking> bookings = new ArrayList<>();

//    @Autowired
//    private BookingRepository bookingRepository;
//    private BookingRequest bookingRequest;

    public BookingService() {

        Theatre theatre1 = new Theatre(1L, "Cineplex A", "Downtown");
        Theatre theatre2 = new Theatre(2L, "Cinema B", "Uptown");
        theatres.add(theatre1);
        theatres.add(theatre2);

        // Initialize hardcoded movies
        movies.add(new Movie(1L, "Inception"));
        movies.add(new Movie(2L, "Avatar"));

        // Initialize hardcoded time slots
        timeSlots.put(1L, List.of(
                new TimeSlot(1L, "10:00 AM", theatre1),
                new TimeSlot(2L, "02:00 PM", theatre2)
        ));
        timeSlots.put(2L, List.of(
                new TimeSlot(3L, "12:00 PM", theatre1),
                new TimeSlot(4L, "06:00 PM", theatre2)
        ));
    }

    public List<Movie> getAllMovies() {
        return movies;
    }

    public List<Theatre> getAllTheatres() {
        return theatres;
    }

    public List<TimeSlot> getTimeSlotsForMovie(Long movieId) {
        return timeSlots.getOrDefault(movieId, new ArrayList<>());
    }

    public Booking bookTimeSlot(@RequestBody BookingRequest bookingRequest) {
        if (bookingRequest == null) {
            throw new RuntimeException("BookingRequest is null");
        }
        log.info("BookingRequest: {}", bookingRequest);

        if (bookingRequest.getMovieId() == null || bookingRequest.getTimeSlotId() == null) {
            throw new RuntimeException("MovieId or TimeSlotId is null in BookingRequest");
        }

        // Proceed with the booking logic
        Movie movie = movies.stream().filter(m -> m.getId() == bookingRequest.getMovieId()).findFirst()
                .orElseThrow(() -> new RuntimeException("Movie not found"));

        TimeSlot timeSlot = timeSlots.getOrDefault(bookingRequest.getMovieId(), new ArrayList<>()).stream()
                .filter(ts -> Objects.equals(ts.getId(), bookingRequest.getTimeSlotId())).findFirst()
                .orElseThrow(() -> new RuntimeException("Time slot not found"));

        Booking booking = new Booking(bookingRequest.getUserName(), movie, timeSlot);
        bookings.add(booking);
        return booking;
    }
    public String getMovieById(Long movieId){
        Movie movie = movies.stream().filter(m->m.getId()==movieId).findFirst()
                .orElseThrow(() -> new RuntimeException("Movie not found"));
        return movie.getName();
    }

    public void updateMovie(Movie movie) {
//        System.out.println(movies.get(0));
        int index = 0;
        for (int i=0;i<movies.size();i++) {
            if (Objects.equals(movies.get(i).getId(),movie.getId())) {
                index = i;
//                break;
            }
        }
        movies.set(index,movie);
    }

    public void deleteMovie(Long id) {
        for(int i=0;i<movies.size();i++){
            if(Objects.equals(movies.get(i).getId(),id)){
                movies.remove(i);
                break;
            }
        }
    }

    public void addMovie(Movie movie) {
        
    }
}
