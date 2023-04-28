package com.sofkau.ui.webUI;

import net.serenitybdd.screenplay.targets.Target;
import org.openqa.selenium.By;

public class AgregarEstudiante extends Object {


    public static final Target BOTON_ADD_ESTUDIANTE = Target.the("Boton add un estudiante")
            .located(By.xpath("//button[@type='button'][normalize-space()='Add Student']"));


    public static final Target LISTA_ESTUDIANTE = Target.the("Boton lista de estudiante")
            .located(By.xpath("//select[@id='student-select']"));


    public static final Target ADD_ESTUDIATE = Target.the("Boton add")
            .located(By.cssSelector(".btn.btn-primary.mx-1.px-4"));



}
