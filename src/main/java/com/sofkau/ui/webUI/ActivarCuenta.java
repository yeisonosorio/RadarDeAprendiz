package com.sofkau.ui.webUI;

import net.serenitybdd.screenplay.targets.Target;
import net.thucydides.core.pages.PageObject;
import org.openqa.selenium.By;

public class ActivarCuenta extends PageObject {

    public static final Target BOTON_ACTIVAR = Target.the("Campo email")
            .located(By.xpath("(//*[@id='activate'])[5]"));


    public static final Target BTN_OK = Target.the("Boton login")
            .located(By.xpath("//button[normalize-space()='OK']"));

    public static final Target BTN_ACTIVACION_OK = Target.the("Boton login")
            .located(By.xpath("//button[normalize-space()='OK']"));



}
