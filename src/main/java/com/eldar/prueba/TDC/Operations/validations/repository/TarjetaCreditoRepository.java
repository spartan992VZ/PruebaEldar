package com.eldar.prueba.TDC.Operations.validations.repository;

import com.eldar.prueba.TDC.Operations.validations.modelos.TarjetaCredito;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface TarjetaCreditoRepository extends JpaRepository<TarjetaCredito, String> {

}
