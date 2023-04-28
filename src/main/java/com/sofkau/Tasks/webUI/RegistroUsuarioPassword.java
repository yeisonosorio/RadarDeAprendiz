package com.sofkau.Tasks.webUI;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.Enter;
import static com.sofkau.ui.webUI.RegistroUsuario.*;

public class RegistroUsuarioPassword implements Task {

    private String nombre;
    private String email;


    public RegistroUsuarioPassword conElNombre(String nombre) {
        this.nombre = nombre;
        return this;
    }

    public RegistroUsuarioPassword yConElEmail(String email) {
        this.email = email;
        return this;
    }


    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
                Enter.theValue(nombre).into(CAMPO_NOMBRE),
                Enter.theValue(email).into(CAMPO_EMAIL),
                Click.on(CAMPO_PASSWORD),
                Click.on(BOTON_PASSWORD)

        );


    }

    public static RegistroUsuarioPassword registroUsuarioPassword() {
        return new RegistroUsuarioPassword();
    }

}
