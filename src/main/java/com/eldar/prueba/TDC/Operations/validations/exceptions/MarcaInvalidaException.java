package com.eldar.prueba.TDC.Operations.validations.exceptions;

import java.time.LocalDate;

public class MarcaInvalidaException extends Exception{

    private static String MESSAGE_EXCEPTION = "La marca de tarjeta no se encuentra registrada: ";

    public MarcaInvalidaException(String marca) {
        super(MESSAGE_EXCEPTION + marca);
    }

    public MarcaInvalidaException(String marca, Throwable cause) {
        super(MESSAGE_EXCEPTION + marca, cause);
    }
}
