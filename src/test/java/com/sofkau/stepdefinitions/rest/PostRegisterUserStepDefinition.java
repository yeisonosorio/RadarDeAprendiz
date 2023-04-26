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
import org.apache.http.HttpStatus;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.junit.Assert;
import org.junit.jupiter.api.Assertions;
import org.json.simple.JSONObject;

import java.util.logging.Logger;

import static com.sofkau.Tasks.rest.DoPost.doPost;
import static com.sofkau.questions.rest.ReturnRegister.returnRegister;
import static com.sofkau.utils.UrlResources.POST_REGISTER_USER_RESOURCE;
import static net.serenitybdd.screenplay.GivenWhenThen.seeThat;
import static net.serenitybdd.screenplay.rest.questions.ResponseConsequence.seeThatResponse;
import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.notNullValue;

public class PostRegisterUserStepDefinition extends Configuracion {
    private User user = new User();
    JSONObject responseBody = null;
    JSONParser parser = new JSONParser();
    private Response response;
    private Actor actor;
    public static Logger LOGGER = Logger.getLogger(String.valueOf(PostRegisterUserStepDefinition.class));

    @Given("el usuario esta en la pagina para crear usuarios")
    public void elUsuarioEstaEnLaPaginaParaCrearUsuarios() {
        try {
            actor = Actor.named("usuario")
                    .whoCan(CallAnApi.at(UrlResources.REGISTER_USER_BASE_URL.getValue()));
            LOGGER.info("API disponibles para realizar la peticion");
            LOGGER.info("Inicio de automatizacion en API Radar ");
        } catch (Exception e) {
            LOGGER.info(" fallo configuración inicial de API Radar");
            LOGGER.warning(e.getMessage());
            e.printStackTrace();
        }
    }

    @When("cuando el usuario envia solicitud con userId {string} email {string}  name {string} estadoActivado {string} y role {string}")
    public void cuandoElUsuarioEnviaSolicitudConUserIdEmailNameEstadoActivadoYRole(String uid, String email, String name, String activate, String role) {
        try {
            user.setUid(uid);
            user.setEmail(email);
            user.setName(name);
            user.setActivate(activate);
            user.setRole(role);
            actor.attemptsTo(doPost().withTheResource(POST_REGISTER_USER_RESOURCE.getValue())
                    .andTheRequestBody(user));
            System.out.println(SerenityRest.lastResponse().body().asString());
            LOGGER.info("Los datos fueron enviados correctamente");

        } catch (Exception e) {
            LOGGER.info(" fallo al enviar los datos");
            LOGGER.warning(e.getMessage());
            Assertions.fail();
        }
    }

    @Then("la pagina retornara un estatus con codigo {int} y con userId {string} email {string}  name {string} estadoActivado {string} y role {string}")
    public void laPaginaRetornaraUnEstatusConCodigoYConUserIdEmailNameEstadoActivadoYRole(Integer codigo, String uid, String email, String name, String activate, String role) throws ParseException {
        try {
            Response actualResponse = returnRegister().answeredBy(actor);
            responseBody = (JSONObject) parser.parse(actualResponse.getBody().asString());
            actor.should(
                    seeThatResponse("El codigo de respuesta es: " + HttpStatus.SC_OK,
                            response -> response.statusCode(codigo)),
                    seeThat("Retorna información",
                            act -> actualResponse, notNullValue()),
                    seeThat("Comparar id",
                            idC -> responseBody.get("uid").toString(), equalTo(uid)),
                    seeThat("Comparar email",
                            TiC -> responseBody.get("email").toString(), equalTo(email)),
                    seeThat("Comparar name",
                            BodyC -> responseBody.get("name").toString(), equalTo(name)),
                    seeThat("Comparar activate",
                            TiC -> responseBody.get("activate").toString(), equalTo(activate)),
                    seeThat("Comparar role",
                            TiC -> responseBody.get("role").toString(), equalTo(role))
            );
            LOGGER.info("Datos esperados y actuales correctos");
        } catch (Exception e) {
            LOGGER.info(" fallo la assercion en la API placeholder");
            LOGGER.warning(e.getMessage());
            Assertions.fail();
        }
    }
}
