package com.eldar.prueba.TDC.Operations.validations.services;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(path = "/")
public interface OperacionRESTService {

   /* @PostMapping("/validar")
    public ResponseEntity<Boolean> validarOperacion(@RequestBody Operacion operacion);
*/

    @GetMapping
    public ResponseEntity<Double> obtenerTasaOperacion(@RequestParam("marca") String marca, @RequestParam("importe") double importe);

}
