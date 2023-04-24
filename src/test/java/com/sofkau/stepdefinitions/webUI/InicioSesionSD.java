package com.sofkau.stepdefinitions.webUI;

import com.sofkau.setup.ApiSetUp;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.apache.log4j.Logger;

public class InicioSesionSD extends ApiSetUp {

    public static Logger LOGGER = Logger.getLogger(InicioSesionSD.class);


    /**
     * Caso 1
     */
    @Given("el usuario esta en el inicio de sesion")
    public void elUsuarioEstaEnElInicioDeSesion() {

    }

    @When("el usuario envia las credenciales {string} {string}")
    public void elUsuarioEnviaLasCredenciales(String string, String string2) {

    }

    @Then("el usuario debe poder ingresar al home de la pagina")
    public void elUsuarioDebePoderIngresarAlHomeDeLaPagina() {

    }


    /**
     * Caso 2
     */
    @Given("el usuario esta en el inicio de sesion de la pagina")
    public void elUsuarioEstaEnElInicioDeSesionDeLaPagina() {

    }

    @When("el usuario envia credenciales invalidas, como {string} {string}")
    public void elUsuarioEnviaCredencialesInvalidasComo(String string, String string2) {

    }

    @Then("el usuario debe ver un mensaje de error de inicio de sesion")
    public void elUsuarioDebeVerUnMensajeDeErrorDeInicioDeSesion() {

    }


    /**
     * Caso 3
     */
    @Given("el usuario esta en el inicio de radar")
    public void elUsuarioEstaEnElInicioDeRadar() {

    }

    @When("el usuario envia credenciales incompletas con solo el {string}")
    public void elUsuarioEnviaCredencialesIncompletasConSoloEl(String string) {

    }

    @Then("el usuario debe ver un mensaje campo password  obligatorio")
    public void elUsuarioDebeVerUnMensajeCampoPasswordObligatorio() {

    }


    /**
     * Caso 4
     */
    @Given("el usuario esta en el inicio de sesion de la pagina de radar")
    public void elUsuarioEstaEnElInicioDeSesionDeLaPaginaDeRadar() {

    }

    @When("el usuario envia credenciales incompleta con solo el {string}")
    public void elUsuarioEnviaCredencialesIncompletaConSoloEl(String string) {

    }

    @Then("el usuario debe ver un mensaje email es un campo obligatorio")
    public void elUsuarioDebeVerUnMensajeEmailEsUnCampoObligatorio() {

    }


}
