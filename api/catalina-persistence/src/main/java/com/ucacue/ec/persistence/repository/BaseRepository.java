package com.ucacue.ec.persistence.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.NoRepositoryBean;

import java.io.Serializable;

@NoRepositoryBean
public interface BaseRepository<T, ID extends Serializable> extends JpaRepository<T, ID> {

	public T findObject(String name);
	public T findLogin(String user,String password);

	public T findTran(String cedula);
}