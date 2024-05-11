package com.eldar.prueba.TDC.Operations.validations.controller;

import com.eldar.prueba.TDC.Operations.validations.Utils.TasaInteresAMEX;
import com.eldar.prueba.TDC.Operations.validations.Utils.TasaInteresNARA;
import com.eldar.prueba.TDC.Operations.validations.Utils.TasaInteresVISA;
import com.eldar.prueba.TDC.Operations.validations.dto.OperacionDTO;
import com.eldar.prueba.TDC.Operations.validations.exceptions.OperacionInvalidaException;
import com.eldar.prueba.TDC.Operations.validations.exceptions.TarjetaInvalidaException;
import com.eldar.prueba.TDC.Operations.validations.modelos.TarjetaCredito;
import com.eldar.prueba.TDC.Operations.validations.repository.TarjetaCreditoDAORepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import java.time.LocalDate;

@Controller
public class OperacionesController {

    private static Integer MONTO_MAXIMO = 1000;

    private TasaInteresVISA tasaVisa;

    private TasaInteresNARA tasaNara;

    private TasaInteresAMEX tasaAmex;

    @Autowired
    private TarjetaCreditoDAORepository tarjetaCreditoRepository;

    public boolean validarOperacion(Double monto, String numeroTdc) throws OperacionInvalidaException, TarjetaInvalidaException{

        if (monto > MONTO_MAXIMO){
            throw new OperacionInvalidaException(monto);
        }

        TarjetaCredito tarjetaCredito = tarjetaCreditoRepository.getById(numeroTdc);

        if (esVigente(tarjetaCredito)){
            throw new TarjetaInvalidaException(tarjetaCredito.getFechaVencimiento());
        }
        return true;
    }

    public OperacionDTO tasaOperacion(String marca, Double monto){

        Double tasa = (monto / obtenerTasaOperacion(marca.toUpperCase()));

        OperacionDTO dto = new OperacionDTO();

        dto.setTasa(tasa);
        dto.setMonto(monto);
        dto.setMarca(marca.toUpperCase());
        return dto;
    }

    private double obtenerTasaOperacion(String marca) {

        tasaAmex = new TasaInteresAMEX();
        tasaVisa = new TasaInteresVISA();
        tasaNara = new TasaInteresNARA();

        switch ( marca ){
            case "VAMEX":
                return tasaAmex.caculoTasaInteres();
            case "NARA":
                return tasaNara.caculoTasaInteres();
            case "VISA":
                return tasaVisa.caculoTasaInteres();
            default:
                throw new IllegalArgumentException("Marca de tarjeta no reconocida: " + marca);
        }
    }

    private boolean esVigente(TarjetaCredito tarjetaOptional) {
        LocalDate fechaActual = LocalDate.now();
        if (fechaActual.isAfter(fechaActual)){
            return true;
        }
        return false;
    }
}
