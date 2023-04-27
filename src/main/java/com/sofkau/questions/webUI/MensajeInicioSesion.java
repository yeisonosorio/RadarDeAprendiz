package com.sofkau.questions.webUI;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;

import static com.sofkau.ui.webUI.MensajeInicioSesion.MENSAJE_INICIO_SESION;
import static com.sofkau.ui.webUI.MensajeRegistro.MENSAJE_REGISTRO;

public class MensajeInicioSesion implements Question<String> {


    @Override
    public String answeredBy(Actor actor) {
        return MENSAJE_INICIO_SESION.resolveFor(actor).getText();
    }

    public static MensajeInicioSesion mensajeInicioSesion() {
        return new MensajeInicioSesion();
    }
}
