package com.ucacue.ec.controller;

import com.ucacue.dto.model.TransaccionDTO;
import com.ucacue.dto.model.UsersDTO;
import com.ucacue.ec.bo.GenericTRANSService;
import com.ucacue.ec.bo.validations.CedulaValidar;
import com.ucacue.ec.persistence.entity.Transaccion;
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
@RequestMapping(value = "/api/v1.0/transaccion")
@CrossOrigin(origins = "http://192.168.1.138:4200")
@Api(description = "Generar Reportes transacciones ")
public class TransaccionController {
    public static final String API_DOC_ANEXO_1 = "Ver ficha técnica - Anexo 1";
    @Qualifier("transaccionServiceImpl")
    @Autowired
    private GenericTRANSService<Transaccion, TransaccionDTO> transService;


    @ApiOperation(value = "Almacena un usuario en base de datos ")
    @GetMapping(value = "{mes}/total-ingreso", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Object> reporteMes(
            @Valid @ApiParam(value = API_DOC_ANEXO_1, required = true) @PathVariable("mes") int mes
    ){
        HttpHeaders headers = new HttpHeaders();
        headers.add(HttpHeaders.CONTENT_TYPE, "application/json; charset=UTF-8");
        return (new ResponseEntity<Object>(transService.ganaciasDia(mes), headers, HttpStatus.OK));
        }


    @ApiOperation(value = "Almacena un usuario en base de datos ")
    @GetMapping(value = "{mes}/total-dia", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Object> reporteDia(
            @Valid @ApiParam(value = API_DOC_ANEXO_1, required = true) @PathVariable("mes") int mes
    ){
        HttpHeaders headers = new HttpHeaders();
        headers.add(HttpHeaders.CONTENT_TYPE, "application/json; charset=UTF-8");
        return (new ResponseEntity<Object>(transService.sumaIngreso(mes), headers, HttpStatus.OK));
    }


    @ApiOperation(value = "Almacena un usuario en base de datos ")
    @GetMapping(value = "{mes}/total-objeto", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Object> reporteDiaObjeto(
            @Valid @ApiParam(value = API_DOC_ANEXO_1, required = true) @PathVariable("mes") int mes
    ){
        HttpHeaders headers = new HttpHeaders();
        headers.add(HttpHeaders.CONTENT_TYPE, "application/json; charset=UTF-8");
        return (new ResponseEntity<Object>(transService.getSumaDias(mes), headers, HttpStatus.OK));
    }
}
