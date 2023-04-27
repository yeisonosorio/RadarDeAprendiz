package com.sofkau.questions.webUI;

import net.serenitybdd.screenplay.Question;
import net.serenitybdd.screenplay.questions.targets.TheTarget;
import net.serenitybdd.screenplay.targets.Target;
import org.openqa.selenium.By;

public class MensajeCicloRequerido {


    public static final Target MENSAJE_CICLO = Target.the("mensaje training creado")
            .located(By.xpath("//*[@class='altoMensaje' and contains(text(),' * El Ciclo no puede ir vacio')]"));




    public static Question<String> isEqualTo() {
        return TheTarget.textOf(MENSAJE_CICLO);
    }

    private MensajeCicloRequerido() {
    }
}
