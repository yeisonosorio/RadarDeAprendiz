package com.sofkau.Tasks.webUI;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.SelectFromOptions;
import static com.sofkau.ui.webUI.ActivarCuenta.*;



public class ActivarCuentas implements Task {


    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(

                SelectFromOptions.byValue("true").from(BOTON_ACTIVAR),
                Click.on(BTN_OK)


        );
    }


    public static ActivarCuentas activarCuentas() {
        return new ActivarCuentas();
    }


}
