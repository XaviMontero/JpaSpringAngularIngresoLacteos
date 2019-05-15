package com.ucacue.ec.persistence.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

public interface BaseRepositoryTran <T, ID extends Serializable> extends JpaRepository<T, ID> {

    List<T> totalDiasLeche(int diaInicio,int diaFinal,int mesInicio);
    List<T> totalMesesLeche(int mesInicio,int mesFinal);
    List<T> totalAnioLeche( int anioFin);
    List<T> totaldeudaLeche(boolean estado);
    List<T> topMejoresClientes(boolean estado);


}
