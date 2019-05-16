package com.ucacue.dto.model;

import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
public class TransaccionDTO {


    private Date fechaIngreso;
    private double cantidadIngreso;
    private int estadoPago;
    private int mes;
    private int dia;
    private  int anio;
    private UsersDTO users;
}
