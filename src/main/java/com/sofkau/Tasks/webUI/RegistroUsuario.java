package com.sofkau.Tasks.webUI;


import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.Enter;

import static com.sofkau.ui.webUI.RegistroUsuario.*;

public class RegistroUsuario implements Task {

    private String nombre;
    private String email;
    private String password;


    public RegistroUsuario conElNombre(String nombre) {
        this.nombre = nombre;
        return this;
    }

    public RegistroUsuario yConElEmail(String email) {
        this.email = email;
        return this;
    }

    public RegistroUsuario conElPassword(String password) {
        this.password = password;
        return this;
    }


    @Override
    public <T extends Actor> void performAs(T actor) {


        actor.attemptsTo(
                //  WaitUntil.the(CAMPO_NOMBRE, isClickable()).forNoMoreThan(10).seconds(),
                Enter.theValue(nombre).into(CAMPO_NOMBRE),
                Enter.theValue(email).into(CAMPO_EMAIL),
                Enter.theValue(password).into(CAMPO_PASSWORD),
                Click.on(BOTON_LOGIN)


        );


    }

    public static RegistroUsuario registroUsuario() {
        return new RegistroUsuario();
    }


}
