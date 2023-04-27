package com.sofkau.ui.webUI;

import net.serenitybdd.screenplay.targets.Target;
import net.thucydides.core.pages.PageObject;
import org.openqa.selenium.By;

public class CrearTraining  extends PageObject {


    public static final Target BOTON_CREAR_TRAINING = Target.the("boton crear un numero training")
            .located(By.xpath("//button[normalize-space()='New Training League']"));




}
