package stepdefinitions;


import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import io.cucumber.java.en.Then;

import java.util.logging.Logger;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.junit.Assert;
import org.junit.jupiter.api.Assertions;
import setup.WebUI;

import static io.restassured.RestAssured.get;
import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.*;

public class APIStepDefinitions extends WebUI {
    private Response response;
    private JSONObject jsonresponse;
    private JSONArray jsonarray = null;
    private String jsonString;
    private static Logger LOGGER = Logger.getLogger(String.valueOf(APIStepDefinitions.class));

    @Given("que tengo acceso al listado de criptomonedas populares en Coingecko")
    public void que_tengo_acceso_al_listado_de_criptomonedas_populares_en_coingecko() {
        setUplog4j();
        RestAssured.baseURI = "https://api.coingecko.com/api/v3";
    }


    @When("verifico el listado de las criptos mas populares")
    public void verifico_el_listado_de_las_criptos_mas_populares() throws ParseException {
        RestAssured.basePath = "/search/trending";
        String response = get().asString();
        JSONParser parser = new JSONParser();
        JSONObject jsonObject = (JSONObject) parser.parse(response);

        jsonarray = (JSONArray) jsonObject.get("coins");
        given()
                .when()
                .get("/")
                .then()
                .statusCode(200)
                .body("coins.size()", equalTo(jsonarray.size()));

    }

    @When("obtengo una codigo de respuesta exitoso")
    public void obtengo_una_codigo_de_respuesta_exitoso() {
        try {
            int statusCode = given()
                    .when()
                    .get("/")
                    .then()
                    .extract()
                    .statusCode();
            Assert.assertEquals(200, statusCode);
        } catch (Exception e) {
            e.getMessage();
            Assertions.fail();
        }
    }

    @Then("puedo ver unicamente el nombre y el simbolo de las nueve criptomonedas populares")
    public void puedo_ver_unicamente_el_nombre_y_el_simbolo_de_las_nueve_criptomonedas_populares() {


        LOGGER.info("La lista de criptomonedas populares es la siguiente:");
        String tableFormat = "%-20s%-20s%-20s%n";
        String tableHeader = String.format(tableFormat, "Nombre", "Simbolo", "ID");
        String tableBody = "";
        try {
            for (int i = 0; i < jsonarray.size(); i++) {
                JSONObject currency = (JSONObject) jsonarray.get(i);
                JSONObject currencyData = (JSONObject) currency.get("item");
                String name = (String) currencyData.get("name");
                String symbol = (String) currencyData.get("symbol");
                String id = (String) currencyData.get("id");
                Assert.assertNotNull(symbol, "El campo symbol es null en la criptomoneda " + symbol);
                Assert.assertNotNull(id, "El campo id es null en la criptomoneda " + id);
                tableBody += String.format(tableFormat, name, symbol, id);
            }
        } catch (Exception e) {
            LOGGER.severe(e.getMessage());
            Assertions.fail();
        }
        LOGGER.info(tableHeader + tableBody);
    }


    @Given("que tengo acceso a un listado de criptomonedas en Coingecko")
    public void que_tengo_acceso_a_un_listado_de_criptomonedas_en_coingecko() {
        setUplog4j();
        RestAssured.baseURI = "https://api.coingecko.com/api/v3";
    }


    @When("hago una peticion con el {string} de una criptomoneda")
    public void hago_una_peticion_con_el_id_de_una_criptomoneda(String string) {
        String id = string;
        RestAssured.basePath = "/coins/" + id;
        response = get();
        jsonString = response.getBody().asString();
        JSONParser parser = new JSONParser();

        try {
            jsonresponse = (JSONObject) parser.parse(jsonString);
        } catch (ParseException e) {
            LOGGER.warning("Error parsing JSON response: " + e.getMessage());
        }
    }

    @Then("obtengo un codigo de respuesta exitoso")
    public void obtengo_un_codigo_de_respuesta_exitoso() {
        try {
            int statusCode = given()
                    .when()
                    .get("/")
                    .then()
                    .extract()
                    .statusCode();
            Assert.assertEquals(200, statusCode);
        } catch (Exception e) {
            e.getMessage();
            Assertions.fail();
        }
    }

    @Then("la respuesta contiene la informacion detallada de la criptomoneda y su valor en USD")
    public void la_respuesta_contiene_la_informacion_detallada_de_la_criptomoneda_y_su_valor_en_usd() {
        try {
            JSONParser parser = new JSONParser();
            JSONObject jsonResponse = (JSONObject) parser.parse(response.getBody().asString());
            JSONObject marketData = (JSONObject) jsonResponse.get("market_data");
            JSONObject currentPrice = (JSONObject) marketData.get("current_price");
            String currentPriceUSD = currentPrice.get("usd").toString();
            String description = ((JSONObject) jsonResponse.get("description")).get("es").toString();
            String id = (String) jsonResponse.get("id");
            String symbol = (String) jsonResponse.get("symbol");
            String name = (String) jsonResponse.get("name");

            Assert.assertNotNull("Current price in USD es null", currentPriceUSD);
            Assert.assertNotNull("Description in ES es null", description);
            Assert.assertNotNull("ID es null", id);
            Assert.assertNotNull("Symbol es null", symbol);
            Assert.assertNotNull("Name es null", name);


            LOGGER.info(String.format("| %-20s | %-20s | %-20s | %-10s | %-20s |", "Nombre", "Simbolo", "ID", "Precio en USD", "Descripcion"));
            LOGGER.info(String.format("| %-20s | %-20s | %-20s | %-10s | %-20s |", name, symbol, id, currentPriceUSD, description));
        } catch (ParseException e) {
            LOGGER.severe("Error parsing response body: " + e.getMessage());
            Assert.fail("Error parsing response body: " + e.getMessage());
        } catch (NullPointerException e) {
            LOGGER.severe("Response body is null");
            Assert.fail("Response body is null");
        }
    }
}
