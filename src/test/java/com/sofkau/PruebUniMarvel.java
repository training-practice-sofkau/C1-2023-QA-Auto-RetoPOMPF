package com.sofkau;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.notNullValue;
import static org.hamcrest.Matchers.greaterThan;
import static org.hamcrest.core.IsEqual.equalTo;

public class PruebUniMarvel {

    @Test
    public void testMarvelCharacterInfo() {
        // Configurar la base URL y la clave de la API
        RestAssured.baseURI = "https://gateway.marvel.com";
        String id = "1011334";
        String apiKey = "519be85584de1be15e49e05d435430d6";
        String ts = "1";
        String hash = "5dcd64e699b6a72f1e891978296aba78";

        // Hacer la solicitud a la API
        Response response = given()
                .log()
                .all()
                .when()
                .get("/v1/public/characters/" + id + "?apikey=" + apiKey + "&ts=" + ts + "&hash=" + hash)
                .then()
                .log()
                .all()
                .statusCode(200)
                .extract()
                .response();

        // Verificar que se recibió información detallada sobre Iron Man
        response.then().body("data.results.name", equalTo("3-D Man"));
        response.then().body("data.results.description", notNullValue());
        response.then().body("data.results.series.available", greaterThan(0));
    }

}
