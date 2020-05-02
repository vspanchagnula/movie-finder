package com.movieapp.web.application;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.movieapp.business.domain.MovieScreening;
import com.movieapp.business.service.ScreeningService;
import com.movieapp.data.entity.BookingConfirmation;

@RestController
@CrossOrigin(origins="http://localhost:4200")
public class ScreeningController {

    @Autowired
    private ScreeningService screeningService;

    @GetMapping("/screenings")
    public List<MovieScreening> getScreenings(@RequestParam(value = "movie", required = true)String movieString) {
        return this.screeningService.getMovieScreeningsByMovie(movieString);
    }

	
    @PostMapping("/bookSeats")
	 public BookingConfirmation bookSeats(@RequestBody MovieScreening movieBooking) {
    	System.out.println();
	   return this.screeningService.bookSeats(movieBooking);
	  }
	 
}
