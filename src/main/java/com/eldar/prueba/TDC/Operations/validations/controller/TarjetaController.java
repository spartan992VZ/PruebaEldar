package com.eldar.prueba.TDC.Operations.validations.controller;

import com.eldar.prueba.TDC.Operations.validations.dto.TarjetaDTO;
import com.eldar.prueba.TDC.Operations.validations.dto.request.TarjetaRequest;
import com.eldar.prueba.TDC.Operations.validations.exceptions.TarjetaInvalidaException;
import com.eldar.prueba.TDC.Operations.validations.exceptions.TarjetaNotFoundException;
import com.eldar.prueba.TDC.Operations.validations.mapper.TarjetaMapper;
import com.eldar.prueba.TDC.Operations.validations.modelos.TarjetaCredito;
import com.eldar.prueba.TDC.Operations.validations.repository.TarjetaCreditoDAORepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;

import javax.persistence.PersistenceException;
import java.time.LocalDate;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

@Controller
public class TarjetaController {

    @Autowired
    private TarjetaCreditoDAORepository tarjetaCreditoRepository;

    private TarjetaMapper mapper = TarjetaMapper.INSTANCE;

    public boolean crearNuevaTarjeta(TarjetaDTO tarjetaDTO) throws PersistenceException {
        try {
            TarjetaCredito tarjeta = mapper.toEntity(tarjetaDTO);
            return Objects.nonNull(tarjetaCreditoRepository.save(tarjeta));
        }catch (PersistenceException e){
            throw new PersistenceException();
        }
    }

    public List<TarjetaDTO> obtenerTodasLasTarjetas() throws DataAccessException{

        List<TarjetaCredito> tarjetas = tarjetaCreditoRepository.findAll();

        List<TarjetaDTO> tarjetasDTOs = tarjetas.stream()
                .map(tarjeta -> {
                    return mapper.toDTO(tarjeta);
                })
                .collect(Collectors.toList());

        return tarjetasDTOs;
    }

    public TarjetaDTO obtenerTarjeta(String number) throws TarjetaNotFoundException {
        TarjetaCredito tarjeta = tarjetaCreditoRepository.findById(number).orElseThrow(() -> new TarjetaNotFoundException(number));

        return mapper.toDTO(tarjeta);
    }

    public TarjetaDTO validarTarjeta(String number) throws TarjetaInvalidaException {
        TarjetaCredito tarjeta = tarjetaCreditoRepository.getById(number);

        if (esVigente(tarjeta)){
            return mapper.toDTO(tarjeta);
        }else{
            throw new TarjetaInvalidaException(tarjeta.getFechaVencimiento());
        }

    }

    public void actualizarDatosTarjeta(TarjetaDTO tarjetaDTO) throws TarjetaNotFoundException {
        TarjetaCredito tarjeta = tarjetaCreditoRepository.findById(tarjetaDTO.getNumeroTdc())
                .orElseThrow(() -> new TarjetaNotFoundException(tarjetaDTO.getNumeroTdc()));

        tarjeta.setCardholder(tarjetaDTO.getCardholder());
        tarjeta.setFechaVencimiento(tarjetaDTO.getFechaVencimiento());
        tarjeta.setMarca(tarjetaDTO.getMarca());

        tarjetaCreditoRepository.save(tarjeta);
    }

    public void eliminarTarjeta(String numero) throws TarjetaNotFoundException {
        TarjetaCredito tarjeta = tarjetaCreditoRepository.findById(numero)
                .orElseThrow(() -> new TarjetaNotFoundException(numero));

        // Eliminar la tarjeta
        tarjetaCreditoRepository.delete(tarjeta);
    }


    private boolean esVigente(TarjetaCredito tarjetaOptional) {
        LocalDate fechaActual = LocalDate.now();
        if (fechaActual.isAfter(fechaActual)){
            return true;
        }
        return false;
    }

    public boolean compararNumerosTarjetas(String numeroTarjeta1, String numeroTarjeta2) throws  TarjetaNotFoundException{
        TarjetaCredito tarjeta1 = tarjetaCreditoRepository.findById(numeroTarjeta1)
                .orElseThrow(() -> new TarjetaNotFoundException(numeroTarjeta1));

        TarjetaCredito tarjeta2 = tarjetaCreditoRepository.findById(numeroTarjeta2)
                .orElseThrow(() -> new TarjetaNotFoundException(numeroTarjeta2));

        return tarjeta1.equals(tarjeta2);
    }
}

