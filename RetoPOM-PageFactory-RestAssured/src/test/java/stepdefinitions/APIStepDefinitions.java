package stepdefinitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import io.cucumber.java.en.Then;
import java.util.logging.Logger;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.junit.Assert;


public class APIStepDefinitions {
    private RequestSpecification request;
    private Response response;
    private String endpoint = "/search/trending";
    private static Logger LOGGER = Logger.getLogger(APIStepDefinitions.class.getName());
    @Given("que tengo acceso al listado de criptomonedas populares en Coingecko")
    public void que_tengo_acceso_al_listado_de_criptomonedas_populares_en_coingecko() {
        request = RestAssured.given();
    }


    @When("quiero verificar las {int} criptos mas populares")
    public void quiero_verificar_las_criptos_mas_populares(Integer int1) {
        response = request.get(endpoint);
        Assert.assertEquals(response.getStatusCode(), 200);
    }

    @Then("la respuesta debe ser exitosa y puedo ver la informacion de las criptomonedas")
    public void la_respuesta_debe_ser_exitosa_y_puedo_ver_la_informacion_de_las_criptomonedas(){
        // Write code here that turns the phrase above into concrete actions
        throw new io.cucumber.java.PendingException();
    }

    @Given("un listado de criptomonedas populares en Coingecko")
    public void un_listado_de_criptomonedas_populares_en_coingecko() {
        // Write code here that turns the phrase above into concrete actions
        throw new io.cucumber.java.PendingException();
    }

    @When("hago una peticion con el \\{id} ID de una criptomoneda")
    public void hago_una_peticion_con_el_id_de_una_criptomoneda() {
        // Write code here that turns the phrase above into concrete actions
        throw new io.cucumber.java.PendingException();
    }

    @Then("la respuesta contiene la informacion detallada de la criptomoneda")
    public void la_respuesta_contiene_la_informacion_detallada_de_la_criptomoneda() {
        // Write code here that turns the phrase above into concrete actions
        throw new io.cucumber.java.PendingException();
    }

}
