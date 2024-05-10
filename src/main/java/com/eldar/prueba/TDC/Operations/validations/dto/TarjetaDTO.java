package com.eldar.prueba.TDC.Operations.validations.dto;

import lombok.Data;

import java.time.LocalDate;

@Data
public class TarjetaDTO {
    private String numeroTdc;
    private String marca;
    private String cardholder;
    private LocalDate fechaVencimiento;
}
