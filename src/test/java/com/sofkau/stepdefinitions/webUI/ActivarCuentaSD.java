package com.sofkau.stepdefinitions.webUI;

import com.sofkau.Tasks.webUI.AbrirPaginaInicial;
import com.sofkau.setup.Configuracion;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.apache.log4j.Logger;
import static com.sofkau.Tasks.webUI.ActivarCuenta.activarCuenta;
import static com.sofkau.Tasks.webUI.IrLogin.irLogin;
import static com.sofkau.questions.webUI.MensajeRegistro.mensajeRegistro;
import static net.serenitybdd.screenplay.GivenWhenThen.seeThat;
import static net.serenitybdd.screenplay.actors.OnStage.theActorInTheSpotlight;
import static org.hamcrest.core.IsEqual.equalTo;

public class ActivarCuentaSD extends Configuracion {

    public static Logger LOGGER = Logger.getLogger(RegistroUsuarioSD.class);


    @Given("el admin esta en el login de la pagina de radar")
    public void elAdminEstaEnElLoginDeLaPaginaDeRadar() {
        try {
            configurarNavegador();
            theActorInTheSpotlight().wasAbleTo(
                    new AbrirPaginaInicial(),
                    irLogin()
            );
        } catch (Exception e) {
            LOGGER.info("fallo la configuracion inicial de activar cuenta");
            LOGGER.warn(e.getMessage());
            quitarDriver();
        }
    }

    @When("el admin envia las credenciales con google")
    public void elAdminEnviaLasCredencialesConGoogle() {
        try {
            theActorInTheSpotlight().attemptsTo(
                    activarCuenta()
                            .yConElEmail("retofinalsofkaradar@gmail.com ")
                            .conElPassword("Sofkaradar12*")
            );
        } catch (Exception e) {
            LOGGER.info("fallo el proceso de activar la cuenta");
            LOGGER.warn(e.getMessage());
            quitarDriver();
        }
    }

    @Then("el admin debe poder ingresar a la pagina y activar las cuentas de los usuarios")
    public void elAdminDebePoderIngresarALaPaginaYActivarLasCuentasDeLosUsuarios() {
        try {


        } catch (Exception e) {
            LOGGER.info("fallo el proceso de validacion del registro");
            LOGGER.warn(e.getMessage());
        } finally {
            quitarDriver();
        }
    }

}
