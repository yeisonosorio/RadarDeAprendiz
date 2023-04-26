package com.sofkau.Tasks.webUI;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.Enter;

import static com.sofkau.ui.webUI.RegistroUsuario.*;
import static com.sofkau.ui.webUI.RegistroUsuario.BOTON_EMAIL;

public class IniciarSesionEmail implements Task {



    private String password;




    public IniciarSesionEmail conElPassword(String password) {
        this.password = password;
        return this;
    }


    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
                Enter.theValue(password).into(CAMPO_PASSWORD),
                Click.on(CAMPO_EMAIL),
                Click.on(BOTON_EMAIL)

        );


    }

    public static IniciarSesionEmail iniciarSesionEmail() {
        return new IniciarSesionEmail();
    }

}
