package com.sofkau.ui.webUI;

import net.serenitybdd.screenplay.targets.Target;
import org.openqa.selenium.By;

public class SelecionarTraining extends Object{



    public static final Target SELECIONAR_TRAINING = Target.the("Boton selecionar un training")
            .located(By.cssSelector("ul:nth-child(3) button:nth-child(1)"));


}
