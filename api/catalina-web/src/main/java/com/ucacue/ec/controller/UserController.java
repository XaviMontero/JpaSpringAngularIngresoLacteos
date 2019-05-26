package com.ucacue.ec.controller;


import com.ucacue.dto.model.PersonaDTO;
import com.ucacue.dto.model.UsersDTO;
import com.ucacue.dto.response.CatalinaResponseDTO;
import com.ucacue.ec.bo.GenericCRUDService;
import com.ucacue.ec.bo.validations.CedulaValidar;
import com.ucacue.ec.persistence.entity.Persona;
import com.ucacue.ec.persistence.entity.Users;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;


@RestController
@RequestMapping(value = "/api/v1.0/user")
@CrossOrigin(origins = "http://localhost:4200")
@Api(description = "Crear Un usuario en linea ")
public class UserController {
    public static final String API_DOC_ANEXO_1 = "Ver ficha técnica - Anexo 1";
    @Qualifier("userServiceImpl")
    @Autowired
    private GenericCRUDService<Users, UsersDTO> userService;
    @Qualifier("personaServiceImpl")
    @Autowired
    private GenericCRUDService<Persona, PersonaDTO> personaService;
    @Autowired
    private CedulaValidar cedulaValidar;

    @ApiOperation(value = "Almacena un usuario en base de datos ")
    @PostMapping(value = "create-user", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Object> insertDigitalCert(
            @Valid @ApiParam(value = API_DOC_ANEXO_1, required = true) @RequestBody UsersDTO userDTO) {
        CatalinaResponseDTO response = new CatalinaResponseDTO();
        if(cedulaValidar.validadorDeCedula(userDTO.getPersonaDTO().getCedulaPersona())){
            if(personaService.getfindObject(userDTO.getPersonaDTO().getCedulaPersona())==null){
                 if(userService.getfindObject(userDTO.getNombreUsuario())==null){
                personaService.saveOrUpdate(userDTO.getPersonaDTO());
                userService.saveOrUpdate(userDTO);
                response.setSuccess(true);
                return new ResponseEntity<>(response, HttpStatus.CREATED);
            }else {
                response.setSuccess(false);
                return new ResponseEntity<>(response, HttpStatus.CONFLICT);
            }
            }else {
                response.setSuccess(false);
                return new ResponseEntity<>(response, HttpStatus.CONFLICT);
            }

            }else {
                response.setSuccess(false);
                return new ResponseEntity<>(response, HttpStatus.CONFLICT);
            }
    }


    @ApiOperation(value = "Retorna un usuari de la base de datos ")
    @GetMapping(value = "{nameUser}/busca", produces = { MediaType.APPLICATION_JSON_VALUE,
            MediaType.APPLICATION_JSON_VALUE })
    public ResponseEntity<Object> getUser(
            @Valid @ApiParam(value = "Nombre de usuario", required = true) @PathVariable("nameUser") String nameUser) {
        HttpHeaders headers = new HttpHeaders();
        headers.add(HttpHeaders.CONTENT_TYPE, "application/json; charset=UTF-8");
        return (new ResponseEntity<Object>(userService.getfindObject(nameUser), headers, HttpStatus.OK));
    }

    @ApiOperation(value = "Retorna una persona de la base de datos ")
    @GetMapping(value = "{cedula}/busca-persona", produces = { MediaType.APPLICATION_JSON_VALUE,
            MediaType.APPLICATION_JSON_VALUE })
    public ResponseEntity<Object> getPersona(
            @Valid @ApiParam(value = "Cedula de verificacion", required = true) @PathVariable("cedula") String cedula) {
        HttpHeaders headers = new HttpHeaders();
        headers.add(HttpHeaders.CONTENT_TYPE, "application/json; charset=UTF-8");
        return (new ResponseEntity<Object>(personaService.getfindObject(cedula), headers, HttpStatus.OK));
    }

    @ApiOperation(value = "Ingreso al sistema con su login ")
    @PostMapping(value = "{user}+{password}/login", produces = { MediaType.APPLICATION_JSON_VALUE,
            MediaType.APPLICATION_JSON_VALUE })
    public ResponseEntity<Object> getLogin(
            @Valid @ApiParam(value = "Ingreso de usuario", required = true) @PathVariable("user") String user,@PathVariable("password")String password) {
        CatalinaResponseDTO response = new CatalinaResponseDTO();
        HttpHeaders headers = new HttpHeaders();
        headers.add(HttpHeaders.CONTENT_TYPE, "application/json; charset=UTF-8");

            if (userService.login(user,password)!=null){
                response.setSuccess(true);
                return (new ResponseEntity<Object>(response, headers, HttpStatus.OK));
            }else {
                response.setSuccess(false);
                return (new ResponseEntity<Object>(response, headers, HttpStatus.OK));
            }
    }

    @ApiOperation(value = "Retorna un usuario completo para su transaccion ")
    @GetMapping(value = "{cedula}/buscar-user", produces = { MediaType.APPLICATION_JSON_VALUE,
            MediaType.APPLICATION_JSON_VALUE })
    public ResponseEntity<Object> getUserDTO(
            @Valid @ApiParam(value = "Cedula de verificacion", required = true) @PathVariable("cedula") String cedula) {
        HttpHeaders headers = new HttpHeaders();
        headers.add(HttpHeaders.CONTENT_TYPE, "application/json; charset=UTF-8");
        return (new ResponseEntity<Object>(userService.findTrans(cedula), headers, HttpStatus.OK));
    }
}
