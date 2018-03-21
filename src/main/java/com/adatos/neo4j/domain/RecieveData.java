package com.adatos.neo4j.domain;

import java.util.List;

public class RecieveData {

    private String nombre;
    private String especialidad;
    private int edad;
    private List<Long> profesores;
    private List<Long> alumnos;
    private List<Long> cursos;
    private Long profesor;
    private Long alumno;
    private Long curso;

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getEspecialidad() {
        return especialidad;
    }

    public void setEspecialidad(String especialidad) {
        this.especialidad = especialidad;
    }

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    public List<Long> getProfesores() {
        return profesores;
    }

    public void setProfesores(List<Long> profesores) {
        this.profesores = profesores;
    }

    public List<Long> getAlumnos() {
        return alumnos;
    }

    public void setAlumnos(List<Long> alumnos) {
        this.alumnos = alumnos;
    }

    public List<Long> getCursos() {
        return cursos;
    }

    public void setCursos(List<Long> cursos) {
        this.cursos = cursos;
    }

    public Long getProfesor() {
        return profesor;
    }

    public void setProfesor(Long profesor) {
        this.profesor = profesor;
    }

    public Long getAlumno() {
        return alumno;
    }

    public void setAlumno(Long alumno) {
        this.alumno = alumno;
    }

    public Long getCurso() {
        return curso;
    }

    public void setCurso(Long curso) {
        this.curso = curso;
    }
}
