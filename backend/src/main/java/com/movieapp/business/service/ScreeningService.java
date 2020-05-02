package com.movieapp.business.service;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.apache.commons.lang3.RandomStringUtils;
import org.springframework.stereotype.Service;

import com.movieapp.business.domain.MovieScreening;
import com.movieapp.data.entity.BookingConfirmation;
import com.movieapp.data.entity.Movie;
import com.movieapp.data.entity.Screening;
import com.movieapp.data.entity.Theatre;
import com.movieapp.data.repository.MovieRepository;
import com.movieapp.data.repository.ScreeningRepository;
import com.movieapp.data.repository.TheatreRepository;
import com.movieapp.exception.MovieBookingException;

@Service
public class ScreeningService {
    private ScreeningRepository screeningRepository;
    private MovieRepository movieRepository;
    private TheatreRepository theatreRepository;

    public ScreeningService(ScreeningRepository screeningRepository, MovieRepository movieRepository, TheatreRepository theatreRepository) {
        this.screeningRepository = screeningRepository;
        this.movieRepository = movieRepository;
        this.theatreRepository = theatreRepository;
    }

    private Screening getScreening(MovieScreening movieScreening) {
        Theatre theatre = theatreRepository.findByTheatreNameAndTheatreCity(movieScreening.getTheatreName(), movieScreening.getTheatreCity());
        if (theatre == null)
            return null;
        return screeningRepository.findByMovieNameAndTheatreIdAndScreeningDateAndScreeningTime(movieScreening.getMovieName(), theatre.getTheatreId(),
                java.sql.Date.valueOf(movieScreening.getScreeningDate()), java.sql.Time.valueOf(movieScreening.getScreeningTime()));
    }
    
    public BookingConfirmation bookSeats(MovieScreening movieScreening) {
    	try {
	        Screening screening = getScreening(movieScreening);
	        screening.setBookedTickets(screening.getBookedTickets()+movieScreening.getNumSeats());
	        screeningRepository.save(screening);
	        return generateConfirmationDetails();
    	}catch(Exception e) {
    		throw new MovieBookingException("Exception processing screeningByMovie",e);
    	}
    }

    private BookingConfirmation generateConfirmationDetails() {
    	BookingConfirmation bookingConfirmation = new BookingConfirmation();
    	int length = 10;
	    boolean useLetters = true;
	    boolean useNumbers = false;
	    bookingConfirmation.setConfirmationNumber(RandomStringUtils.random(length, useLetters, useNumbers));
	    return bookingConfirmation;
		
	}

	public Set<Movie> getMoviesByDate(Date date) {
        Iterable<Screening> screenings = this.screeningRepository.findByScreeningDate(new java.sql.Date(date.getTime()));
        Set<Movie> movies = new HashSet<>();
        if (screenings != null) {
            for (Screening screening : screenings) {
                Movie movie = movieRepository.findByMovieName(screening.getMovieName());
                movies.add(movie);
            }
        }
        return movies;
    }

    public List<Screening> getScreeningsByMovie(String movieName) {
        return this.screeningRepository.findByMovieName(movieName);
    }

    public List<MovieScreening> getMovieScreeningsByMovie(String movieName) {
    	List<MovieScreening> movieScreenings = new ArrayList<>();
    	try {
    		Iterable<Screening> screenings = this.screeningRepository.findByMovieName(movieName);
            if (screenings != null) {
                for (Screening screening : screenings) {
                    MovieScreening movieScreening = new MovieScreening();
                    Theatre theatre = theatreRepository.findByTheatreId(screening.getTheatreId());
                    Movie movie = movieRepository.findByMovieName(screening.getMovieName());

                    movieScreening.setMovieName(screening.getMovieName());
                    movieScreening.setMoviePosterUrl(movie.getMoviePosterUrl());

                    if (theatre != null) {
                        movieScreening.setTheatreId(theatre.getTheatreId());
                        movieScreening.setTheatreName(theatre.getTheatreName());
                        movieScreening.setTheatreCity(theatre.getTheatreCity());
                    }
                    movieScreening.setScreeningDate(screening.getScreeningDate().toString());
                    movieScreening.setScreeningTime(screening.getScreeningTime().toString());

                    movieScreenings.add(movieScreening);
                }
            }
    	}catch(Exception e) {
    		throw new MovieBookingException("Exception processing screeningByMovie",e);
    	}
        

        return movieScreenings;
    }
}
