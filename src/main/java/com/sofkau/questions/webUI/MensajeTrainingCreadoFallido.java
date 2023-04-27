package com.sofkau.questions.webUI;

import net.serenitybdd.screenplay.Question;
import net.serenitybdd.screenplay.questions.targets.TheTarget;
import net.serenitybdd.screenplay.targets.Target;
import org.openqa.selenium.By;

public class MensajeTrainingCreadoFallido {



    public static final Target MENSAJE_CREAR_TRAINING_FALLIDO = Target.the("mensaje training no creado")
            .located(By.xpath("//*[@class='text-black text-center' and text()=' Failed: Only Caoch can Create a Training League ']"));




    public static Question<String> isEqualTo() {
        return TheTarget.textOf(MENSAJE_CREAR_TRAINING_FALLIDO);
    }

    private MensajeTrainingCreadoFallido() {
    }

}
