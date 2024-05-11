package com.eldar.prueba.TDC.Operations.validations.Utils;

public class TasaInteresAMEX implements TasaInteres{

    private final Double TASA_AMEX = 0.1;
    @Override
    public  Double caculoTasaInteres() {

        return (PRESENTE.getMonthValue() * TASA_AMEX);
    }
}
