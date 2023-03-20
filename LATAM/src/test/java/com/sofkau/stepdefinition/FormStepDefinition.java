package com.sofkau.stepdefinition;

import com.sofkau.pages.FormPage;
import com.sofkau.setup.WebUI;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.apache.log4j.Logger;
import org.junit.jupiter.api.Assertions;

public class FormStepDefinition extends WebUI {



    public static Logger LOGGER = Logger.getLogger(FormStepDefinition.class);
    @Given("que el usuario esta en la pagina Web LATAM Airlines")
    public void que_el_usuario_esta_en_la_pagina_web_latam_airlines() {
        generalSetUp();
    }
    @When("escoge los destinos {string} y {string}")
    public void escoge_los_destinos_y(String ida, String vuelta) throws InterruptedException {
      FormPage formPage = new FormPage(super.driver);
      formPage.chooseFlight(ida, vuelta);
    }
    @When("complementa los campos con la informacion de la familia")
    public void complementa_los_campos_con_la_informacion_de_la_familia() {
        FormPage formPage = new FormPage(super.driver);
        formPage.fillMandatoryFields();

    }
    @Then("debe observar un mensaje de bienvenida de la LATAM")
    public void debe_observar_un_mensaje_de_bienvenida_de_la_latam() {
        FormPage formPage = new FormPage(super.driver);
        String ass = formPage.assertion1();
        try {
            Assertions.assertEquals("Si ya eres parte de LATAM, ingresa tus datos:",formPage.assertion1());
            LOGGER.info(formPage.assertion1() + " = Si ya eres parte de LATAM, ingresa tus datos:"  );
            quitDriver();
        } catch (Exception e) {
            LOGGER.warn(e.getMessage());
            Assertions.fail();
            quitDriver();
        }
    }

}