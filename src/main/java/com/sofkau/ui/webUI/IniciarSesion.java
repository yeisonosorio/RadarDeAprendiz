package com.sofkau.ui.webUI;

import net.serenitybdd.screenplay.targets.Target;
import net.thucydides.core.pages.PageObject;
import org.openqa.selenium.By;

public class IniciarSesion extends PageObject {


    public static final Target CAMPO_EMAIL_LOGIN = Target.the("Campo email")
            .located(By.id("input-email"));


    public static final Target CAMPO_PASSWORD_LOGIN = Target.the("Campo password")
            .located(By.id("input-password"));


    public static final Target BTN_LOGIN = Target.the("Boton login")
            .located(By.id("btn-login"));

    public static final Target BTN_OK = Target.the("Boton login")
            .located(By.xpath("//*[@class='swal2-confirm swal2-styled']"));


    public static final Target BOTON_PASSWORD2 = Target.the("Boton login")
            .located(By.xpath("//*[@id='basic-addon1'][2]"));



}
