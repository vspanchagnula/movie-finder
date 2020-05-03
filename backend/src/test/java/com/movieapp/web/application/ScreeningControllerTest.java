package com.movieapp.web.application;

import static org.junit.Assert.assertEquals;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.boot.test.context.SpringBootTest;

import com.movieapp.business.domain.MovieScreening;
import com.movieapp.business.service.ScreeningService;
import com.movieapp.data.entity.BookingConfirmation;
import com.movieapp.exception.MovieBookingException;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@RunWith(MockitoJUnitRunner.class)
public class ScreeningControllerTest {

	@InjectMocks
	ScreeningController screeningController;
	@Mock
	ScreeningService screeningServiceMock;


	@Test
	public void testBookSeats() {
		MovieScreening movieScreening = new MovieScreening();
		movieScreening.setMovieName("Avengers");
		movieScreening.setMoviePosterUrl("avengersUrl");
		movieScreening.setNumSeats(5);
		movieScreening.setTheatreCity("Philadelphia");

		BookingConfirmation expectedBookingConfirmation = new BookingConfirmation();
		expectedBookingConfirmation.setConfirmationNumber("X456110");

		Mockito.when(screeningServiceMock.bookSeats(Mockito.any(MovieScreening.class))).thenReturn(expectedBookingConfirmation);

		BookingConfirmation bookingConfirmation = screeningController.bookSeats(movieScreening);

		assertEquals(expectedBookingConfirmation.getConfirmationNumber(), bookingConfirmation.getConfirmationNumber());
	}
	
	@Test(expected = MovieBookingException.class) 
	public void testBookSeats_Exception() {
		MovieScreening movieScreening = new MovieScreening();
		BookingConfirmation expectedBookingConfirmation = new BookingConfirmation();
		expectedBookingConfirmation.setConfirmationNumber("X456110");

		Mockito.when(screeningServiceMock.bookSeats(Mockito.any(MovieScreening.class))).thenThrow(new MovieBookingException("Movie not found", null));

		BookingConfirmation bookingConfirmation = screeningController.bookSeats(movieScreening);

		assertEquals(expectedBookingConfirmation.getConfirmationNumber(), bookingConfirmation.getConfirmationNumber());
	}

}