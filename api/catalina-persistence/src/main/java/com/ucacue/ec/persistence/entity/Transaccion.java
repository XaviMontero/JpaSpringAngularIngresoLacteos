package com.ucacue.ec.persistence.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.Date;

@Getter
@Setter
@Entity
@Table(name = "transaccion")
public class Transaccion {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "digital_tran_generator")
    @SequenceGenerator(name = "digital_tran_generator", sequenceName = "digital_tran_id", allocationSize = 2)
    @Column(name = "digital_tran_id", updatable = false, nullable = false)
    private long id;
    @Column
    private Date fechaIngreso;
    @Column
    private double cantidadIngreso;
    @Column
    private int estadoPago;
    @Column
    private int mes;
    @Column
    private int dia;
    @Column
    private  int anio;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "digital_user_id", referencedColumnName = "digital_user_id")
    private Users users;


}
