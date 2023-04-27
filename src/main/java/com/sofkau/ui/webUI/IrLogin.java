package com.sofkau.ui.webUI;

import net.serenitybdd.screenplay.targets.Target;
import org.openqa.selenium.By;

public class IrLogin {

    public static final Target BOTON_IR_LOGIN = Target.the("boton DONDE ENVIAR")
            .located(By.xpath("(//*[@class='nav-link'])[1]"));

}
