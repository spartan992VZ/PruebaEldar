package com.eldar.prueba.TDC.Operations.validations.mapper;

import com.eldar.prueba.TDC.Operations.validations.dto.TarjetaDTO;
import com.eldar.prueba.TDC.Operations.validations.dto.reponse.TarjetaResponse;
import com.eldar.prueba.TDC.Operations.validations.dto.request.TarjetaRequest;
import com.eldar.prueba.TDC.Operations.validations.modelos.TarjetaCredito;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper
public interface TarjetaMapper{

    TarjetaMapper INSTANCE = Mappers.getMapper(TarjetaMapper.class);

    @Mapping(target = "numeroTdc", source = "numeroTdc")
    @Mapping(target = "marca", source = "marca")
    @Mapping(target = "cardholder", source = "cardholder")
    @Mapping(target = "fechaVencimiento", source = "fechaVencimiento")
    TarjetaResponse toResponse(TarjetaDTO dto);

    List<TarjetaResponse> listToListResponse(List<TarjetaDTO> dtos);

    @Mapping(target = "numeroTdc", source = "dto.numeroTdc")
    @Mapping(target = "marca", source = "dto.marca")
    @Mapping(target = "cardholder", source = "dto.cardholder")
    @Mapping(target = "fechaVencimiento", source = "dto.fechaVencimiento")
    TarjetaCredito toEntity(TarjetaDTO dto);


    TarjetaDTO toDTO(TarjetaCredito tarjetaCredito);

    @Mapping(target = "numeroTdc", source = "request.numeroTdc")
    @Mapping(target = "marca", source = "request.marca")
    @Mapping(target = "cardholder", source = "request.cardholder")
    @Mapping(target = "fechaVencimiento", source = "request.fechaVencimiento")
    TarjetaDTO toDTO(TarjetaRequest request);


}
