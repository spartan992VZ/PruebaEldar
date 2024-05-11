package com.eldar.prueba.TDC.Operations.validations.mapper;

import com.eldar.prueba.TDC.Operations.validations.dto.OperacionDTO;
import com.eldar.prueba.TDC.Operations.validations.dto.reponse.OperacionResponse;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface OperacionMapper {
     OperacionMapper INSTANCE = Mappers.getMapper(OperacionMapper.class);

     OperacionResponse toResponse(OperacionDTO dto);
}
