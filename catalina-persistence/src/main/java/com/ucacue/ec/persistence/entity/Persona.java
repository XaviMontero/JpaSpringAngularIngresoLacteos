package com.ucacue.ec.persistence.entity;


import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@Entity
@Table(name = "persona")
public class Persona {
    @Id
    @Column(name = "cedula_persona", updatable = false, nullable = false)
    private String cedulaPersona;
    @Column
    private String nombrePersona;
    @Column
    private String apellidosPersona;
    @Column
    private String emailPersona;
    @Column
    private String telefonoPersona;
    @Column
    private String direccion;

    @OneToMany(mappedBy = "persona", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Users> users = new ArrayList<>();


}
