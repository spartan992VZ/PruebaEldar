package com.eldar.prueba.TDC.Operations.validations.Utils;

public class TasaInteresVISA implements TasaInteres{


    @Override
    public Double caculoTasaInteres() {

        Integer digitosAño = PRESENTE.getYear() % 100;
        Integer mes = PRESENTE.getMonthValue();

        Double tasa = (double) digitosAño / mes;
        return tasa;
    }
}
