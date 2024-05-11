package com.eldar.prueba.TDC.Operations.validations.dto.reponse;

import com.eldar.prueba.TDC.Operations.validations.dao.ModelResponse;
import com.eldar.prueba.TDC.Operations.validations.dto.TarjetaDTO;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
public class ListaTarjetaRespose extends ModelResponse {
    List<TarjetaDTO> listaTarjetas;
}
