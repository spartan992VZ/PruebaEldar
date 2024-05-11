package com.eldar.prueba.TDC.Operations.validations.Utils;

import java.time.LocalDate;

public interface TasaInteres {

    final LocalDate PRESENTE= LocalDate.now();
    Double caculoTasaInteres();
}
