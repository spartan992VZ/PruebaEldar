package com.eldar.prueba.TDC.Operations.validations.services;

import com.eldar.prueba.TDC.Operations.validations.controller.OperacionesController;
import com.eldar.prueba.TDC.Operations.validations.dto.OperacionDTO;
import com.eldar.prueba.TDC.Operations.validations.dto.reponse.OperacionResponse;
import com.eldar.prueba.TDC.Operations.validations.dto.request.TasaRequest;
import com.eldar.prueba.TDC.Operations.validations.exceptions.MarcaInvalidaException;
import com.eldar.prueba.TDC.Operations.validations.mapper.OperacionMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(path = "/operaciones")
public class OperacionRESTServiceImpl implements OperacionRESTService {

    @Autowired
    OperacionesController operaciones;

    private OperacionMapper mapper = OperacionMapper.INSTANCE;

    @PostMapping("/")
    public ResponseEntity<?> obtenerTasaOperacion(@RequestBody TasaRequest tasaRequest) {

        try {
            OperacionDTO dto = operaciones.tasaOperacion(tasaRequest.getMarca(),tasaRequest.getMonto());
            OperacionResponse response = mapper.toResponse(dto);
            return ResponseEntity.ok(response);
        }catch (MarcaInvalidaException e){
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(e.getMessage());
        }
    }


}
