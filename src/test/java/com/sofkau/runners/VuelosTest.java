package com.sofkau.runners;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        snippets = CucumberOptions.SnippetType.CAMELCASE,
        features = {"src/test/resources/features/Vuelos.feature"},
        glue = {"com.sofkau.stepdefinitions"},
        publish = true,
        tags = "@Second"
)
public class VuelosTest {
}
