package com.sofkau.questions.webUI;

import net.serenitybdd.screenplay.Question;
import net.serenitybdd.screenplay.questions.targets.TheTarget;
import net.serenitybdd.screenplay.targets.Target;

import static org.openqa.selenium.By.xpath;

public class ResultadoEmail {


    public static final Target MENSAJE_EMAIL = Target
            .the("MENSAJE EL EMAL ES REQUERIDO")
            .located(xpath("//*[@class='altoMensaje' and contains(text(),' * El Email es requerido ')]"));

    public static Question<String> isEqualTo() {
        return TheTarget.textOf(MENSAJE_EMAIL);
    }

    private ResultadoEmail() {
    }

}
