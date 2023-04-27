package com.sofkau.Tasks.webUI;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.Enter;
import net.serenitybdd.screenplay.waits.WaitUntil;

import static com.sofkau.questions.webUI.ResultadoErrorIniciar.MENSAJE_INICIAR_ERROR;
import static com.sofkau.ui.webUI.IniciarSesion.*;
import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isClickable;

public class IniciarSesion implements Task {


    private String email;
    private String password;


    public IniciarSesion yConElEmail(String email) {
        this.email = email;
        return this;
    }

    public IniciarSesion conElPassword(String password) {
        this.password = password;
        return this;
    }


    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
                Enter.theValue(email).into(CAMPO_EMAIL_LOGIN),
                Enter.theValue(password).into(CAMPO_PASSWORD_LOGIN),
                Click.on(BTN_LOGIN),
                Click.on(BTN_OK)

        );

    }

    public static IniciarSesion iniciarSesion() {
        return new IniciarSesion();
    }

}
