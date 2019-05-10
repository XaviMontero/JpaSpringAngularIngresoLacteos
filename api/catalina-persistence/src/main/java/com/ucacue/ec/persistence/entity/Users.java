package com.ucacue.ec.persistence.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Getter
@Setter
@Entity
@Table(name = "users")
public class Users {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "digital_user_generator")
    @SequenceGenerator(name = "digital_user_generator", sequenceName = "digital_user_seq", allocationSize = 50)
    @Column(name = "digital_user_id", updatable = false, nullable = false)
    private long id;
    @Column
    private String nombreUsuario;
    @Column
    private String email;
    @Column
    private String passwords;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "cedula_persona", referencedColumnName = "cedula_persona")
    private Persona persona;


}
