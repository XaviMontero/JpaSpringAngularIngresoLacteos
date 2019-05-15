package com.ucacue.ec.bo.impl;

import com.ucacue.dto.model.PersonaDTO;
import com.ucacue.ec.persistence.entity.Persona;
import org.springframework.stereotype.Service;

@Service("personaServiceImpl")
public class PersonaServiceImpl extends  GenericCRUDServiceImpl<Persona, PersonaDTO>{


    @Override
    public Persona mapTo(PersonaDTO userDTO) {
        Persona p = new Persona();
        p.setCedulaPersona(userDTO.getCedulaPersona());
        p.setNombrePersona(userDTO.getNombrePersona());
        p.setApellidosPersona(userDTO.getApellidosPersona());
        p.setTelefonoPersona(userDTO.getTelefonoPersona());
        p.setDireccion(userDTO.getDireccion());
        p.setEmailPersona(userDTO.getEmailPersona());
        return p;
    }

    @Override
    public PersonaDTO build(Persona userDTO) {
        PersonaDTO p = new PersonaDTO();
        p.setCedulaPersona(userDTO.getCedulaPersona());
        p.setNombrePersona(userDTO.getNombrePersona());
        p.setApellidosPersona(userDTO.getApellidosPersona());
        p.setTelefonoPersona(userDTO.getTelefonoPersona());
        p.setDireccion(userDTO.getDireccion());
        p.setEmailPersona(userDTO.getEmailPersona());
        return p;
    }
}
