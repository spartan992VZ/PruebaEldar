package com.eldar.prueba.TDC.Operations.validations.services;

import com.eldar.prueba.TDC.Operations.validations.dto.reponse.TarjetaResponse;
import com.eldar.prueba.TDC.Operations.validations.dto.request.TarjetaRequest;
import org.springframework.http.ResponseEntity;

public class TarjetaCreditoRESTServiceImpl implements TarjetaCreditoRESTService{
    @Override
    public ResponseEntity<TarjetaResponse> obtenerTarjeta(String number) {
        return null;
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
