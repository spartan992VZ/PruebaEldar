package com.eldar.prueba.TDC.Operations.validations.Utils;

public class TasaInteresNARA implements TasaInteres {

    private final Double TASA_NARA = 0.5;
    @Override
    public Double caculoTasaInteres() {

        return (PRESENTE.getDayOfMonth() * TASA_NARA);
    }
}
