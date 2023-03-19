package com.sofka.runners;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        snippets = CucumberOptions.SnippetType.CAMELCASE,
        features = {"src/test/resources/features/compraCategoria.feature"},
        glue = {"com.sofka.stepdefinitions"},
        publish = true
)
public class CompraCategoriaTest {

}