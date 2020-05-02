package com.movieapp.business.service;

import static org.junit.Assert.assertEquals;
import static org.mockito.Matchers.any;
import static org.mockito.Mockito.when;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.runners.MockitoJUnitRunner;
import org.springframework.boot.test.context.SpringBootTest;

import com.movieapp.business.domain.MovieScreening;
import com.movieapp.data.entity.BookingConfirmation;
import com.movieapp.data.entity.Screening;
import com.movieapp.data.entity.Theatre;
import com.movieapp.data.repository.ScreeningRepository;
import com.movieapp.data.repository.TheatreRepository;

@RunWith(MockitoJUnitRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.NONE)
public class ScreeningServiceTest {
    @Mock
    private ScreeningRepository screeningRepository;

    @Mock
    private TheatreRepository theatreRepository;

    @InjectMocks
    private ScreeningService screeningService;

    @Before
    public void setUp() throws Exception {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void testBookSeats() {
        Theatre aMockTheatre = new Theatre();
        aMockTheatre.setTheatreName("Regal");
        aMockTheatre.setTheatreCity("Oaks");
        aMockTheatre.setTheatreId(2);


        Screening aMockScreening = new Screening();
        aMockScreening.setMovieName("Race 3");
        aMockScreening.setScreenId(2);
        aMockScreening.setScreeningDate(java.sql.Date.valueOf("2020-05-02"));
        aMockScreening.setScreeningTime(java.sql.Time.valueOf("18:00:00"));
        aMockScreening.setScreeningId(1);
        aMockScreening.setBookedTickets(0);
        BookingConfirmation expectedBookingConfirmation = new BookingConfirmation();
        expectedBookingConfirmation.setConfirmationNumber("X456110");
        
        when(screeningService.bookSeats(any(MovieScreening.class))).thenReturn(expectedBookingConfirmation);

        MovieScreening aMovieScreening = new MovieScreening();

        BookingConfirmation bookingConfirmation = screeningService.bookSeats(aMovieScreening);

        assertEquals(expectedBookingConfirmation.getConfirmationNumber(),bookingConfirmation.getConfirmationNumber());
    }


}