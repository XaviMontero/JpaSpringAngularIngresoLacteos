package com.ucacue.ec.bo;

import com.ucacue.dto.model.ReportesPorUsuarioDTO;
import com.ucacue.ec.persistence.entity.ReportGenerate;

import java.util.List;

public interface GenericTRANSService<DOMAIN, DTO>  {

    public void saveOrUpdate(DTO dtoObject);

    public List<DTO> findAll(DTO dtoObject);

    /**
     * Allows to map a serializable object to a domain object
     * @param dtoObject
     * @return
     */
    public DOMAIN mapTo(DTO dtoObject);

    /**
     * Allows to serialize a domain object
     * @param domainObject
     * @return
     */
    public DTO build(DOMAIN domainObject);

    public List<DTO> ganaciasDia(int mes );

    List<Double> sumaIngreso(int mes );

    List<ReportesPorUsuarioDTO> getSumaDias(int mes );

}
