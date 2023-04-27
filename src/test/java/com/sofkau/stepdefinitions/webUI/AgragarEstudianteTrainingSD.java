package com.sofkau.stepdefinitions.webUI;

import com.sofkau.Tasks.webUI.AbrirPaginaInicial;
import com.sofkau.questions.webUI.MensajeEstudianteAgregadoExitoso;
import com.sofkau.questions.webUI.MenssajeEstudianteAgregado;
import com.sofkau.questions.webUI.ResultadoErrorIniciar;
import com.sofkau.setup.Configuracion;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.apache.log4j.Logger;

import static com.sofkau.Tasks.webUI.IniciarSesion.iniciarSesion;
import static com.sofkau.Tasks.webUI.IrLogin.irLogin;
import static com.sofkau.Tasks.webUI.SeleccionarEstudiante.seleccionarEstudiante;
import static net.serenitybdd.screenplay.GivenWhenThen.seeThat;
import static net.serenitybdd.screenplay.actors.OnStage.theActorInTheSpotlight;
import static org.hamcrest.CoreMatchers.containsString;

public class AgragarEstudianteTrainingSD extends Configuracion {

    public static Logger LOGGER = Logger.getLogger(RegistroUsuarioSD.class);


    @Given("el coach  esta en el login de la pagina de radar para ingresar")
    public void elCoachEstaEnElLoginDeLaPaginaDeRadarParaIngresar() {
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

    @When("el coach envia las credenciales {string} {string} para  ingresar")
    public void elCoachEnviaLasCredencialesParaIngresar(String email, String password) {
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

    @When("procede a agregar al estudiante a un training")
    public void procedeAAgregarAlEstudianteAUnTraining() {
        try {
            theActorInTheSpotlight().attemptsTo(
                    seleccionarEstudiante()
                            .conElEstudiante("student@student.com")

            );
        } catch (Exception e) {
            LOGGER.info("fallo el proceso del inicio de sesion");
            LOGGER.warn(e.getMessage());
            quitarDriver();
        }
    }

    @Then("el coach debe poder ver un {string} de estudiante agregado creado")
    public void elCoachDebePoderVerUnDeEstudianteAgregadoCreado(String mensaje) {
        try {
            theActorInTheSpotlight().should(
                    seeThat(MensajeEstudianteAgregadoExitoso.isEqualTo(), containsString((mensaje)))
            );
        } catch (Exception e) {
            LOGGER.info("fallo el proceso de inicio de sesion");
            LOGGER.warn(e.getMessage());
            //Assertions.fail();
        } finally {
            quitarDriver();
        }
    }





    @Given("el coach  esta en el login de la pagina")
    public void elCoachEstaEnElLoginDeLaPagina() {
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

    @When("el coach envia las credenciales correctas   {string} {string} para  ingresar")
    public void elCoachEnviaLasCredencialesCorrectasParaIngresar(String email, String password) {
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

    @When("procede a agregar al estudiante a un training league")
    public void procedeAAgregarAlEstudianteAUnTrainingLeague() {
        try {
            theActorInTheSpotlight().attemptsTo(
                    seleccionarEstudiante()
                            .conElEstudiante("student@student.com")

            );
        } catch (Exception e) {
            LOGGER.info("fallo el proceso del inicio de sesion");
            LOGGER.warn(e.getMessage());
            quitarDriver();
        }
    }

    @Then("el coach debe poder ver un {string} de error")
    public void elCoachDebePoderVerUnDeError(String mensaje) {
        try {
            theActorInTheSpotlight().should(
                    seeThat(MenssajeEstudianteAgregado.isEqualTo(), containsString((mensaje)))
            );
        } catch (Exception e) {
            LOGGER.info("fallo el proceso de inicio de sesion");
            LOGGER.warn(e.getMessage());
            //Assertions.fail();
        } finally {
            quitarDriver();
        }
    }



}
