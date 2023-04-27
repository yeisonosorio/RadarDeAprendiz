package com.sofkau.ui.webUI;

import net.serenitybdd.screenplay.targets.Target;
import org.openqa.selenium.By;

public class MensajeInicioSesion {


    public static final Target MENSAJE_INICIO_SESION = Target.the("nombre ok")
            .located(By.xpath("//button[contains(text(),'New Training League')]"));





}
