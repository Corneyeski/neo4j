package com.adatos.neo4j.controller;

import com.adatos.neo4j.domain.Alumno;
import com.adatos.neo4j.domain.RecieveData;
import com.adatos.neo4j.repositories.AlumnoRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

//@Controller("/alu")
public class AlumnoController {

    @Autowired
    AlumnoRepository alumnoRepository;

    @RequestMapping(value = "/alta" , method = RequestMethod.PUT)
    public Long altaAlumno(@RequestBody RecieveData recieveData){

        Alumno alumno = new Alumno();
        BeanUtils.copyProperties(recieveData, alumno);

        return alumnoRepository.save(alumno).getId();
    }

    @RequestMapping(value = "/find/{id}" , method = RequestMethod.GET)
    public Alumno findAlumnoById(@PathVariable long id){

        return alumnoRepository.findOne(id);
    }
}
