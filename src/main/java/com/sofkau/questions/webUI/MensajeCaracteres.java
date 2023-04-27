package com.sofkau.questions.webUI;

import net.serenitybdd.screenplay.Question;
import net.serenitybdd.screenplay.questions.targets.TheTarget;
import net.serenitybdd.screenplay.targets.Target;
import org.openqa.selenium.By;

public class MensajeCaracteres {


    public static final Target MENSAJE_CARACTERES = Target.the("mensaje tno se permite caracteres")
            .located(By.xpath("//div[@class='altoMensaje']"));


    public static Question<String> isEqualTo() {
        return TheTarget.textOf(MENSAJE_CARACTERES);
    }

    private MensajeCaracteres() {
    }
}
