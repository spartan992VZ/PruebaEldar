package com.eldar.prueba.TDC.Operations.validations.dto.request;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;

import java.time.LocalDate;

@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
public class TarjetaRequest {

    private String numeroTdc;
    private String marca;
    private String cardholder;
    private LocalDate fechaVencimito;
}
