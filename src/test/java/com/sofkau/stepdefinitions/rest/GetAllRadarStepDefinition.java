package com.sofkau.stepdefinitions.rest;

import com.sofkau.Tasks.rest.DoGet;
import com.sofkau.setup.Configuracion;
import com.sofkau.utils.UrlResources;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.response.Response;
import net.serenitybdd.rest.SerenityRest;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.rest.abilities.CallAnApi;

import java.util.List;
import java.util.Map;
import java.util.logging.Logger;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;

public class GetAllRadarStepDefinition extends Configuracion {
    private Response response;
    private Actor actor;
    public static Logger LOGGER = Logger.getLogger(String.valueOf(GetAllRadarStepDefinition.class));
    @Given("que el usuariio tiene acceso a los servicios API REST de la pagina Radar")
    public void queElUsuariioTieneAccesoALosServiciosAPIRESTDeLaPaginaRadar() {
        try {
            actor = Actor.named("usuario")
                    .whoCan(CallAnApi.at(UrlResources.GET_ALL_RADARES_BASE_URL.getValue()));
            LOGGER.info("API disponibles para realizar la peticion");
            LOGGER.info("Inicio de automatizacion en API Radar ");
        } catch (Exception e) {
            LOGGER.info(" fallo configuración inicial de API Radar");
            LOGGER.warning(e.getMessage());
            e.printStackTrace();
        }
    }

    @When("el usuario envia una solicitud GET para ver todos los radares")
    public void elUsuarioEnviaUnaSolicitudGETParaVerTodosLosRadares() {
        try {
            actor.attemptsTo(DoGet.doGet().withTheResource(UrlResources.GET_RADAR_RESOURCE.getValue()));
            response = SerenityRest.lastResponse();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Then("el usuario deberia recibir un codigo de estado {int}")
    public void elUsuarioDeberiaRecibirUnCodigoDeEstado(Integer code) {
        try {
            response.then().statusCode(code);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Then("la respuesta JSON debe mostrar todos los radares")
    public void laRespuestaJSONDebeMostrarTodosLosRadares() {
        try {
            List<Map<String, Object>> usuarios = response.jsonPath().getList("");
            assertThat("La lista de todos los radares no debe estar vacía", usuarios, is(not(empty())));
            for (Map<String, Object> usuario : usuarios) {
                System.out.println("Usuario: " + usuario);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
