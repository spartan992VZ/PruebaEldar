package com.eldar.prueba.TDC.Operations.validations.modelos;

import lombok.*;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.time.LocalDate;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity

public class TarjetaCredito {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private String numeroTdc;
    private String marca;
    private String cardholder;
    private LocalDate fechaVencimiento;
}