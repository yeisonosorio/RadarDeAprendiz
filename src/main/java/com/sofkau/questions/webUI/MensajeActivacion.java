package com.sofkau.questions.webUI;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;
import net.serenitybdd.screenplay.questions.targets.TheTarget;
import net.serenitybdd.screenplay.targets.Target;
import org.openqa.selenium.By;

import static com.sofkau.ui.webUI.ActivarCuenta.BTN_ACTIVACION_OK;
import static com.sofkau.ui.webUI.MensajeInicioSesion.MENSAJE_INICIO_SESION;

public class MensajeActivacion implements Question<String> {


    @Override
    public String answeredBy(Actor actor) {
        return BTN_ACTIVACION_OK.resolveFor(actor).getText();
    }

    public static MensajeActivacion mensajeActivacion() {
        return new MensajeActivacion();
    }
}

