package com.sofkau.ui.webUI;

import net.serenitybdd.screenplay.targets.Target;
import net.thucydides.core.pages.PageObject;
import org.openqa.selenium.By;

public class IrRegistro  extends PageObject {

    public static final Target BOTON_REGISTRO = Target.the("Registro")
            .located(By.xpath("(//*[@class='nav-link'])[2]"));

}
