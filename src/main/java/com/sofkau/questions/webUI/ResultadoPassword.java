package com.sofkau.questions.webUI;

import net.serenitybdd.screenplay.Question;
import net.serenitybdd.screenplay.questions.targets.TheTarget;
import net.serenitybdd.screenplay.targets.Target;

import static org.openqa.selenium.By.xpath;

public class ResultadoPassword {

    public static final Target MENSAJE_PASSWORD = Target
            .the("MENSAJE DE NOMBRE REQUERIDO")
            .located(xpath("//*[@class='altoMensaje' and contains(text(),' * El password es requerido ')]"));

    public static Question<String> isEqualTo() {
        return TheTarget.textOf(MENSAJE_PASSWORD);
    }

    private ResultadoPassword() {
    }

}
