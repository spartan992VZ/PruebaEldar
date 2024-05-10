package com.eldar.prueba.TDC.Operations.validations.dto.reponse;

import com.eldar.prueba.TDC.Operations.validations.dao.ModelResponse;
import com.eldar.prueba.TDC.Operations.validations.dto.TarjetaDTO;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;

import java.time.LocalDate;

@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
public class TarjetaResponse extends ModelResponse {
    private String numeroTdc;
    private String marca;
    private String cardholder;
    private LocalDate fechaVencimiento;
}
