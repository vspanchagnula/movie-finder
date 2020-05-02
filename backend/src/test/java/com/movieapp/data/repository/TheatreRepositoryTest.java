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
import org.springframework.boot.test.autoconfigure.orm.jpa.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.movieapp.data.entity.Theatre;

@RunWith(SpringJUnit4ClassRunner.class)
@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
public class TheatreRepositoryTest {
    @Autowired
    private TheatreRepository theatreRepository;

    @Autowired
    private TestEntityManager testEntityManager;

    @Before
    public void init() {
        Theatre aNewTheatre = new Theatre();
        aNewTheatre.setTheatreName("RAHUL");
        aNewTheatre.setTheatreCity("PUNE");

        testEntityManager.persist(aNewTheatre);
        testEntityManager.flush();
    }

    @Test
    public void testFindByTheatreId() {
        Theatre foundTheatre = theatreRepository.findByTheatreId(2L);

        assertNotNull(foundTheatre);
        assertEquals(foundTheatre.getTheatreName(), "INOX");
    }

    @Test
    public void testFindByTheatreNameAndTheatreCity() {
        Theatre foundTheatre = theatreRepository.findByTheatreNameAndTheatreCity("RAHUL", "PUNE");

        assertNotNull(foundTheatre);
        assertThat(foundTheatre.getTheatreName(), is(equalTo("RAHUL")));
    }
}