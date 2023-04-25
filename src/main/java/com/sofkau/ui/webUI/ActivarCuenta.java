package com.sofkau.ui.webUI;

import net.serenitybdd.screenplay.targets.Target;
import net.thucydides.core.pages.PageObject;
import org.openqa.selenium.By;

public class ActivarCuenta extends PageObject {


    public static final Target BOTON_GOOGLE = Target.the("Boton Google")
            .located(By.xpath("//button[@_ngcontent-tfi-c1=''][contains(text(), 'Google')]"));


    public static final Target CAMPO_CORREO = Target.the("campo correo")
            .located(By.id("identifierId"));



    public static final Target CAMPO_PASSW = Target.the("campo correo")
            .located(By.id("(//*[@name='Passwd'])[1]"));


    public static final Target BOTON_SIGUIENTE = Target.the("campo correo")
            .located(By.xpath("//*[@class='VfPpkd-vQzf8d' and contains(text(), 'Siguiente')]"));



}
