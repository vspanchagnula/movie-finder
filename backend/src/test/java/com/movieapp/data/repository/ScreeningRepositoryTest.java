package com.movieapp.data.repository;

import static org.junit.Assert.assertNotNull;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.movieapp.data.entity.Screening;

@RunWith(SpringJUnit4ClassRunner.class)
@DataJpaTest
public class ScreeningRepositoryTest {

    @Autowired
    ScreeningRepository screeningRepository;

    @Autowired
    TestEntityManager testEntityManager;

    private static final DateFormat DATE_FORMAT = new SimpleDateFormat("yyyy-MM-dd");
    Date date;
    
	@Before
	public void loadTestData() {

		try {
			date = DATE_FORMAT.parse("2020-05-02");
		} catch (ParseException e) {
			date = new Date();
		}
		Screening screening = new Screening();
		screening.setBookedTickets(24);
		screening.setMovieName("Avengers");
		screening.setScreeningDate(new java.sql.Date(date.getTime()));
		screening.setScreeningTime(java.sql.Time.valueOf("10:00:00"));
		screening.setTheatreId(1);

		testEntityManager.persist(screening);
		testEntityManager.flush();
	}

    @Test
    public void findByScreeningDate() {

        List<Screening> foundScreenings = screeningRepository.findByScreeningDate(new java.sql.Date(date.getTime()));
        assertNotNull(foundScreenings);
    }

    @Test
    public void findByMovieNameAndTheatreIdAndScreeningDateAndScreeningTime() {
        Screening foundScreening = screeningRepository.findByMovieNameAndTheatreIdAndScreeningDateAndScreeningTime("Avengers",
                1, java.sql.Date.valueOf("2020-05-02"), java.sql.Time.valueOf("10:00:00"));

        assertNotNull(foundScreening);
    }
}