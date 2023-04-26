package com.sofkau.utils;

public enum UrlResources {

    RADAR_BASE_URL("https://final-back-end-production.up.railway.app"),
    GET_RESOURCE("/login"),
    REGISTER_USER_BASE_URL("https://final-back-end-production.up.railway.app/login/register/login"),
    POST_REGISTER_USER_RESOURCE("/register"),
    ACTUALIZAR_USER_BASE_URL("https://final-back-end-production.up.railway.app/login/"),
    PUT_USER_RESOURCE("update/"),
    GET_ALL_TRAINING_BASE_URL("https://final-back-end-production.up.railway.app/training-league/get-all"),
    GET_TRAINING_RESOURCE("/"),
    GET_ALL_STUDENT_EVALUATION_BASE_URL("https://final-back-end-production.up.railway.app/student-evaluation/get-all/"),
    GET_STUDENT_EVALUATION_RESOURCE("/"),
    GET_ALL_RADARES_BASE_URL("https://final-back-end-production.up.railway.app"),
    GET_RADAR_RESOURCE("/radar");
    private final String value;

    UrlResources(String value){
        this.value=value;
    }

    public String getValue(){
        return value;
    }
}