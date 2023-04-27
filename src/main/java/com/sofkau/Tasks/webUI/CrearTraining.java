package com.sofkau.Tasks.webUI;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.Enter;
import net.serenitybdd.screenplay.waits.WaitUntil;

import static com.sofkau.ui.webUI.CrearTraining.BOTON_CREAR_TRAINING;
import static com.sofkau.ui.webUI.DatosTraining.*;
import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isClickable;
import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isEnabled;

public class CrearTraining implements Task {


    private String titulo;
    private String ciclo;


    public CrearTraining yConElTitulo(String titulo) {
        this.titulo = titulo;
        return this;
    }

    public CrearTraining conElCiclo(String ciclo) {
        this.ciclo = ciclo;
        return this;
    }


    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
                Click.on(BOTON_CREAR_TRAINING),
                Enter.theValue(titulo).into(CAMPO_TITLE),
                Enter.theValue(ciclo).into(CAMPO_CICLO),
                WaitUntil.the(BOTON_CREAR_NEW_TRAINING, isEnabled()).forNoMoreThan(10).seconds(),
                Click.on(BOTON_CREAR_NEW_TRAINING)

        );

    }

    public static CrearTraining crearTraining() {
        return new CrearTraining();
    }
}
