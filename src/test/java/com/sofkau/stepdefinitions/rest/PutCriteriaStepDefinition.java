package com.sofkau.stepdefinitions.rest;

import com.sofkau.models.rest.User;
import com.sofkau.setup.Configuracion;
import com.sofkau.utils.UrlResources;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.response.Response;
import net.serenitybdd.rest.SerenityRest;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.rest.abilities.CallAnApi;

import java.util.logging.Logger;

import static com.sofkau.Tasks.rest.DoPut.doPut;
import static com.sofkau.utils.UrlResources.PUT_CRITERIA_RESOURCE;
import static net.serenitybdd.screenplay.rest.questions.ResponseConsequence.seeThatResponse;
import static org.hamcrest.CoreMatchers.equalTo;

public class PutCriteriaStepDefinition extends Configuracion {
    private User user = new User();
    private Response response;
    private Actor actor;
    public static java.util.logging.Logger LOGGER = Logger.getLogger(String.valueOf(PutCriteriaStepDefinition.class));
    @Given("que el usuario se encuentraa en la pagina de radar")
    public void queElUsuarioSeEncuentraaEnLaPaginaDeRadar() {
        try {
            actor = Actor.named("usuario")
                    .whoCan(CallAnApi.at(UrlResources.ACTUALIZAR_CRITERIA_BASE_URL.getValue()));
            LOGGER.info("API disponibles para realizar la peticion");
            LOGGER.info("Inicio de automatizacion en API Radar ");
        } catch (Exception e) {
            LOGGER.info(" fallo configuración inicial de API Radar");
            LOGGER.warning(e.getMessage());
            e.printStackTrace();
        }
    }

    @When("el usuario envia una solicitud PUT con el id {string} el area {string} el name {string} el descriptor {string} el minQualiRequired {string}")
    public void elUsuarioEnviaUnaSolicitudPUTConElIdElAreaElNameElDescriptorElMinQualiRequired(String id, String area, String name, String descriptor, String minQualiRequired) {
        try{
            user.setUid(id);
            user.setArea(area);
            user.setName(name);
            user.setDescriptor(descriptor);
            user.setMinQualiRequired(minQualiRequired);
            actor.attemptsTo(
                    doPut()
                            .withResource(PUT_CRITERIA_RESOURCE.getValue()+id)
                            .andTheRequestBody(user)
            );
            response = SerenityRest.lastResponse();
        }catch (Exception e){
            LOGGER.info("Fallo enviando la informacion");
            LOGGER.warning(e.getMessage());
        }
    }

    @Then("el usuario visualiza las criterias actualizados")
    public void elUsuarioVisualizaLasCriteriasActualizados() {
        actor.should(
                seeThatResponse("La respuesta debería ser exitosa y los datos actualizados coincidir con los enviados",
                        response -> response
                                .statusCode(200)
                                .body("uid", equalTo(user.getUid()))
                                .body("area", equalTo(user.getArea()))
                                .body("name", equalTo(user.getName()))
                                .body("descriptor", equalTo(Boolean.parseBoolean(user.getDescriptor())))
                                .body("minQualiRequired", equalTo(user.getMinQualiRequired()))
                )
        );
    }
}
