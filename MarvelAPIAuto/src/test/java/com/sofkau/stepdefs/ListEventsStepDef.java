package com.sofkau.stepdefs;

import com.sofkau.setup.MarvelCon;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.jupiter.api.Assertions;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class ListEventsStepDef extends MarvelCon {
    private final Logger log = LoggerFactory.getLogger(ListEventsStepDef.class);

    @Given("I was granted a private and public key")
    public void iWasGrantedAPrivateAndPublicKey() {
        try {
            log.info("Starting connection...");
            getToBaseURL();
        } catch (Exception e) {
            log.error(e.getMessage());
        }
    }

    @When("I make a request to the Marvel API to get the list of events that occurred in their comics")
    public void iMakeARequestToTheMarvelAPIToGetTheListOfEventsThatOccurredInTheirComics() {
        try {
            log.info("Successful connection. Sending request...");
            whenGet(addParams(eventsURL()));
        } catch (Exception e) {
            log.error(e.getMessage());
        }
    }

    @Then("I will obtain the list of events, each one identified with a unique id")
    public void iWillObtainTheListOfEventsEachOneIdentifiedWithAUniqueId() {
        try {
            log.info("Test passed");
            validateEventsId(addParams(eventsURL()));
        } catch (Exception e){
            log.error(e.getMessage());
            Assertions.fail();
        }
    }
}