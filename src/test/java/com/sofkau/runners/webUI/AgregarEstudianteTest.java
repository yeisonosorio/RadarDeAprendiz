package com.sofkau.runners.webUI;


import io.cucumber.junit.CucumberOptions;
import net.serenitybdd.cucumber.CucumberWithSerenity;
import org.junit.runner.RunWith;

@RunWith(CucumberWithSerenity.class)
@CucumberOptions(
        snippets = CucumberOptions.SnippetType.CAMELCASE,
        features = {"src/test/resources/features/webUI/agregarestudiantetraining.feature"},
        glue = {"com.sofkau.stepdefinitions"},
        tags = {""}
)
public class AgregarEstudianteTest {
}
