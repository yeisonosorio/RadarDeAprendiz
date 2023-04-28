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

public class GetStudentEvaluationStepDefinition extends Configuracion {
    private Response response;
    private Actor actor;
    public static Logger LOGGER = Logger.getLogger(String.valueOf(GetStudentEvaluationStepDefinition.class));

    @Given("que el usuario tienne acceso a los servicios API REST de la pagina Radar")
    public void queElUsuarioTienneAccesoALosServiciosAPIRESTDeLaPaginaRadar() {
        try {
            actor = Actor.named("usuario")
                    .whoCan(CallAnApi.at(UrlResources.GET_STUDENT_EVALUATION_BASE_URL.getValue()));
            LOGGER.info("API disponibles para realizar la peticion");
            LOGGER.info("Inicio de automatizacion en API Radar ");
        } catch (Exception e) {
            LOGGER.info(" fallo configuración inicial de API Radar");
            LOGGER.warning(e.getMessage());
            e.printStackTrace();
        }
    }

    @When("el usuario envia una solicitud GET para ver las evaluaciones de estudiantes por su id {string}")
    public void elUsuarioEnviaUnaSolicitudGETParaVerLasEvaluacionesDeEstudiantesPorSuId(String id) {
        try {
            actor.attemptsTo(DoGet.doGet().withTheResource(UrlResources.GET_STUDENT_EVALUATION_RESOURCE.getValue()+id));
            response = SerenityRest.lastResponse();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Then("el usuario debe recibir un codigo de estado {int}")
    public void elUsuarioDebeRecibirUnCodigoDeEstado(Integer code) {
        try {
            response.then().statusCode(code);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Then("la respuesta JSON debe mostrar las evaluaciones de estudiantes")
    public void laRespuestaJSONDebeMostrarLasEvaluacionesDeEstudiantes() {
        try {
            List<Map<String, Object>> studentEvaluations = response.jsonPath().getList("");
            assertThat("La lista de evaluaciones de estudiantes no debe estar vacía", studentEvaluations, is(not(empty())));
            for (Map<String, Object> studentEvaluation : studentEvaluations) {
                System.out.println("studentEvaluation: " + studentEvaluation);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
