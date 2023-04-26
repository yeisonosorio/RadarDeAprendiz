package com.sofkau.ui.webUI;

import net.serenitybdd.screenplay.targets.Target;
import net.thucydides.core.pages.PageObject;
import org.openqa.selenium.By;

public class MensajeRegistro extends PageObject {

    public static final Target MENSAJE_REGISTRO = Target.the("nombre ok")
            .located(By.xpath("//*[@class='swal2-confirm swal2-styled']"));



}
