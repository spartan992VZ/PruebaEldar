package com.eldar.prueba.TDC.Operations.validations.exceptions;

public class OperacionInvalidaException extends Exception{

    private static String MESSAGE_EXCEPTION = "El monto de la operacion supera el maximo permitido: ";

    public OperacionInvalidaException(Double monto) {
        super(MESSAGE_EXCEPTION + monto);
    }

    public OperacionInvalidaException(Double monto, Throwable cause) {
        super(MESSAGE_EXCEPTION + monto, cause);
    }
}
