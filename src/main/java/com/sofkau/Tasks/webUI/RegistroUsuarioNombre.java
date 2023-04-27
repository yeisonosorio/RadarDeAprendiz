package com.sofkau.Tasks.webUI;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.Enter;
import net.serenitybdd.screenplay.waits.WaitUntil;

import static com.sofkau.ui.webUI.RegistroUsuario.*;
import static com.sofkau.ui.webUI.RegistroUsuario.BOTON_LOGIN;
import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isClickable;

public class RegistroUsuarioNombre implements Task {


    private String email;
    private String password;


    public RegistroUsuarioNombre yConElEmail(String email) {
        this.email = email;
        return this;
    }

    public RegistroUsuarioNombre conElPassword(String password) {
        this.password = password;
        return this;
    }


    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
                //  WaitUntil.the(CAMPO_NOMBRE, isClickable()).forNoMoreThan(10).seconds(),

                Enter.theValue(email).into(CAMPO_EMAIL),
                Enter.theValue(password).into(CAMPO_PASSWORD),
                Click.on(CAMPO_NOMBRE),
                Click.on(BOTON_NOMBRE)


        );


    }

    public static RegistroUsuarioNombre registroUsuarioNombre() {
        return new RegistroUsuarioNombre();
    }

}
