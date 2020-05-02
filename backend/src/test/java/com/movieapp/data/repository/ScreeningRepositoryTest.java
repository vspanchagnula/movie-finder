package com.movieapp.data.repository;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertNotNull;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.movieapp.data.entity.Screening;

@RunWith(SpringJUnit4ClassRunner.class)
@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
public class ScreeningRepositoryTest {

    @Autowired
    ScreeningRepository screeningRepository;

    @Autowired
    TestEntityManager testEntityManager;

    private static final DateFormat DATE_FORMAT = new SimpleDateFormat("yyyy-MM-dd");

    @Test
    public void findByScreeningDate() {
        Date date;
        try {
            date = DATE_FORMAT.parse("2020-05-02");
        } catch (ParseException e) {
            date = new Date();
        }

        List<Screening> foundScreenings = screeningRepository.findByScreeningDate(new java.sql.Date(date.getTime()));

        assertNotNull(foundScreenings);
        assertNotEquals(foundScreenings.size(), 0);
    }

    @Test
    public void findByMovieNameAndTheatreIdAndScreeningDateAndScreeningTime() {
        Screening foundScreening = screeningRepository.findByMovieNameAndTheatreIdAndScreeningDateAndScreeningTime("Avengers",
                1, java.sql.Date.valueOf("2018-05-25"), java.sql.Time.valueOf("10:00:00"));

        assertNotNull(foundScreening);
        assertEquals(foundScreening.getMovieName(), "Deadpool 2");
    }
}