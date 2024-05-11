package com.eldar.prueba.TDC.Operations.validations.exceptions;

public class TarjetaNotFoundException extends Exception {

    private static String MESSAGE_EXCEPTION = "No se encontró la tarjeta con el número: ";

    public TarjetaNotFoundException(String tarjeta) {
        super(MESSAGE_EXCEPTION +tarjeta);
    }

    public TarjetaNotFoundException(String tarjeta, Throwable cause) {
        super(MESSAGE_EXCEPTION + tarjeta, cause);
    }
}

