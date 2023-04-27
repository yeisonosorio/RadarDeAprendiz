package com.sofkau.questions.webUI;

import net.serenitybdd.screenplay.Question;
import net.serenitybdd.screenplay.questions.targets.TheTarget;
import net.serenitybdd.screenplay.targets.Target;
import org.openqa.selenium.By;

public class MensajeTrainingCreadoFallido {



    public static final Target MENSAJE_CREAR_TRAINING_FALLIDO = Target.the("mensaje training no creado")
            .located(By.cssSelector(".text-black.text-center.bg-danger.bg-opacity-25.rounded-1.border-white.border-2"));




    public static Question<String> isEqualTo() {
        return TheTarget.textOf(MENSAJE_CREAR_TRAINING_FALLIDO);
    }

    private MensajeTrainingCreadoFallido() {
    }

}
