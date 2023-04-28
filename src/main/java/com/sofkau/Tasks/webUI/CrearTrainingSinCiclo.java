package com.sofkau.Tasks.webUI;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.Enter;
import static com.sofkau.ui.webUI.CrearTraining.BOTON_CREAR_TRAINING;
import static com.sofkau.ui.webUI.DatosTraining.*;

public class CrearTrainingSinCiclo  implements Task {


    private String titulo;



    public CrearTrainingSinCiclo yConElTitulo(String titulo) {
        this.titulo = titulo;
        return this;
    }




    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
                Click.on(BOTON_CREAR_TRAINING),
                Enter.theValue(titulo).into(CAMPO_TITLE),
                Click.on(CAMPO_CICLO),
                Click.on(CAMPO_TITLE)


        );

    }

    public static CrearTrainingSinCiclo crearTrainingSinCiclo() {
        return new CrearTrainingSinCiclo();
    }
}
