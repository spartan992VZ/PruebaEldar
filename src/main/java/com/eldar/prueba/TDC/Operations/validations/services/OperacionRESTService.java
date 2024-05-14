package com.eldar.prueba.TDC.Operations.validations.services;

import com.eldar.prueba.TDC.Operations.validations.dto.request.TasaRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(path = "/")
public interface OperacionRESTService {

    @PostMapping("/operacion")
    public ResponseEntity<?> obtenerTasaOperacion(@RequestBody TasaRequest tasaRequest);

    /*@PostMapping("/operacion")
    public ResponseEntity<OperacionResponse> validarOperacion(@RequestBody OperacionRequest operacionRequest);
*/
}
