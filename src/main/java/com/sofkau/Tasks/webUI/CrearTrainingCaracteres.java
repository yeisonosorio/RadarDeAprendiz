package com.sofkau.Tasks.webUI;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.Enter;
import static com.sofkau.ui.webUI.CrearTraining.BOTON_CREAR_TRAINING;
import static com.sofkau.ui.webUI.DatosTraining.*;


public class CrearTrainingCaracteres implements Task {


    private String titulo;
    private String ciclo;


    public CrearTrainingCaracteres yConElTitulo(String titulo) {
        this.titulo = titulo;
        return this;
    }

    public CrearTrainingCaracteres conElCiclo(String ciclo) {
        this.ciclo = ciclo;
        return this;
    }


    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
                Click.on(BOTON_CREAR_TRAINING),
                Enter.theValue(titulo).into(CAMPO_TITLE),
                Enter.theValue(ciclo).into(CAMPO_CICLO)


        );

    }

    public static CrearTrainingCaracteres crearTrainingCaracteres() {
        return new CrearTrainingCaracteres();
    }

}
