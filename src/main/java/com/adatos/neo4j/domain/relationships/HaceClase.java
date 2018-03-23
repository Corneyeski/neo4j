package com.adatos.neo4j.domain.relationships;

import com.adatos.neo4j.domain.Curso;
import com.adatos.neo4j.domain.Profesor;
import org.neo4j.ogm.annotation.EndNode;
import org.neo4j.ogm.annotation.GraphId;
import org.neo4j.ogm.annotation.RelationshipEntity;
import org.neo4j.ogm.annotation.StartNode;

@RelationshipEntity(type = "ENSENA")
public class HaceClase {

    @GraphId
    private Long id;

    @StartNode
    Profesor profesor;

    @EndNode
    Curso curso;

    String nombre;

    public HaceClase() {}

    public HaceClase(Profesor profesor, Curso curso, String nombre) {
        this.profesor = profesor;
        this.curso = curso;
        this.nombre = nombre;
    }
}
