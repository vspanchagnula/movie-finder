package com.movieapp.cucumber;
import java.net.URI;
import java.net.URISyntaxException;

import org.junit.Assert;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

import com.movieapp.data.entity.Movie;

import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class StepDefinition {

	private static final String API_HOST =  "http://localhost:8080";
    private static final String MOVIES_URL_PATH = "/movies";
    private static final String AUTHENTICATE_URL_PATH = "/authenticate";
    
    private static final String APPLICATION_JSON = "application/json";
    
    private RestTemplate restTemplate = new RestTemplate();
    Movie[] listOfMovies = null;
    
    @When("^get all movies api is called$")
    public void getAllMovies() throws URISyntaxException 
    {
        final String baseUrl = API_HOST+ MOVIES_URL_PATH;
        URI uri = new URI(baseUrl);
         
        HttpHeaders headers = new HttpHeaders();
        headers.set("Authorization", "Bearer eyJhbGciOiJIUzUxMiJ9.eyJzdWIiOiJhZG1pbiIsImV4cCI6MTU4OTE0MDMwOCwiaWF0IjoxNTg4NTM1NTA4fQ.8ZJSqO-oB2KrO0yiOJg2ozG-0H09ICArJLypzX3vHgLG2T3MeWaH2cvoa7969xRhDV5p2XSrMSk6jsjrkH7-sw"); 
        HttpEntity request = new HttpEntity( headers);
         
        ResponseEntity<Movie[]> response = restTemplate.exchange(uri, HttpMethod.GET, request, Movie[].class);

         
        Assert.assertEquals(200, response.getStatusCodeValue());
         listOfMovies = response.getBody();
    }
    
    @Then("^movie results are returned$")
    public void checkResults() throws URISyntaxException 
    {
        Assert.assertNotNull(listOfMovies[0]);
    }
}