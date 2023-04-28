package com.sofkau.Tasks.webUI;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;
import static com.sofkau.ui.webUI.IrRegistro.BOTON_REGISTRO;

public class IrRegistro implements Task {


    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
                Click.on(BOTON_REGISTRO)


        );

    }

    public static IrRegistro irRegistro() {
        return new IrRegistro();
    }


}
