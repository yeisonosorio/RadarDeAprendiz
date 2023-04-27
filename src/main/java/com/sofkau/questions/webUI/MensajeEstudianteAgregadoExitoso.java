package com.sofkau.questions.webUI;

import net.serenitybdd.screenplay.Question;
import net.serenitybdd.screenplay.questions.targets.TheTarget;
import net.serenitybdd.screenplay.targets.Target;
import org.openqa.selenium.By;

public class MensajeEstudianteAgregadoExitoso {



    public static final Target MENSAJE_ESTUDIANTE_AGREGADO_EXITO = Target.the("mensaje estudiante agregado")
            .located(By.cssSelector(".text-black.text-center.bg-success.bg-opacity-25.rounded-1.border-white.border-2"));




    public static Question<String> isEqualTo() {
        return TheTarget.textOf(MENSAJE_ESTUDIANTE_AGREGADO_EXITO);
    }

    private MensajeEstudianteAgregadoExitoso() {
    }




}
