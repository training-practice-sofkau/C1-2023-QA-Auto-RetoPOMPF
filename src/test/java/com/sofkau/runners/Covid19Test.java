package com.sofkau.runners;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        snippets = CucumberOptions.SnippetType.CAMELCASE,
        features = {"src/test/resources/features/COVID19_Service1.feature"},
        glue = {"com.sofkau.stepdefinitions"},
        publish = true
)
public class Covid19Test {
}
