package com.ucacue.dto.model;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UsersDTO {

    private String nombreUsuario;
    private String email;
    private String password;
    private PersonaDTO personaDTO;
}
