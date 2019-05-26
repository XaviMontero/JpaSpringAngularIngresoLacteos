package com.ucacue.ec.persistence.repository;

import com.ucacue.ec.persistence.entity.Persona;
import com.ucacue.ec.persistence.entity.Users;

import org.springframework.data.jpa.repository.Query;

public interface PersonaRepository extends BaseRepository<Persona, Long> {
    @Override
    @Query(" from Persona i where i.cedulaPersona = ?1  ")
    Persona findObject(String name);

    @Override
    @Query(" from Persona i where i.cedulaPersona = ?1  ")
    Persona findLogin(String user, String password);

    @Override
    @Query(" from Persona i where i.cedulaPersona = ?1  ")
    Persona findTran(String cedula);
}
