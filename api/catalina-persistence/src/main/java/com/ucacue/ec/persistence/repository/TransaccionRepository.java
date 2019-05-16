package com.ucacue.ec.persistence.repository;


import com.ucacue.ec.persistence.entity.ReportGenerate;
import com.ucacue.ec.persistence.entity.Transaccion;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository("transaccionRepository")
public interface TransaccionRepository extends  BaseRepositoryTran<Transaccion, Long>{

    @Override
    @Query( " from Transaccion where  mes=?1 " )
    List<Transaccion> totalDiasLeche( int mes);

    @Override
    @Query(value = "select  SUM(cantidad_ingreso)as total from Transaccion where  mes=?1 group by  digital_user_id ",nativeQuery = true)
    List<Double> sumaDIas(int id) throws NullPointerException;

    @Override
    @Query(value = " select  SUM(T.cantidad_ingreso)as cantidad, P.nombre_persona as nombre ,P.apellidos_persona as apellido from Transaccion T  inner join users U on U.digital_user_id=T.digital_user_id  inner join persona P on U.cedula_persona=P.cedula_persona where  mes=?1  group by  P.nombre_persona,P.apellidos_persona",nativeQuery = true)
    List<Object[]> getSumaDias(int mes);
}
