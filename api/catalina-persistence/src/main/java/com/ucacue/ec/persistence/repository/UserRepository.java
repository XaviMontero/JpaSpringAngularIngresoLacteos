package com.ucacue.ec.persistence.repository;

import com.ucacue.ec.persistence.entity.Users;
import org.springframework.data.jpa.repository.Query;


public interface UserRepository extends BaseRepository<Users, Long> {
    @Override
    @Query(" from Users i where i.nombreUsuario = ?1  ")
    Users findObject(String name);

    @Override
    @Query(" from Users i where i.nombreUsuario = ?1 and i.passwords=?2 ")
    Users findLogin(String user, String password);

    @Override
    @Query(" from Users i where i.persona.cedulaPersona= ?1  ")
    Users findTran(String cedula);
}
