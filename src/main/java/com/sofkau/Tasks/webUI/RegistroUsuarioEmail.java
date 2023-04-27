package com.sofkau.Tasks.webUI;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.Enter;

import static com.sofkau.ui.webUI.RegistroUsuario.*;
import static com.sofkau.ui.webUI.RegistroUsuario.BOTON_LOGIN;

public class RegistroUsuarioEmail implements Task {

    private String nombre;

    private String password;


    public RegistroUsuarioEmail conElNombre(String nombre) {
        this.nombre = nombre;
        return this;
    }


    public RegistroUsuarioEmail conElPassword(String password) {
        this.password = password;
        return this;
    }


    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
                Enter.theValue(nombre).into(CAMPO_NOMBRE),
                Enter.theValue(password).into(CAMPO_PASSWORD),
                Click.on(CAMPO_EMAIL),
                Click.on(BOTON_EMAIL)

        );


    }

    public static RegistroUsuarioEmail registroUsuarioEmail() {
        return new RegistroUsuarioEmail();
    }

}
