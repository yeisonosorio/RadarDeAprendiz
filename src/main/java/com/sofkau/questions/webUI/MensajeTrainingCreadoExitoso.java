package com.sofkau.questions.webUI;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;
import net.serenitybdd.screenplay.questions.targets.TheTarget;
import net.serenitybdd.screenplay.targets.Target;
import net.thucydides.core.pages.PageObject;
import org.openqa.selenium.By;

public class MensajeTrainingCreadoExitoso {



    public static final Target MENSAJE_CREAR_TRAINING_OK = Target.the("mensaje training creado")
            .located(By.cssSelector(".text-black.text-center"));




    public static Question<String> isEqualTo() {
        return TheTarget.textOf(MENSAJE_CREAR_TRAINING_OK);
    }

    private MensajeTrainingCreadoExitoso() {
    }

}
