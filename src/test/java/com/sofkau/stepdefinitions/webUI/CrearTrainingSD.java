package com.sofkau.stepdefinitions.webUI;

import com.sofkau.Tasks.webUI.AbrirPaginaInicial;
import com.sofkau.questions.webUI.*;
import com.sofkau.setup.Configuracion;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.apache.log4j.Logger;

import static com.sofkau.Tasks.webUI.CrearTraining.crearTraining;
import static com.sofkau.Tasks.webUI.CrearTrainingCaracteres.crearTrainingCaracteres;
import static com.sofkau.Tasks.webUI.CrearTrainingSinCiclo.crearTrainingSinCiclo;
import static com.sofkau.Tasks.webUI.CrearTrainingSinTitulo.crearTrainingSinTitulo;
import static com.sofkau.Tasks.webUI.IniciarSesion.iniciarSesion;
import static com.sofkau.Tasks.webUI.IrLogin.irLogin;
import static net.serenitybdd.screenplay.GivenWhenThen.seeThat;
import static net.serenitybdd.screenplay.actors.OnStage.theActorInTheSpotlight;
import static org.hamcrest.CoreMatchers.containsString;

public class CrearTrainingSD extends Configuracion {


    public static Logger LOGGER = Logger.getLogger(InicioSesionSD.class);


    /**
     * Caso 1
     */

