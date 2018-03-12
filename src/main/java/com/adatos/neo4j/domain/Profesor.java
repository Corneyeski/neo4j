package com.adatos.neo4j.domain;

import org.neo4j.ogm.annotation.Relationship;

import java.util.HashSet;
import java.util.Set;

public class Profesor {

        String nombre;
        int edad;
        @Relationship(type = "ENSENA")
        Set<Curso> cursos;

    public Profesor() {}

    public Profesor(String nombre, int edad, Set<Curso> cursos) {
        this.nombre = nombre;
        this.edad = edad;
        this.cursos = cursos;
    }
}
