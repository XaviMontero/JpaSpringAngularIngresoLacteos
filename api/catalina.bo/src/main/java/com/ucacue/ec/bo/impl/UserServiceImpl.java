package com.ucacue.ec.bo.impl;



import com.ucacue.dto.model.PersonaDTO;
import com.ucacue.dto.model.UsersDTO;
import com.ucacue.ec.bo.GenericCRUDService;
import com.ucacue.ec.persistence.entity.Persona;
import com.ucacue.ec.persistence.entity.Users;
import com.ucacue.ec.persistence.repository.BaseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

@Service("userServiceImpl")
public class UserServiceImpl extends  GenericCRUDServiceImpl<Users, UsersDTO>{
    @Qualifier("personaRepository")
    @Autowired
    private BaseRepository baseRepository;
    @Qualifier("personaServiceImpl")
    @Autowired
    private GenericCRUDService<Persona, PersonaDTO> personaService;
    @Override
    public Users mapTo(UsersDTO userDTO) {
        Users userMapper = new Users();

        userMapper.setNombreUsuario(userDTO.getNombreUsuario());
        userMapper.setEmail(userDTO.getEmail());
        userMapper.setPasswords(userDTO.getPassword());
        userMapper.setNombreUsuario(userDTO.getNombreUsuario());
        userMapper.setPersona((Persona) baseRepository.findObject(userDTO.getPersonaDTO().getCedulaPersona()));
        return userMapper;
    }

    @Override
    public UsersDTO build(Users userDTO) {
        UsersDTO userMapper = new UsersDTO();

        userMapper.setNombreUsuario(userDTO.getNombreUsuario());
        userMapper.setEmail(userDTO.getEmail());
        userMapper.setPassword(userDTO.getPasswords());
        userMapper.setNombreUsuario(userDTO.getNombreUsuario());
        userMapper.setPersonaDTO(  personaService.build(userDTO.getPersona()));

        return userMapper;
    }



}
