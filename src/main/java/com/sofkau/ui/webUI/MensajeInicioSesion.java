package com.sofkau.ui.webUI;

import net.serenitybdd.screenplay.targets.Target;
import net.thucydides.core.pages.PageObject;
import org.openqa.selenium.By;

public class MensajeInicioSesion extends PageObject {


    public static final Target MENSAJE_INICIO_SESION = Target.the("nombre ok")
            .located(By.xpath("//button[contains(text(),'New Training League')]"));





}
