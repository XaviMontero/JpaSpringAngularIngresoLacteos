package com.ucacue.ec.bo.impl;



import com.ucacue.dto.model.ReportesPorUsuarioDTO;
import com.ucacue.ec.bo.GenericTRANSService;
import com.ucacue.ec.persistence.repository.BaseRepositoryTran;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.ArrayList;
import java.util.List;


@Service
public abstract class GenericTRANSServiceImpl <DOMAIN, DTO> implements GenericTRANSService<DOMAIN, DTO> {

    @Autowired
    private BaseRepositoryTran<DOMAIN, Long> repository;

    @Override
    public void saveOrUpdate(DTO dtoObject) {
        DOMAIN domainObject = mapTo(dtoObject);
        repository.save(domainObject);

    }

    @Override
    public List<DTO> findAll(DTO dtoObject) {
        return null;
    }

    @Override
    public abstract DOMAIN mapTo(DTO domainObject);


    @Override
    public List<DTO> ganaciasDia(int mes) {

        List<DOMAIN> lstObjs = repository.totalDiasLeche(mes);
        List<DTO> recu = new ArrayList<>();

        for (DOMAIN maper : lstObjs){
        recu.add(build(maper));

        }
        return  recu;

    }

    @Override
    public List<Double> sumaIngreso(int mes) {
        return repository.sumaDIas(mes);
    }

    @Override
    public List<ReportesPorUsuarioDTO> getSumaDias(int mes) {

        List<Object[]> objects= repository.getSumaDias(mes);
        List<ReportesPorUsuarioDTO> reporte = new ArrayList<>();
        for (Object o[]:objects){
            ReportesPorUsuarioDTO as = new ReportesPorUsuarioDTO();
            as.setCantidad((Double) o[0]);
            as.setNombres((String) o[1]+" "+ o[2]);
            reporte.add(as);

        }
        return reporte ;
    }
}
