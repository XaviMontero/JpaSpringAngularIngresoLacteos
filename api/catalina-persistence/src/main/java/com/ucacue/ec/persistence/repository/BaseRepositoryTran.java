package com.ucacue.ec.persistence.repository;

import com.ucacue.ec.persistence.entity.ReportGenerate;
import com.ucacue.ec.persistence.entity.Transaccion;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.NoRepositoryBean;

import java.io.Serializable;
import java.util.List;
/* List<T> totalMesesLeche(int mesInicio,int mesFinal);
 List<T> totalAnioLeche( int anioFin);
 List<T> totaldeudaLeche(boolean estado);
 List<T> topMejoresClientes(boolean estado);*/

@NoRepositoryBean
public interface BaseRepositoryTran <T, ID extends Serializable> extends JpaRepository<T, ID> {

    List<T> totalDiasLeche(int id);
    List<Double> sumaDIas(int id) throws NullPointerException;
    List<Object[]> getSumaDias(int mes );

}
