package com.sofkau.ui.webUI;

import net.serenitybdd.screenplay.targets.Target;
import net.thucydides.core.pages.PageObject;
import org.openqa.selenium.By;

public class DatosTraining extends PageObject {


    public static final Target CAMPO_TITLE = Target.the("Campo titulo")
            .located(By.id("titleInput"));


    public static final Target CAMPO_CICLO = Target.the("Campo ciclo")
            .located(By.id("cicleInput"));


    public static final Target BOTON_CREAR_NEW_TRAINING = Target.the("Campo ciclo")
            .located(By.xpath("//button[normalize-space()='Create Training']"));

}
