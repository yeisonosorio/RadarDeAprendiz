package com.sofkau.ui.webUI;


import net.serenitybdd.screenplay.targets.Target;
import net.thucydides.core.pages.PageObject;
import org.openqa.selenium.By;

public class RegistroUsuario extends PageObject {


    public static final Target CAMPO_NOMBRE = Target.the("Campo nombre")
            .located(By.id("input-name"));

    public static final Target CAMPO_EMAIL = Target.the("Campo email")
            .located(By.id("input-email"));

    public static final Target CAMPO_PASSWORD = Target.the("Campo password")
            .located(By.id("input-password"));

    public static final Target BOTON_LOGIN = Target.the("Boton login")
            .located(By.id("btn-login"));


    /**
     * BOTON AL AIRE
     */
    public static final Target BOTON_NOMBRE = Target.the("Boton campo nombre")
            .located(By.xpath("//*[@id='basic-addon1'][1]"));


    public static final Target BOTON_EMAIL = Target.the("Boton campo email")
            .located(By.xpath("//*[@id='basic-addon1'][2]"));



    public static final Target BOTON_PASSWORD = Target.the("Boton campo nombre")
            .located(By.xpath("//*[@id='basic-addon1'][3]"));



}
