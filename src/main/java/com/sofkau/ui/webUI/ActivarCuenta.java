package com.sofkau.ui.webUI;

import net.serenitybdd.screenplay.targets.Target;
import net.thucydides.core.pages.PageObject;
import org.openqa.selenium.By;

public class ActivarCuenta extends PageObject {

    public static final Target BOTON_ACTIVAR = Target.the("Campo email")
            .located(By.xpath("(//*[@id='activate'])[4]"));


    public static final Target BOTON_TRUE = Target.the("BOTON TRUE")
            .located(By.xpath("(//option[@value=\"true\"])[4]"));

    public static final Target BTN_OK_ACTIVAR = Target.the("Boton login")
            .located(By.xpath("//*[@class='swal2-confirm swal2-styled']"));

}
