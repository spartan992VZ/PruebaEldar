package com.eldar.prueba.TDC.Operations.validations.services;

import com.eldar.prueba.TDC.Operations.validations.dto.reponse.ListaTarjetaRespose;
import com.eldar.prueba.TDC.Operations.validations.dto.reponse.TarjetaResponse;
import com.eldar.prueba.TDC.Operations.validations.dto.request.TarjetaRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(path = "/tarjeta")
public interface TarjetaCreditoRESTService {


    @GetMapping("/{number}")
    ResponseEntity<TarjetaResponse> obtenerTarjeta(@PathVariable String number);

    @GetMapping("/tarjetas")
    ResponseEntity<ListaTarjetaRespose> obtenerTodaTarjeta();

    @PostMapping("/registrarNuevaTarjeta")
    ResponseEntity<String> crearTarjeta(@RequestBody TarjetaRequest tarjeta);

    @GetMapping("/validar/{number}")
    ResponseEntity<String> validarTarjeta(@PathVariable String number);

}
