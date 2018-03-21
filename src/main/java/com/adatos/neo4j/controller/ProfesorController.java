package com.adatos.neo4j.controller;

import com.adatos.neo4j.domain.Profesor;
import com.adatos.neo4j.domain.RecieveData;
import com.adatos.neo4j.repositories.ProfesorRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

//@Controller("/p")
public class ProfesorController {

    @Autowired
    ProfesorRepository profesorRepository;


    @RequestMapping(value = "/alta" , method = RequestMethod.PUT)
    public Long altaProfessor(@RequestBody RecieveData recieveData){

        Profesor profesor = new Profesor();
        BeanUtils.copyProperties(recieveData, profesor);

        return profesorRepository.save(profesor).getId();

    }
    @RequestMapping(value = "/find/{id}" , method = RequestMethod.GET)
    public Profesor findProfesorById(@PathVariable long id){

        return profesorRepository.findOne(id);
    }
}