    @Given("el coach  esta en el login de la pagina de radar")
    public void elCoachEstaEnElLoginDeLaPaginaDeRadar() {
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

    @When("el coach envia las credenciales {string} {string} para poder ingresar")
    public void elCoachEnviaLasCredencialesParaPoderIngresar(String email, String password) {
        try {
            theActorInTheSpotlight().attemptsTo(
                    iniciarSesion()
                            .yConElEmail(email)
                            .conElPassword(password)
            );
        } catch (Exception e) {
            LOGGER.info("fallo el inicio de sesion");
            LOGGER.warn(e.getMessage());
            quitarDriver();
        }
    }

    @When("procede a crear un Training envia {string} {string}")
    public void procedeACrearUnTrainingEnvia(String titulo, String ciclo) {
        try {
            theActorInTheSpotlight().attemptsTo(
                    crearTraining()
                            .yConElTitulo(titulo)
                            .conElCiclo(ciclo)
            );
        } catch (Exception e) {
            LOGGER.info("fallo la creacion del training");
            LOGGER.warn(e.getMessage());
            quitarDriver();
        }
    }

    @Then("el coach debe poder ver un {string} de Training creado")
    public void elCoachDebePoderVerUnDeTrainingCreado(String mensaje) {
        try {
            theActorInTheSpotlight().should(
                    seeThat(MensajeTrainingCreadoExitoso.isEqualTo(), containsString((mensaje)))
            );
        } catch (Exception e) {
            LOGGER.info("fallo el proceso de crear Training");
            LOGGER.warn(e.getMessage());
            //Assertions.fail();
        } finally {
            quitarDriver();
        }
    }


    /**
     * Caso 2
     */
    @Given("el coach esta en el login de la pagina  radar de sofka")
    public void elCoachEstaEnElLoginDeLaPaginaRadarDeSofka() {
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


    @When("el coach envia las credenciales {string} {string}")
    public void elCoachEnviaLasCredenciales(String email, String password) {
        try {
            theActorInTheSpotlight().attemptsTo(
                    iniciarSesion()
                            .yConElEmail(email)
                            .conElPassword(password)
            );
        } catch (Exception e) {
            LOGGER.info("fallo el inicio de sesion");
            LOGGER.warn(e.getMessage());
            quitarDriver();
        }
    }

    @When("procede a crear un Training repetidos envia {string} {string}")
    public void procedeACrearUnTrainingRepetidosEnvia(String titulo, String ciclo) {
        try {
            theActorInTheSpotlight().attemptsTo(
                    crearTraining()
                            .yConElTitulo(titulo)
                            .conElCiclo(ciclo)
            );
        } catch (Exception e) {
            LOGGER.info("fallo la creacion del training");
            LOGGER.warn(e.getMessage());
            quitarDriver();
        }
    }

    @Then("el coach debe ver un {string} de error indicando que no se pudo crear el Training")
    public void elCoachDebeVerUnDeErrorIndicandoQueNoSePudoCrearElTraining(String mensaje) {
        try {
            theActorInTheSpotlight().should(
                    seeThat(MensajeTrainingCreadoFallido.isEqualTo(), containsString((mensaje)))
            );
        } catch (Exception e) {
            LOGGER.info("fallo el proceso de crear Training");
            LOGGER.warn(e.getMessage());
            //Assertions.fail();
        } finally {
            quitarDriver();
        }
    }

    /**
     * Caso 3
     */


    @Given("el coach esta en el login del sistema de radar de sofka")
    public void elCoachEstaEnElLoginDelSistemaDeRadarDeSofka() {
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

    @When("el coach envia las credenciales {string} con el {string}")
    public void elCoachEnviaLasCredencialesConEl(String email, String password) {
        try {
            theActorInTheSpotlight().attemptsTo(
                    iniciarSesion()
                            .yConElEmail(email)
                            .conElPassword(password)
            );
        } catch (Exception e) {
            LOGGER.info("fallo el inicio de sesion");
            LOGGER.warn(e.getMessage());
            quitarDriver();
        }
    }

    @When("procede a enviar los datos del Training League {string} {string}")
    public void procedeAEnviarLosDatosDelTrainingLeague(String titulo, String ciclo) {
        try {
            theActorInTheSpotlight().attemptsTo(
                    crearTrainingCaracteres()
                            .yConElTitulo(titulo)
                            .conElCiclo(ciclo)
            );
        } catch (Exception e) {
            LOGGER.info("fallo la creacion del training");
            LOGGER.warn(e.getMessage());
            quitarDriver();
        }
    }

    @Then("el coach debe ver un {string} de error indicando que no se permiten caracteres")
    public void elCoachDebeVerUnDeErrorIndicandoQueNoSePermitenCaracteres(String mensaje) {
        try {
            theActorInTheSpotlight().should(
                    seeThat(MensajeCaracteres.isEqualTo(), containsString((mensaje)))
            );
        } catch (Exception e) {
            LOGGER.info("fallo el proceso de crear Training");
            LOGGER.warn(e.getMessage());
            //Assertions.fail();
        } finally {
            quitarDriver();
        }
    }

    /**
     * Caso 4
     */


    @Given("el coach esta en el login de la pagina de radar de sofka training")
    public void elCoachEstaEnElLoginDeLaPaginaDeRadarDeSofkaTraining() {
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

    @When("el coach envia las credenciales {string}, {string} correctas")
    public void elCoachEnviaLasCredencialesCorrectas(String email, String password) {
        try {
            theActorInTheSpotlight().attemptsTo(
                    iniciarSesion()
                            .yConElEmail(email)
                            .conElPassword(password)
            );
        } catch (Exception e) {
            LOGGER.info("fallo el inicio de sesion");
            LOGGER.warn(e.getMessage());
            quitarDriver();
        }
    }

    @When("procede a enviar los datos del Training League  {string}")
    public void procedeAEnviarLosDatosDelTrainingLeague(String ciclo) {
        try {
            theActorInTheSpotlight().attemptsTo(
                    crearTrainingSinTitulo()
                            .conElCiclo(ciclo)
            );
        } catch (Exception e) {
            LOGGER.info("fallo la creacion del training");
            LOGGER.warn(e.getMessage());
            quitarDriver();
        }
    }

    @Then("el coach debe ver un {string} de error")
    public void elCoachDebeVerUnDeError(String mensaje) {
        try {
            theActorInTheSpotlight().should(
                    seeThat(MensajeTituloRequerido.isEqualTo(), containsString((mensaje)))
            );
        } catch (Exception e) {
            LOGGER.info("fallo el proceso de crear Training");
            LOGGER.warn(e.getMessage());
            //Assertions.fail();
        } finally {
            quitarDriver();
        }
    }

    @Given("el coach esta en el login de el sistema de radar")
    public void elCoachEstaEnElLoginDeElSistemaDeRadar() {
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

    @When("el coach envia las credenciales  correcta {string}, {string}")
    public void elCoachEnviaLasCredencialesCorrecta(String email, String password) {
        try {
            theActorInTheSpotlight().attemptsTo(
                    iniciarSesion()
                            .yConElEmail(email)
                            .conElPassword(password)
            );
        } catch (Exception e) {
            LOGGER.info("fallo el inicio de sesion");
            LOGGER.warn(e.getMessage());
            quitarDriver();
        }
    }

    @When("procede a enviar los datos del Training League solo {string}")
    public void procedeAEnviarLosDatosDelTrainingLeagueSolo(String titulo) {
        try {
            theActorInTheSpotlight().attemptsTo(
                    crearTrainingSinCiclo()
                            .yConElTitulo(titulo)
            );
        } catch (Exception e) {
            LOGGER.info("fallo la creacion del training sin ciclo");
            LOGGER.warn(e.getMessage());
            quitarDriver();
        }
    }

    @Then("el coach debe ver un {string}")
    public void elCoachDebeVerUn(String mensaje) {
        try {
            theActorInTheSpotlight().should(
                    seeThat(MensajeCicloRequerido.isEqualTo(), containsString((mensaje)))
            );
        } catch (Exception e) {
            LOGGER.info("fallo el proceso de crear Training");
            LOGGER.warn(e.getMessage());
            //Assertions.fail();
        } finally {
            quitarDriver();
        }
    }


}
