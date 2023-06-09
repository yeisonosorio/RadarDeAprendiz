package com.sofkau.questions.rest;

import io.restassured.response.Response;
import net.serenitybdd.rest.SerenityRest;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;

public class ReturnRegister implements Question<Response> {
    @Override
    public Response answeredBy(Actor actor) {
        return SerenityRest.lastResponse().as(Response.class);

    }
    public static ReturnRegister returnRegister(){return new ReturnRegister();}
}
