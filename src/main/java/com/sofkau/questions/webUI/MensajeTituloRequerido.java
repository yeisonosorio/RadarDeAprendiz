package com.sofkau.questions.webUI;

import net.serenitybdd.screenplay.Question;
import net.serenitybdd.screenplay.questions.targets.TheTarget;
import net.serenitybdd.screenplay.targets.Target;
import org.openqa.selenium.By;

public class MensajeTituloRequerido {



    public static final Target MENSAJE_TITULO = Target.the("mensaje training creado")
            .located(By.xpath("//*[@class='altoMensaje' and contains(text(),' * Title is required ')]"));




    public static Question<String> isEqualTo() {
        return TheTarget.textOf(MENSAJE_TITULO);
    }

    private MensajeTituloRequerido() {
    }
}
