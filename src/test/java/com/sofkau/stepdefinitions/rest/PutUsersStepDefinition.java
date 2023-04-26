package com.sofkau.stepdefinitions.rest;

import com.sofkau.models.rest.ResponseRegistro;
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
import org.apache.http.HttpStatus;
import org.junit.jupiter.api.Assertions;

import java.util.logging.Logger;

import static com.sofkau.Tasks.rest.DoPut.doPut;
import static com.sofkau.questions.rest.ReturnUpdateJsonResponse.responseRegistro;
import static com.sofkau.utils.UrlResources.PUT_USER_RESOURCE;
import static net.serenitybdd.screenplay.rest.questions.ResponseConsequence.seeThatResponse;
import static org.hamcrest.CoreMatchers.equalTo;


public class PutUsersStepDefinition extends Configuracion {
    private User user = new User();
    private Response response;
    private Actor actor;

    public static java.util.logging.Logger LOGGER = Logger.getLogger(String.valueOf(PutUsersStepDefinition.class));
    @Given("que el usuario se encuentra en la pagina de radar de aprendices")
    public void queElUsuarioSeEncuentraEnLaPaginaDeRadarDeAprendices() {
        try {
            actor = Actor.named("usuario")
                    .whoCan(CallAnApi.at(UrlResources.ACTUALIZAR_USER_BASE_URL.getValue()));
            LOGGER.info("API disponibles para realizar la peticion");
            LOGGER.info("Inicio de automatizacion en API Radar ");
        } catch (Exception e) {
            LOGGER.info(" fallo configuración inicial de API Radar");
            LOGGER.warning(e.getMessage());
            e.printStackTrace();
        }
    }

    @When("el usuario envia una solicitud PUT con el id {string} el uid {string} el email {string} el name {string} el estadoActivado {string} y el role {string}")
    public void elUsuarioEnviaUnaSolicitudPUTConElIdElUidElEmailElNameElEstadoActivadoYElRole(String id, String uid, String email, String name, String activate, String role) {
        try{
            user.setUid(uid);
            user.setEmail(email);
            user.setName(name);
            user.setActivate(activate);
            user.setRole(role);
            actor.attemptsTo(
                    doPut()
                            .withResource(PUT_USER_RESOURCE.getValue()+id)
                            .andTheRequestBody(user)
            );
            response = SerenityRest.lastResponse();
        }catch (Exception e){
            LOGGER.info("Fallo enviando la informacion");
            LOGGER.warning(e.getMessage());
        }
    }

    @Then("el usuario visualiza los usuarios actualizados")
    public void elUsuarioVisualizaLosUsuariosActualizados() {
        actor.should(
                seeThatResponse("La respuesta debería ser exitosa y los datos actualizados coincidir con los enviados",
                        response -> response
                                .statusCode(200)
                                .body("uid", equalTo(user.getUid()))
                                .body("email", equalTo(user.getEmail()))
                                .body("name", equalTo(user.getName()))
                                .body("activate", equalTo(Boolean.parseBoolean(user.getActivate())))
                                .body("role", equalTo(user.getRole()))
                )
        );
    }
}
