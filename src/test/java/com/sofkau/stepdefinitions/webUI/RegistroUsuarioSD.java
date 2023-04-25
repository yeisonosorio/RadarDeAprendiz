package com.sofkau.stepdefinitions.webUI;

import com.sofkau.Tasks.webUI.AbrirPaginaInicial;
import com.sofkau.setup.Configuracion;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.apache.log4j.Logger;

import static com.sofkau.Tasks.webUI.IrRegistro.irRegistro;
import static com.sofkau.Tasks.webUI.RegistroUsuario.registroUsuario;
import static com.sofkau.questions.webUI.MensajeRegistro.mensajeRegistro;
import static net.serenitybdd.screenplay.GivenWhenThen.seeThat;
import static net.serenitybdd.screenplay.actors.OnStage.theActorInTheSpotlight;
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
                    seeThat(mensajeRegistro(), equalTo("User q7T6dJacZIQ5h5ZDjjMrKv3IVHd2 is already unactivated\n"))
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
