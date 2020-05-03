Feature: Testing a REST API
  Users should be able to submit GET and POST requests to a web service, represented by WireMock

  Scenario: Data Upload to a web service
    When get all movies api is called
    Then movie results are returned