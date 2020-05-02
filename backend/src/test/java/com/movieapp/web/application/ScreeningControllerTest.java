package com.movieapp.web.application;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.springframework.boot.test.context.SpringBootTest;

import com.movieapp.business.domain.MovieScreening;
import com.movieapp.business.service.ScreeningService;
import com.movieapp.data.entity.BookingConfirmation;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class ScreeningControllerTest {

	@Mock
	ScreeningController screeningController;
	
	@Before
	public void setUp() throws Exception {
		MockitoAnnotations.initMocks(this);
	}

	@Test
	public void testBookSeats() {
		MovieScreening movieScreening = new MovieScreening();
		movieScreening.setMovieName("Avengers");
		movieScreening.setMoviePosterUrl("avengersUrl");
		movieScreening.setNumSeats(5);
		movieScreening.setTheatreCity("Philadelphia");

		BookingConfirmation expectedBookingConfirmation = new BookingConfirmation();
		expectedBookingConfirmation.setConfirmationNumber("X456110");

		ScreeningService screeningServiceMock = Mockito.mock(ScreeningService.class);
		Mockito.when(screeningServiceMock.bookSeats(movieScreening)).thenReturn(expectedBookingConfirmation);

		BookingConfirmation bookingConfirmation = screeningController.bookSeats(movieScreening);

		assertEquals(expectedBookingConfirmation.getConfirmationNumber(), bookingConfirmation.getConfirmationNumber());
	}

}