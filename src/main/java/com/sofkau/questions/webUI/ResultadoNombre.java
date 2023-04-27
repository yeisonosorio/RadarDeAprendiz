package com.sofkau.questions.webUI;

import net.serenitybdd.screenplay.Question;
import net.serenitybdd.screenplay.questions.targets.TheTarget;
import net.serenitybdd.screenplay.targets.Target;

import static org.openqa.selenium.By.xpath;

public class ResultadoNombre {


    public static final Target MENSAJE_NOMBRE = Target
            .the("MENSAJE DE NOMBRE REQUERIDO")
            .located(xpath("//*[@class='altoMensaje' and contains(text(),' * El Nombre es requerido ')]"));

    public static Question<String> isEqualTo() {
        return TheTarget.textOf(MENSAJE_NOMBRE);
    }

    private ResultadoNombre() {
    }
}
