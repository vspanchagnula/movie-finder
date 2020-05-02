package com.movieapp.web.application;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.movieapp.business.service.MovieService;
import com.movieapp.business.service.ScreeningService;
import com.movieapp.data.entity.Movie;

@RestController
@CrossOrigin(origins="http://localhost:4200")
public class MovieController {
    private static final DateFormat DATE_FORMAT = new SimpleDateFormat("yyyy-MM-dd");

    @Autowired
    private ScreeningService screeningService;
    
    @Autowired
    private MovieService movieService;

    @GetMapping("/movies")
    public Set<Movie> getMovies(@RequestParam(value = "date", required = false)String dateString) {
        Date date = checkAndDefaultDate(dateString);
        Set<Movie> movies = this.screeningService.getMoviesByDate(date);
        return movies;
    }
    
    @GetMapping("/searchMovie")
    public Movie getMovieByName(@RequestParam(value = "movieName", required = true)String movieName) {
    	return movieService.getMovieDetailsByName(movieName);
    }

	private Date checkAndDefaultDate(String dateString) {
		Date date = null;
        if (dateString != null) {
            try {
                date = DATE_FORMAT.parse(dateString);

            } catch (ParseException pe) {
                date = new Date();
            }
        } else {
            date = new Date();
        }
		return date;
	}
    
}
