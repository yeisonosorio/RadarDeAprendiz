package com.sofkau.ui.webUI;

import net.serenitybdd.screenplay.targets.Target;
import net.thucydides.core.pages.PageObject;
import org.openqa.selenium.By;

public class DatosTrainingRequeridos extends PageObject {


    public static final Target CAMPO_TITULO_REQUE = Target.the("Campo titulo")
            .located(By.xpath("//*[@class='altoMensaje' and contains(text(),' * Title is required ')]"));



    public static final Target CAMPO_CICLO_REQUE = Target.the("Campo cilo")
            .located(By.xpath("//*[@class='altoMensaje' and contains(text(),' * Cicle is required')]"));




}
