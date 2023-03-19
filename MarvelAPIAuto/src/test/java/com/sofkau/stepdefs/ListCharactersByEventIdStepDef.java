package com.sofkau.stepdefs;

import com.sofkau.setup.MarvelCon;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.jupiter.api.Assertions;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class ListCharactersByEventIdStepDef extends MarvelCon {
    Logger log = LoggerFactory.getLogger(ListCharactersByEventIdStepDef.class);

    @Given("I was given a private and public key")
    public void iWasGivenAPrivateAndPublicKey() {
        try {
            log.info("Starting connection...");
            getToBaseURL();
        } catch (Exception e) {
            log.error(e.getMessage());
        }
    }

    @When("I make a request to the Marvel API to get the characters who participated in an event with id {string}")
    public void iMakeARequestToTheMarvelAPIToGetTheCharactersWhoParticipatedInAnEventWithId(String id) {
        try {
            log.info("Successful connection. Sending request...");
            whenGet(addParams(charactersByEventIdURL(id)));
        } catch (Exception e) {
            log.error(e.getMessage());
        }
    }

    @Then("I will obtain a list of characters who participated in an event with id {string}, each one identified with unique id")
    public void iWillObtainAListOfCharactersWhoParticipatedInAnEventWithIdEachOneIdentifiedWithUniqueId(String id) {
        try {
            log.info("Test passed");
            validateCharactersIdByEventId(addParams(charactersByEventIdURL(id)));
        } catch (Exception e){
            log.error(e.getMessage());
            Assertions.fail();
        }
    }
}