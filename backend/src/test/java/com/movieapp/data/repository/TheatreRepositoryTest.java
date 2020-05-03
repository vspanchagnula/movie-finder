package com.movieapp.data.repository;

import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertThat;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.movieapp.data.entity.Theatre;

@RunWith(SpringJUnit4ClassRunner.class)
@DataJpaTest
public class TheatreRepositoryTest {
    @Autowired
    private TheatreRepository theatreRepository;

    @Autowired
    private TestEntityManager testEntityManager;

    @Before
    public void init() {
        Theatre theatre = new Theatre();
        theatre.setTheatreName("Regal");
        theatre.setTheatreCity("Philadelpha");
        theatre.setTheatreId(2);

        testEntityManager.persist(theatre);
        testEntityManager.flush();
    }

    @Test
    public void testFindByTheatreId() {
        Theatre foundTheatre = theatreRepository.findByTheatreId(2L);

        assertNotNull(foundTheatre);
        assertEquals(foundTheatre.getTheatreName(), "Regal");
    }

    @Test
    public void testFindByTheatreNameAndTheatreCity() {
        Theatre foundTheatre = theatreRepository.findByTheatreNameAndTheatreCity("Regal", "Philadelpha");

        assertNotNull(foundTheatre);
        assertThat(foundTheatre.getTheatreName(), is(equalTo("Regal")));
    }
}