package com.ucacue.ec.bo.impl;

import com.ucacue.dto.model.TransaccionDTO;
import com.ucacue.dto.model.UsersDTO;
import com.ucacue.ec.bo.GenericCRUDService;
import com.ucacue.ec.bo.GenericTRANSService;
import com.ucacue.ec.bo.validations.FechaValidar;
import com.ucacue.ec.persistence.entity.Transaccion;
import com.ucacue.ec.persistence.entity.Users;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;



@Service("transaccionServiceImpl")
public class TransaccionServiceImpl extends  GenericTRANSServiceImpl <Transaccion, TransaccionDTO> {
    @Qualifier("userServiceImpl")
    @Autowired
    private GenericCRUDService<Users, UsersDTO> userService;


    @Override
    public Transaccion mapTo(TransaccionDTO transaccionDTO) {
        Transaccion transMapper = new Transaccion();
        transMapper.setAnio(FechaValidar.obtenerAnio(FechaValidar.getFechaActual()));
        transMapper.setDia(FechaValidar.obtenerDia(FechaValidar.getFechaActual()));
        transMapper.setMes(FechaValidar.obtenerMes(FechaValidar.getFechaActual()));
        transMapper.setCantidadIngreso(transaccionDTO.getCantidadIngreso());
        transMapper.setEstadoPago(0);
        transMapper.setFechaIngreso(FechaValidar.getFechaActual());
        transMapper.setUsers(userService.getfindObject(transaccionDTO.getUsersDTO().getNombreUsuario()));
        return transMapper;
    }

    @Override
    public TransaccionDTO build(Transaccion transaccionDTO) {

        TransaccionDTO transMapper = new TransaccionDTO();
        transMapper.setAnio(transaccionDTO.getAnio());
        transMapper.setDia(transaccionDTO.getDia());
        transMapper.setMes(transaccionDTO.getMes());
        transMapper.setCantidadIngreso(transaccionDTO.getCantidadIngreso());
        transMapper.setEstadoPago(transaccionDTO.getEstadoPago());
        transMapper.setFechaIngreso(transaccionDTO.getFechaIngreso());
        transMapper.setUsersDTO(userService.build(transaccionDTO.getUsers()));


        return transMapper;
    }


}
