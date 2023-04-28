package com.sofkau.ui.webUI;

import net.serenitybdd.screenplay.targets.Target;
import net.thucydides.core.pages.PageObject;
import org.openqa.selenium.By;

public class IrLogin extends PageObject {

    public static final Target BOTON_IR_LOGIN = Target.the("boton DONDE ENVIAR")
            .located(By.xpath("(//*[@class='nav-link'])[1]"));

}
