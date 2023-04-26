package com.sofkau.Tasks.webUI;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.Enter;

import static com.sofkau.ui.webUI.IniciarSesion.BOTON_PASSWORD2;
import static com.sofkau.ui.webUI.RegistroUsuario.*;
import static com.sofkau.ui.webUI.RegistroUsuario.BOTON_PASSWORD;

public class IniciarSesionPassword implements Task {


    private String email;



    public IniciarSesionPassword yConElEmail(String email) {
        this.email = email;
        return this;
    }


    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(

                Enter.theValue(email).into(CAMPO_EMAIL),
                Click.on(CAMPO_PASSWORD),
                Click.on(BOTON_PASSWORD2)

        );


    }

    public static IniciarSesionPassword iniciarSesionPassword() {
        return new IniciarSesionPassword();
    }

}
