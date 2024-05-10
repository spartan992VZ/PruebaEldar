package com.eldar.prueba.TDC.Operations.validations.services;

import com.eldar.prueba.TDC.Operations.validations.controller.TarjetaController;
import com.eldar.prueba.TDC.Operations.validations.dto.TarjetaDTO;
import com.eldar.prueba.TDC.Operations.validations.dto.reponse.TarjetaResponse;
import com.eldar.prueba.TDC.Operations.validations.dto.request.TarjetaRequest;
import com.eldar.prueba.TDC.Operations.validations.mapper.TarjetaMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;

public class TarjetaCreditoRESTServiceImpl implements TarjetaCreditoRESTService{
    @Autowired
    private TarjetaController tarjetaController;

    private TarjetaMapper mapper;
    @Override
    public ResponseEntity<TarjetaResponse> obtenerTarjeta(String number) {

        TarjetaDTO tarjeta = tarjetaController.obtenerTarjeta(number);

        TarjetaResponse response = mapper.toResponse(tarjeta);
        //if (tarjeta.isPresent()) {
            return ResponseEntity.ok(response);
        /*} else {
            return ResponseEntity.notFound().build();
        }*/
    }

    @Override
    public ResponseEntity<TarjetaResponse> crearTarjeta(TarjetaRequest tarjeta) {
        return null;
    }

    @Override
    public ResponseEntity<TarjetaResponse> actualizarDatosTarjeta(TarjetaRequest tarjeta) {
        return null;
    }

    @Override
    public ResponseEntity<?> eliminarTarjeta(String number) {
        return null;
    }
}
