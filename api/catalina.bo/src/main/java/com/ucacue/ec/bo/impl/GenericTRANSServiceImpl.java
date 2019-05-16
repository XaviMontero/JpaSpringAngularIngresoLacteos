package com.ucacue.ec.bo.impl;



import com.ucacue.ec.bo.GenericTRANSService;

import com.ucacue.ec.persistence.repository.BaseRepositoryTran;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;


import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

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
    public List<Object[]> getSumaDias(int mes) {
        return repository.getSumaDias(mes);
    }
}
