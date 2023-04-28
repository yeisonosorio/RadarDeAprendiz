package com.sofkau.Tasks.webUI;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;
import static com.sofkau.ui.webUI.IrLogin.BOTON_IR_LOGIN;

public class IrLogin implements Task {



    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
                Click.on(BOTON_IR_LOGIN)


        );

    }

    public static IrLogin irLogin() {
        return new IrLogin();
    }

}
