package com.eldar.prueba.TDC.Operations.validations.controller;

import com.eldar.prueba.TDC.Operations.validations.dto.TarjetaDTO;
import com.eldar.prueba.TDC.Operations.validations.mapper.TarjetaMapper;
import com.eldar.prueba.TDC.Operations.validations.modelos.TarjetaCredito;
import com.eldar.prueba.TDC.Operations.validations.repository.TarjetaCreditoDAORepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Controller;

import javax.persistence.PersistenceException;
import java.time.LocalDate;
import java.util.ArrayList;

@Controller
public class TarjetaController {

    @Autowired
    private TarjetaCreditoDAORepository tarjetaCreditoRepository;

    private TarjetaMapper mapper;

    public void crearNuevaTarjeta(TarjetaDTO tarjetaDTO) throws PersistenceException, DataAccessException {
        TarjetaCredito tarjeta = new TarjetaCredito();

        tarjeta = mapper.toEntity(tarjetaDTO);

        tarjetaCreditoRepository.save(tarjeta);
    }

    public ArrayList<TarjetaDTO> obtenerTodasLasTarjetas(){

        return null;
    }
    public TarjetaDTO obtenerTarjeta(String number){
        TarjetaCredito tarjetaOptional = tarjetaCreditoRepository.findByNumberTdc(number);
        if (esVigente(tarjetaOptional)){

        }
        return null;
    }

    private boolean esVigente(TarjetaCredito tarjetaOptional) {
        LocalDate fechaActual = LocalDate.now();
        if (fechaActual.isAfter(fechaActual)){
            return true;
        }
        return false;
    }
}

