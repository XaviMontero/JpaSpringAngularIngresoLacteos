package com.ucacue.ec.persistence.repository;

import com.ucacue.ec.persistence.entity.Users;
import org.springframework.data.jpa.repository.Query;


public interface UserRepository extends BaseRepository<Users, Long> {
    @Override
    @Query(" from Users i where i.nombreUsuario = ?1  ")
    Users findObject(String name);
}
