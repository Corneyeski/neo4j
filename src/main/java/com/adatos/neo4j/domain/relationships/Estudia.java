package com.adatos.neo4j.domain.relationships;

import com.adatos.neo4j.domain.Alumno;
import com.adatos.neo4j.domain.Curso;
import org.neo4j.ogm.annotation.EndNode;
import org.neo4j.ogm.annotation.GraphId;
import org.neo4j.ogm.annotation.RelationshipEntity;
import org.neo4j.ogm.annotation.StartNode;

@RelationshipEntity(type = "ESTUDIA")
public class Estudia {

    @GraphId
    private Long id;

    @StartNode
    Alumno alumno;

    @EndNode
    Curso curso;

    String nombre;

    public Estudia() {}

    public Estudia(Alumno alumno, Curso curso, String nombre) {
        this.alumno = alumno;
        this.curso = curso;
        this.nombre = nombre;
    }
}
