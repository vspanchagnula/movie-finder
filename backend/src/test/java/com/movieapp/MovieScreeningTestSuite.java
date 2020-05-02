package com.movieapp;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;

import com.movieapp.business.service.ScreeningServiceTest;
import com.movieapp.data.repository.ScreeningRepositoryTest;
import com.movieapp.web.application.ScreeningControllerTest;

@RunWith(Suite.class)
@Suite.SuiteClasses({ScreeningServiceTest.class, ScreeningControllerTest.class,
        ScreeningRepositoryTest.class})
public class MovieScreeningTestSuite {
}
