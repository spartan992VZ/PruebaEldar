package com.eldar.prueba.TDC.Operations.validations.mapper;

import com.eldar.prueba.TDC.Operations.validations.dto.TarjetaDTO;
import com.eldar.prueba.TDC.Operations.validations.dto.reponse.TarjetaResponse;
import com.eldar.prueba.TDC.Operations.validations.modelos.TarjetaCredito;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper
public interface TarjetaMapper{

    @Mapping(target = "numeroTdc", source = "numeroTdc")
    @Mapping(target = "marca", source = "marca")
    @Mapping(target = "cardholder", source = "cardholder")
    @Mapping(target = "fechaVencimiento", source = "fechaVencimiento")
    TarjetaResponse toResponse(TarjetaDTO dto);

    @Mapping(target = "numeroTdc", source = "dto.numeroTdc")
    @Mapping(target = "marca", source = "dto.marca")
    @Mapping(target = "cardholder", source = "dto.cardholder")
    @Mapping(target = "fechaVencimiento", source = "dto.fechaVencimiento")
    TarjetaCredito toEntity(TarjetaDTO dto);


}
