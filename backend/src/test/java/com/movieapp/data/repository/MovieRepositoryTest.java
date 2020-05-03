package com.movieapp.data.repository;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.movieapp.data.entity.Movie;
import com.movieapp.exception.MovieBookingException;

@RunWith(SpringJUnit4ClassRunner.class)
@DataJpaTest
public class MovieRepositoryTest {

	@Autowired
	MovieRepository movieRepository;

	@Autowired
	TestEntityManager testEntityManager;

	
	@Test
	public void findByMovieName() {
		Movie movie = new Movie();
		movie.setMovieName("Lion King");
		movie.setMovieId(123);

		testEntityManager.persist(movie);
		testEntityManager.flush();

		Movie foundMovie = movieRepository.findByMovieName("Lion King");

		assertNotNull(foundMovie);
		assertEquals(foundMovie.getMovieName(), movie.getMovieName());
	}
	
	@Test
	public void findByMovieName_butNotMovieFound() {
		Movie movie = new Movie();
		movie.setMovieName("Lion King2");
		movie.setMovieId(123);

		testEntityManager.persist(movie);
		testEntityManager.flush();

		Movie foundMovie = movieRepository.findByMovieName("Lion King");

		assertNull(foundMovie);
	}
	 
}