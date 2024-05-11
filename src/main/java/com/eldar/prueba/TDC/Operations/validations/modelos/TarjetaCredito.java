package com.eldar.prueba.TDC.Operations.validations.modelos;

import lombok.*;

import javax.persistence.*;
import java.time.LocalDate;

@Getter
@Setter
@Entity
@Table (name = "tarjeta_credito")
public class TarjetaCredito {
    @Id
    @Column(name = "numero_tdc")
    private String numeroTdc;
    @Column(name = "marca")
    private String marca;
    @Column(name = "cardholder")
    private String cardholder;
    @Column(name ="fecha_vencimiento")
    private LocalDate fechaVencimiento;
}