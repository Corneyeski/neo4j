package com.adatos.neo4j.controller;

import com.adatos.neo4j.domain.Alumno;
import com.adatos.neo4j.domain.Curso;
import com.adatos.neo4j.domain.Profesor;
import com.adatos.neo4j.domain.RecieveData;
import com.adatos.neo4j.domain.relationships.Estudia;
import com.adatos.neo4j.domain.relationships.HaceClase;
import com.adatos.neo4j.repositories.*;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController("/")
public class TestController {

    @Autowired
    CursoRepository cursoRepository;

    @Autowired
    ProfesorRepository profesorRepository;

    @Autowired
    AlumnoRepository alumnoRepository;

    @Autowired
    HaceClaseRepository haceClaseRepository;

    @Autowired
    EstudiaRepository estudiaRepository;

    @RequestMapping("/test")
    public String test() {
        return "funsiona";
    }

    @RequestMapping("/altaTest")
    public void altaTest() {

        Curso curso = new Curso();
        curso.setNombre("CursoTest");

        System.out.println(cursoRepository.save(curso).getId());

        Iterable<Curso> cursos = cursoRepository.findAll();

        cursos.forEach(c -> System.out.println(c.getNombre()));
    }

    @RequestMapping(value = "/alta/profesor", method = RequestMethod.PUT)
    public Long altaProfessor(@RequestBody RecieveData recieveData) {

        Profesor profesor = new Profesor();
        BeanUtils.copyProperties(recieveData, profesor);

        return profesorRepository.save(profesor).getId();

    }

    @RequestMapping(value = "/alta/curso", method = RequestMethod.PUT)
    public Long altaCurso(@RequestBody Curso curso) {

        return cursoRepository.save(curso).getId();
    }

    @RequestMapping(value = "/alta/alumno", method = RequestMethod.PUT)
    public Long altaAlumno(@RequestBody Alumno alumno) {

        return alumnoRepository.save(alumno).getId();
    }

    @RequestMapping(value = "/setcursoprofesor", method = RequestMethod.POST)
    public boolean setCursoToProfesor(@RequestBody RecieveData recieveData) {

        if (recieveData.getCurso() != null &&
                recieveData.getProfesor() != null) {

            Curso curso = cursoRepository.findOne(recieveData.getCurso());
            Profesor profesor = profesorRepository.findOne(recieveData.getProfesor());

            if (curso != null && profesor != null) {
                HaceClase result = haceClaseRepository.save(new HaceClase(profesor, curso, "java"));

                System.out.println(result);

                return true;
            } else return false;
        }
        return false;
    }

    @RequestMapping(value = "/setcursoalumno", method = RequestMethod.POST)
    public boolean setCursoToAlumno(@RequestBody RecieveData recieveData) {

        if (recieveData.getCurso() != null &&
                recieveData.getAlumno() != null) {

            Curso curso = cursoRepository.findOne(recieveData.getCurso());
            Alumno alumno = alumnoRepository.findOne(recieveData.getAlumno());

            if (curso != null && alumno != null) {
                Estudia result = estudiaRepository.save(new Estudia(alumno, curso, "java"));

                System.out.println(result);

                return true;
            } else return false;
        }
        return false;
    }

    @RequestMapping(value = "/find/profesor/{id}", method = RequestMethod.GET)
    public Profesor findProfesorById(@PathVariable long id) {

        return profesorRepository.findOne(id);
    }

    @RequestMapping(value = "/find/curso/{id}", method = RequestMethod.GET)
    public Curso findCursoById(@PathVariable long id) {

        return cursoRepository.findOne(id);
    }

    @RequestMapping(value = "/find/alumno/{id}", method = RequestMethod.GET)
    public Alumno findAlumnoById(@PathVariable long id) {

        return alumnoRepository.findOne(id);
    }

    @RequestMapping(value = "/delete/profesor/{id}", method = RequestMethod.GET)
    public boolean deleteProfesorById(@PathVariable long id) {

        if (profesorRepository.exists(id))
            profesorRepository.delete(id);
        else return false;

        return true;
    }

    @RequestMapping(value = "/delete/curso/{id}", method = RequestMethod.GET)
    public boolean deleteCursoById(@PathVariable long id) {

        if (cursoRepository.exists(id))
            cursoRepository.delete(id);
        else return false;

        return true;
    }

    @RequestMapping(value = "/delete/alumno/{id}", method = RequestMethod.GET)
    public boolean deleteAlumnoById(@PathVariable long id) {

        if (alumnoRepository.exists(id))
            alumnoRepository.delete(id);
        else return false;

        return true;
    }

    @RequestMapping(value = "/update/profesor", method = RequestMethod.POST)
    public Profesor updateProfesorById(@RequestBody Profesor profesor) {

        if(profesor.getId() != null)
            return profesorRepository.save(profesor);
        else return new Profesor();
    }

    @RequestMapping(value = "/update/curso", method = RequestMethod.POST)
    public Curso updateCursoById(@RequestBody Curso curso) {

        if(curso.getId() != null)
            return cursoRepository.save(curso);
        else return new Curso();
    }

    @RequestMapping(value = "/update/alumno", method = RequestMethod.POST)
    public Alumno updateAlumnoById(@RequestBody Alumno alumno) {

        if(alumno.getId() != null)
            return alumnoRepository.save(alumno);
        else return new Alumno();
    }
}
