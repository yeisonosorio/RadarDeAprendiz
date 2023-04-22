package com.sofkau.utils;

public enum Path {

    //Rutas de Ejmeplo
    SOAP_CAPITAL_BASE_URL("http://webservices.oorsprong.org/"),
    RESOURCE_CAPITAL("websamples.countryinfo/CountryInfoService.wso");


    private String value;

    Path(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }
}
