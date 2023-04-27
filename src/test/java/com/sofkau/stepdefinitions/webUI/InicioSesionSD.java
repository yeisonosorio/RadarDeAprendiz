package com.sofkau.stepdefinitions.webUI;

import com.sofkau.Tasks.webUI.AbrirPaginaInicial;

import com.sofkau.questions.webUI.*;
import com.sofkau.setup.Configuracion;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.apache.log4j.Logger;

import static com.sofkau.Tasks.webUI.IniciarSesion.iniciarSesion;
import static com.sofkau.Tasks.webUI.IniciarSesionEmail.iniciarSesionEmail;
import static com.sofkau.Tasks.webUI.IniciarSesionPassword.iniciarSesionPassword;
import static com.sofkau.Tasks.webUI.InicioSesionFallido.inicioSesionFallido;
import static com.sofkau.Tasks.webUI.IrLogin.irLogin;
import static com.sofkau.questions.webUI.MensajeInicioSesion.mensajeInicioSesion;
import static net.serenitybdd.screenplay.GivenWhenThen.seeThat;
import static net.serenitybdd.screenplay.actors.OnStage.theActorInTheSpotlight;
import static org.hamcrest.CoreMatchers.containsString;
import static org.hamcrest.core.IsEqual.equalTo;

public class InicioSesionSD extends Configuracion {

    public static Logger LOGGER = Logger.getLogger(InicioSesionSD.class);


    /**
     * Caso 1
     */
    @Given("el usuario esta en el inicio de sesion")
    public void elUsuarioEstaEnElInicioDeSesion() {
        try {
            configurarNavegador();
            theActorInTheSpotlight().wasAbleTo(
                    new AbrirPaginaInicial(),
                    irLogin()
            );
        } catch (Exception e) {
            LOGGER.info("fallo la configuracion inicial");
            LOGGER.warn(e.getMessage());
            quitarDriver();
        }
    }

    @When("el usuario envia las credenciales {string} {string}")
    public void elUsuarioEnviaLasCredenciales(String email, String password) {
        try {
            theActorInTheSpotlight().attemptsTo(
                    iniciarSesion()
                            .yConElEmail(email)
                            .conElPassword(password)
            );
        } catch (Exception e) {
            LOGGER.info("fallo el proceso del inicio de sesion");
            LOGGER.warn(e.getMessage());
            quitarDriver();
        }
    }

    @Then("el usuario debe poder ingresar al home de la pagina")
    public void elUsuarioDebePoderIngresarAlHomeDeLaPagina() {
        try {
            theActorInTheSpotlight().should(
                    seeThat(mensajeInicioSesion(), equalTo("New Training League"))
            );
        } catch (Exception e) {
            LOGGER.info("fallo el proceso de inicio de sesion");
            LOGGER.warn(e.getMessage());
        } finally {
            quitarDriver();
        }
    }


    /**
     * Caso 2
     */
    @Given("el usuario esta en el inicio de sesion de la pagina")
    public void elUsuarioEstaEnElInicioDeSesionDeLaPagina() {
        try {
            configurarNavegador();
            theActorInTheSpotlight().wasAbleTo(
                    new AbrirPaginaInicial(),
                    irLogin()
            );
        } catch (Exception e) {
            LOGGER.info("fallo la configuracion inicial");
            LOGGER.warn(e.getMessage());
            quitarDriver();
        }
    }

    @When("el usuario envia credenciales invalidas, como {string} {string}")
    public void elUsuarioEnviaCredencialesInvalidasComo(String email, String password_mal) {
        try {
            theActorInTheSpotlight().attemptsTo(
                    inicioSesionFallido()
                            .yConElEmail(email)
                            .conElPassword(password_mal)
            );
        } catch (Exception e) {
            LOGGER.info("fallo el proceso de inicio de sesion");
            LOGGER.warn(e.getMessage());
            quitarDriver();
        }
    }


    @Then("el usuario debe ver un {string} de error de inicio de sesion")
    public void elUsuarioDebeVerUnDeErrorDeInicioDeSesion(String mensaje) {
        try {
            theActorInTheSpotlight().should(
                    seeThat(ResultadoErrorIniciar.isEqualTo(), containsString((mensaje)))
            );
        } catch (Exception e) {
            LOGGER.info("fallo el proceso de inicio de sesion");
            LOGGER.warn(e.getMessage());
            //Assertions.fail();
        } finally {
            quitarDriver();
        }
    }


    /**
     * Caso 3
     */
    @Given("el usuario esta en el inicio de radar")
    public void elUsuarioEstaEnElInicioDeRadar() {
        try {
            configurarNavegador();
            theActorInTheSpotlight().wasAbleTo(
                    new AbrirPaginaInicial(),
                    irLogin()
            );
        } catch (Exception e) {
            LOGGER.info("fallo la configuracion inicial");
            LOGGER.warn(e.getMessage());
            quitarDriver();
        }
    }

    @When("el usuario envia credenciales incompletas con solo el {string}")
    public void elUsuarioEnviaCredencialesIncompletasConSoloEl(String email) {
        try {
            theActorInTheSpotlight().attemptsTo(
                    iniciarSesionPassword()
                            .yConElEmail(email)

            );
        } catch (Exception e) {
            LOGGER.info("fallo el proceso de inicio de sesion sin el password");
            LOGGER.warn(e.getMessage());
            quitarDriver();
        }
    }

    @Then("el usuario debe ver un {string} campo password  obligatorio")
    public void elUsuarioDebeVerUnCampoPasswordObligatorio(String mensaje) {
        try {
            theActorInTheSpotlight().should(
                    seeThat(ResultadoPassword.isEqualTo(), containsString((mensaje)))
            );
        } catch (Exception e) {
            LOGGER.info("fallo el proceso de inicio de sesion sin el pasword");
            LOGGER.warn(e.getMessage());
            //Assertions.fail();
        } finally {
            quitarDriver();
        }
    }


    /**
     * Caso 4
     */
    @Given("el usuario esta en el inicio de sesion de la pagina de radar")
    public void elUsuarioEstaEnElInicioDeSesionDeLaPaginaDeRadar() {
        try {
            configurarNavegador();
            theActorInTheSpotlight().wasAbleTo(
                    new AbrirPaginaInicial(),
                    irLogin()
            );
        } catch (Exception e) {
            LOGGER.info("fallo la configuracion inicial");
            LOGGER.warn(e.getMessage());
            quitarDriver();
        }
    }

    @When("el usuario envia credenciales incompleta con solo el {string}")
    public void elUsuarioEnviaCredencialesIncompletaConSoloEl(String password) {
        try {
            theActorInTheSpotlight().attemptsTo(
                    iniciarSesionEmail()
                            .conElPassword(password)
            );
        } catch (Exception e) {
            LOGGER.info("fallo el proceso de inicio de sesion sin el email");
            LOGGER.warn(e.getMessage());
            quitarDriver();
        }
    }

    @Then("el usuario debe ver un {string} email es un campo obligatorio")
    public void elUsuarioDebeVerUnEmailEsUnCampoObligatorio(String mensaje) {
        try {
            theActorInTheSpotlight().should(
                    seeThat(ResultadoEmail.isEqualTo(), containsString((mensaje)))
            );
        } catch (Exception e) {
            LOGGER.info("fallo el proceso de inicio de sesion sin el email");
            LOGGER.warn(e.getMessage());
            //Assertions.fail();
        } finally {
            quitarDriver();
        }
    }


}
