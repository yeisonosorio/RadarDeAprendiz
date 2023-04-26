package com.sofkau.Tasks.webUI;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.Enter;
import net.serenitybdd.screenplay.actions.Hit;
import net.serenitybdd.screenplay.waits.WaitUntil;
import org.openqa.selenium.Keys;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Wait;

import static com.sofkau.ui.webUI.ActivarCuenta.*;
import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isClickable;


public class ActivarCuentas implements Task {


    @Override
    public <T extends Actor> void performAs(T actor) {
        WebElement btnOkActivar;
        actor.attemptsTo(
                WaitUntil.the(BOTON_ACTIVAR, isClickable()).forNoMoreThan(10).seconds(),
                Click.on(BOTON_ACTIVAR),
                //  WaitUntil.the(BOTON_TRUE, isClickable()).forNoMoreThan(10).seconds(),
                Click.on(BOTON_TRUE),
                Hit.the(Keys.ENTER).into(BOTON_TRUE),
                WaitUntil.the(BTN_OK_ACTIVAR, isClickable()).forNoMoreThan(10).seconds()
                //Click.on(BTN_OK_ACTIVAR),
                //WaitUntil.the(BTN_OK_ACTIVAR, isClickable()).forNoMoreThan(10).seconds(),
                //Click.on(BTN_OK_ACTIVAR)

        );
    }






    public static ActivarCuentas activarCuentas() {
        return new ActivarCuentas();
    }


}
