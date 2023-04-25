package com.sofkau.stepdefinitions.webUI;

import com.sofkau.Tasks.webUI.AbrirPaginaInicial;
import com.sofkau.questions.webUI.ResultadoEmail;
import com.sofkau.questions.webUI.ResultadoNombre;
import com.sofkau.questions.webUI.ResultadoPassword;
import com.sofkau.setup.Configuracion;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.apache.log4j.Logger;

import static com.sofkau.Tasks.webUI.IrRegistro.irRegistro;
import static com.sofkau.Tasks.webUI.RegistroUsuario.registroUsuario;
import static com.sofkau.Tasks.webUI.RegistroUsuarioEmail.registroUsuarioEmail;
import static com.sofkau.Tasks.webUI.RegistroUsuarioNombre.registroUsuarioNombre;
import static com.sofkau.Tasks.webUI.RegistroUsuarioPassword.registroUsuarioPassword;
import static com.sofkau.questions.webUI.MensajeRegistro.mensajeRegistro;
import static net.serenitybdd.screenplay.GivenWhenThen.seeThat;
import static net.serenitybdd.screenplay.actors.OnStage.theActorInTheSpotlight;
import static org.hamcrest.CoreMatchers.containsString;
import static org.hamcrest.core.IsEqual.equalTo;

public class RegistroUsuarioSD extends Configuracion {


    public static Logger LOGGER = Logger.getLogger(RegistroUsuarioSD.class);


    /**
     * Caso 1
     */
    @Given("el usuario esta en el registro de la pagina de radar de sofka")
    public void elUsuarioEstaEnElRegistroDeLaPaginaDeRadarDeSofka() {
        try {
            configurarNavegador();
            theActorInTheSpotlight().wasAbleTo(
                    new AbrirPaginaInicial(),
                    irRegistro()
            );
        } catch (Exception e) {
            LOGGER.info("fallo la configuracion inicial");
            LOGGER.warn(e.getMessage());
            quitarDriver();
        }
    }

    @When("el usuario envia las credenciales {string} {string} {string}")
    public void elUsuarioEnviaLasCredenciales(String nombre, String email, String password) {
        try {
            theActorInTheSpotlight().attemptsTo(
                    registroUsuario()
                            .conElNombre(nombre)
                            .yConElEmail(email)
                            .conElPassword(password)
            );
        } catch (Exception e) {
            LOGGER.info("fallo el proceso del registro");
            LOGGER.warn(e.getMessage());
            quitarDriver();
        }
    }

    @Then("el usuario deberia un  mensaje que falta activar su usuario")
    public void elUsuarioDeberiaUnMensajeQueFaltaActivarSuUsuario() {
        try {
            theActorInTheSpotlight().should(
                    seeThat(mensajeRegistro(), equalTo("OK"))
            );
        } catch (Exception e) {
            LOGGER.info("fallo el proceso de validacion del registro");
            LOGGER.warn(e.getMessage());
        } finally {
            quitarDriver();
        }
    }


    /**
     * Caso 2
     */
    @Given("el usuario esta en la pagina de registro")
    public void elUsuarioEstaEnLaPaginaDeRegistro() {
        try {
            configurarNavegador();
            theActorInTheSpotlight().wasAbleTo(
                    new AbrirPaginaInicial(),
                    irRegistro()
            );
        } catch (Exception e) {
            LOGGER.info("fallo la configuracion inicial");
            LOGGER.warn(e.getMessage());
            quitarDriver();
        }
    }

    @When("el usuario envia las credenciales con campos {string} {string}")
    public void elUsuarioEnviaLasCredencialesConCampos(String email, String password) {
        try {
            theActorInTheSpotlight().attemptsTo(
                    registroUsuarioNombre()
                            .yConElEmail(email)
                            .conElPassword(password)
            );
        } catch (Exception e) {
            LOGGER.info("fallo el proceso del registro");
            LOGGER.warn(e.getMessage());
            quitarDriver();
        }
    }

    @Then("el usuario vera reflejarse un {string}")
    public void elUsuarioVeraReflejarseUn(String mensaje) {
        try {
            theActorInTheSpotlight().should(
                    seeThat(ResultadoNombre.isEqualTo(), containsString((mensaje)))
            );
        } catch (Exception e) {
            LOGGER.info("fallo el proceso de validacion del registro");
            LOGGER.warn(e.getMessage());
            //Assertions.fail();
        } finally {
            quitarDriver();
        }
    }


    /**
     * Caso 3
     */

    @Given("el usuario esta en la pagina del registro")
    public void elUsuarioEstaEnLaPaginaDelRegistro() {
        try {
            configurarNavegador();
            theActorInTheSpotlight().wasAbleTo(
                    new AbrirPaginaInicial(),
                    irRegistro()
            );
        } catch (Exception e) {
            LOGGER.info("fallo la configuracion inicial");
            LOGGER.warn(e.getMessage());
            quitarDriver();
        }
    }

    @When("el usuario envia las credenciales con los campos {string} {string}")
    public void elUsuarioEnviaLasCredencialesConLosCampos(String nombre, String password) {
        try {
            theActorInTheSpotlight().attemptsTo(
                    registroUsuarioEmail()
                            .conElNombre(nombre)
                            .conElPassword(password)
            );
        } catch (Exception e) {
            LOGGER.info("fallo el proceso del registro");
            LOGGER.warn(e.getMessage());
            quitarDriver();
        }
    }

    @Then("el usuario vera un {string}")
    public void elUsuarioVeraUn(String mensaje) {
        try {
            theActorInTheSpotlight().should(
                    seeThat(ResultadoEmail.isEqualTo(), containsString((mensaje)))
            );
        } catch (Exception e) {
            LOGGER.info("fallo el proceso de validacion del registro");
            LOGGER.warn(e.getMessage());
            //Assertions.fail();
        } finally {
            quitarDriver();
        }
    }


    /**
     * Caso 4
     */

    @Given("el usuario esta en la pagina de registro de radar")
    public void elUsuarioEstaEnLaPaginaDeRegistroDeRadar() {
        try {
            configurarNavegador();
            theActorInTheSpotlight().wasAbleTo(
                    new AbrirPaginaInicial(),
                    irRegistro()
            );
        } catch (Exception e) {
            LOGGER.info("fallo la configuracion inicial");
            LOGGER.warn(e.getMessage());
            quitarDriver();
        }
    }

    @When("el usuario envia las credenciales del campo {string} {string}")
    public void elUsuarioEnviaLasCredencialesDelCampo(String nombre, String email) {
        try {
            theActorInTheSpotlight().attemptsTo(
                    registroUsuarioPassword()
                            .yConElEmail(nombre)
                            .yConElEmail(email)
            );
        } catch (Exception e) {
            LOGGER.info("fallo el proceso del registro");
            LOGGER.warn(e.getMessage());
            quitarDriver();
        }
    }

    @Then("el usuario podra ver un {string}")
    public void elUsuarioPodraVerUn(String mensaje) {
        try {
            theActorInTheSpotlight().should(
                    seeThat(ResultadoPassword.isEqualTo(), containsString((mensaje)))
            );
        } catch (Exception e) {
            LOGGER.info("fallo el proceso de validacion del registro");
            LOGGER.warn(e.getMessage());
            //Assertions.fail();
        } finally {
            quitarDriver();
        }
    }


}
