package com.eldar.prueba.TDC.Operations.validations.exceptions;

import java.time.LocalDate;

public class TarjetaInvalidaException extends Exception{

    private static String MESSAGE_EXCEPTION = "La tarjeta no es valida para operar, su fecha expiró: ";

    public TarjetaInvalidaException(LocalDate fechaVencimiento) {
        super(MESSAGE_EXCEPTION + fechaVencimiento);
    }

    public TarjetaInvalidaException(LocalDate fechaVencimiento, Throwable cause) {
        super(MESSAGE_EXCEPTION + fechaVencimiento, cause);
    }
}
