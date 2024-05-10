package com.eldar.prueba.TDC.Operations.validations.services;

import com.eldar.prueba.TDC.Operations.validations.dto.reponse.TarjetaResponse;
import com.eldar.prueba.TDC.Operations.validations.dto.request.TarjetaRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(path = "/tarjeta")
public interface TarjetaCreditoRESTService {


    @GetMapping("/{number}")
    public ResponseEntity<TarjetaResponse> obtenerTarjeta(@PathVariable String number);
    @PostMapping("/registrarNuevaTarjeta")
    public ResponseEntity<TarjetaResponse> crearTarjeta(@RequestBody TarjetaRequest tarjeta);

    @PostMapping("/actualizarDatos")
    public ResponseEntity<TarjetaResponse> actualizarDatosTarjeta( @RequestBody TarjetaRequest tarjeta);

    @DeleteMapping("/elimina")
    public ResponseEntity<?> eliminarTarjeta(@PathVariable String number);
}
