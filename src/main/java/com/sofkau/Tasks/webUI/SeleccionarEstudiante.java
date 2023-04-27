package com.sofkau.Tasks.webUI;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.Hit;
import net.serenitybdd.screenplay.actions.SelectFromOptions;
import org.openqa.selenium.Keys;

import static com.sofkau.ui.webUI.AgregarEstudiante.*;
import static com.sofkau.ui.webUI.SelecionarTraining.SELECIONAR_TRAINING;


public class SeleccionarEstudiante implements Task {


    private String estudiante;


    public SeleccionarEstudiante conElEstudiante(String estudiante) {
        this.estudiante = estudiante;
        return this;
    }


    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
                Click.on(SELECIONAR_TRAINING),
                Click.on(BOTON_ADD_ESTUDIANTE),
                SelectFromOptions.byValue("yulis2323@hotmail.com").from(LISTA_ESTUDIANTE),
                Click.on(ADD_ESTUDIATE)


        );

    }

    public static SeleccionarEstudiante seleccionarEstudiante() {
        return new SeleccionarEstudiante();
    }


}
