package com.sofkau.questions.webUI;

import net.serenitybdd.screenplay.Question;
import net.serenitybdd.screenplay.questions.targets.TheTarget;
import net.serenitybdd.screenplay.targets.Target;
import org.openqa.selenium.By;

public class MenssajeEstudianteAgregado {

    public static final Target ESTUDIANTE_AGREGADO_FALLIDO = Target.the("mensaje estudiante agregado")
            .located(By.cssSelector(".text-black.text-center.bg-danger.bg-opacity-25.rounded-1.border-white.border-2"));




    public static Question<String> isEqualTo() {
        return TheTarget.textOf(ESTUDIANTE_AGREGADO_FALLIDO);
    }

    private MenssajeEstudianteAgregado() {
    }



}
