package com.sofkau.questions.webUI;

import net.serenitybdd.screenplay.Question;
import net.serenitybdd.screenplay.questions.targets.TheTarget;
import net.serenitybdd.screenplay.targets.Target;

import static org.openqa.selenium.By.xpath;

public class ResultadoErrorIniciar {


    public static final Target MENSAJE_INICIAR_ERROR = Target.the("MENSAJE DE INICIO DE SESION FALLO")
            .located(xpath("//*[@class='swal2-title' and contains(text(),'Error')]"));

    public static Question<String> isEqualTo() {
        return TheTarget.textOf(MENSAJE_INICIAR_ERROR);
    }

    private ResultadoErrorIniciar() {
    }
}
