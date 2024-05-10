package com.eldar.prueba.TDC.Operations.validations.repository;

import com.eldar.prueba.TDC.Operations.validations.modelos.TarjetaCredito;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TarjetaCreditoDAORepository extends JpaRepository<TarjetaCredito, String> {
    TarjetaCredito findByNumberTdc(String NumberTdc);

}
