package com.sofkau.Tasks.webUI;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.Enter;
import static com.sofkau.ui.webUI.CrearTraining.BOTON_CREAR_TRAINING;
import static com.sofkau.ui.webUI.DatosTraining.*;

public class CrearTrainingSinTitulo implements Task {


    private String ciclo;


    public CrearTrainingSinTitulo conElCiclo(String ciclo) {
        this.ciclo = ciclo;
        return this;
    }


    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
                Click.on(BOTON_CREAR_TRAINING),
                Enter.theValue(ciclo).into(CAMPO_CICLO),
                Click.on(CAMPO_TITLE),
                Click.on(CAMPO_CICLO)

        );

    }

    public static CrearTrainingSinTitulo crearTrainingSinTitulo() {
        return new CrearTrainingSinTitulo();
    }
}
