package com.adatos.neo4j.controller;

import com.adatos.neo4j.domain.Curso;
import com.adatos.neo4j.domain.RecieveData;
import com.adatos.neo4j.repositories.CursoRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

//@RestController("/")
public class CursoController {

    @Autowired
    CursoRepository cursoRepository;

    @RequestMapping(value = "/curso" , method = RequestMethod.PUT)
    public Long altaCurso(@RequestBody RecieveData recieveData){

        Curso curso = new Curso();
        BeanUtils.copyProperties(recieveData, curso);

        return cursoRepository.save(curso).getId();
    }

    @RequestMapping(value = "/curso/{id}" , method = RequestMethod.GET)
    public Curso findCursoById(@PathVariable long id){

        return cursoRepository.findOne(id);
    }
}
