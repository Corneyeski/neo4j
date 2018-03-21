package com.adatos.neo4j.controller;

import com.adatos.neo4j.domain.Alumno;
import com.adatos.neo4j.domain.Curso;
import com.adatos.neo4j.domain.Profesor;
import com.adatos.neo4j.domain.RecieveData;
import com.adatos.neo4j.repositories.AlumnoRepository;
import com.adatos.neo4j.repositories.CursoRepository;
import com.adatos.neo4j.repositories.ProfesorRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController("/")
public class TestController {

    @Autowired
    CursoRepository cursoRepository;

    @Autowired
    ProfesorRepository profesorRepository;

    @Autowired
    AlumnoRepository alumnoRepository;

    @RequestMapping("/test")
    public String test(){
        return "funsiona";
    }

    @RequestMapping("/altaTest")
    public void altaTest(){

        Curso curso = new Curso();
        curso.setNombre("CursoTest");

        System.out.println(cursoRepository.save(curso).getId());

        Iterable<Curso> cursos = cursoRepository.findAll();

        cursos.forEach(c -> System.out.println(c.getNombre()));
    }

    @RequestMapping(value = "/altaprofesor" , method = RequestMethod.PUT)
    public Long altaProfessor(@RequestBody RecieveData recieveData){

        Profesor profesor = new Profesor();
        BeanUtils.copyProperties(recieveData, profesor);

        return profesorRepository.save(profesor).getId();

    }

    @RequestMapping(value = "/altacurso" , method = RequestMethod.PUT)
    public Long altaCurso(@RequestBody Curso curso){

        return cursoRepository.save(curso).getId();
    }

    @RequestMapping(value = "/altaalumno" , method = RequestMethod.PUT)
    public Long altaAlumno(@RequestBody Alumno alumno){

        return alumnoRepository.save(alumno).getId();
    }

    @RequestMapping(value = "/altaalumno" , method = RequestMethod.POST)
    public boolean setCursoToProfesor(@RequestBody RecieveData recieveData){

        if (recieveData.getCurso() != null &&
                cursoRepository.findOne(recieveData.getCurso()) != null)
            return false;

        Profesor profesor = new Profesor();
        BeanUtils.copyProperties(recieveData, profesor);

        profesorRepository.save(profesor);

        return true;
    }
}
