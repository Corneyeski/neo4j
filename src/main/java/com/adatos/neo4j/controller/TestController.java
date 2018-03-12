package com.adatos.neo4j.controller;

import com.adatos.neo4j.domain.Curso;
import com.adatos.neo4j.repositories.CursoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController("/")
public class TestController {

    @Autowired
    CursoRepository cursoRepository;

    @RequestMapping("/test")
    public String test(){
        return "funsiona";
    }

    @RequestMapping("/altaTest")
    public void altaTest(){

        Curso curso = new Curso();
        curso.setNombre("CursoTest");

        cursoRepository.save(curso);

        Curso cursos = (Curso) cursoRepository.findAll();
    }
}
