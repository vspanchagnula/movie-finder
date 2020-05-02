package com.movieapp.business.service;

import org.springframework.stereotype.Service;

import com.movieapp.data.entity.Movie;
import com.movieapp.data.repository.MovieRepository;

@Service
public class MovieService {
	 private MovieRepository movieRepository;
	 
	 public MovieService( MovieRepository movieRepository) {
	        this.movieRepository = movieRepository;
	 }
	 
	 public Movie getMovieDetailsByName(String movieName) {
		 return movieRepository.findByMovieName(movieName);
	 }

}
