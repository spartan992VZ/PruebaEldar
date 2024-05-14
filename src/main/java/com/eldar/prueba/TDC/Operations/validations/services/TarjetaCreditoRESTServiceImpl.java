package com.eldar.prueba.TDC.Operations.validations.services;

import com.eldar.prueba.TDC.Operations.validations.controller.TarjetaController;
import com.eldar.prueba.TDC.Operations.validations.dto.TarjetaDTO;
import com.eldar.prueba.TDC.Operations.validations.dto.reponse.ListaTarjetaRespose;
import com.eldar.prueba.TDC.Operations.validations.dto.reponse.TarjetaResponse;
import com.eldar.prueba.TDC.Operations.validations.dto.request.TarjetaRequest;
import com.eldar.prueba.TDC.Operations.validations.exceptions.TarjetaInvalidaException;
import com.eldar.prueba.TDC.Operations.validations.exceptions.TarjetaNotFoundException;
import com.eldar.prueba.TDC.Operations.validations.mapper.TarjetaMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.persistence.PersistenceException;
import java.util.List;

@RestController
@RequestMapping("/tarjeta")
public class TarjetaCreditoRESTServiceImpl implements TarjetaCreditoRESTService{

    @Autowired
    private TarjetaController tarjetaController;

    private TarjetaMapper mapper = TarjetaMapper.INSTANCE;

    @GetMapping("/{number}")
    public ResponseEntity<TarjetaResponse> obtenerTarjeta(@PathVariable String number) {
        try {
            TarjetaDTO tarjeta = tarjetaController.obtenerTarjeta(number);

            TarjetaResponse response = mapper.toResponse(tarjeta);
            return ResponseEntity.ok(response);
        } catch (TarjetaNotFoundException e) {
            String mensajeError = e.getMessage();
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(new TarjetaResponse());
        } catch (Exception e) {
            String mensajeError = "Ocurrió un error inesperado al obtener la tarjeta.";
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(new TarjetaResponse());
        }
    }

    @GetMapping("/tarjetas")
    public ResponseEntity<ListaTarjetaRespose> obtenerTodaTarjeta() {
        try {
            List<TarjetaDTO> listaTarjetas = tarjetaController.obtenerTodasLasTarjetas();
            ListaTarjetaRespose response = new ListaTarjetaRespose(listaTarjetas);

            return ResponseEntity.ok(response);
        }catch (DataAccessException e){
            e.getMessage();
            return null;
        }

    }
    @PostMapping("/registrarNuevaTarjeta")
    public ResponseEntity<String> crearTarjeta(@RequestBody TarjetaRequest tarjeta) {
        TarjetaDTO dto = mapper.toDTO(tarjeta);
        try {
            boolean created = tarjetaController.crearNuevaTarjeta(dto);

            return ResponseEntity.ok().body("Se ha registrado la tarjeta correctamente");

        }catch (PersistenceException  e){
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(e.getMessage());
        }
    }

    @Override
    public ResponseEntity<String> validarTarjeta(String number) {

        try {
            TarjetaDTO dto = tarjetaController.validarTarjeta(number);

            return ResponseEntity.ok("La tarjeta: "+number+" es valida para operar");

        }catch (TarjetaInvalidaException e){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Tarjeta invalida");
        }


    }

    @Override
    @PostMapping("/actualizarDatos")
    public ResponseEntity<String> actualizarDatos(@RequestBody TarjetaRequest tarjeta) {
        try {
            TarjetaDTO tarjetaDTO = mapper.toDTO(tarjeta);

            tarjetaController.actualizarDatosTarjeta(tarjetaDTO);

            return ResponseEntity.ok("Datos de la tarjeta actualizados correctamente");
        } catch (TarjetaNotFoundException e){
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(e.getMessage());
        }catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Error al actualizar los datos de la tarjeta");
        }
    }


    @Override
    @DeleteMapping("/eliminarTarjeta/{numero}")
    public ResponseEntity<String> eliminarTarjeta(@PathVariable String numeroTdc) {
        try {
            tarjetaController.eliminarTarjeta(numeroTdc);

            return ResponseEntity.ok("Tarjeta eliminada correctamente");
        } catch (TarjetaNotFoundException e){
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(e.getMessage());
        }
        catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Error al eliminar la tarjeta");
        }
    }



}
