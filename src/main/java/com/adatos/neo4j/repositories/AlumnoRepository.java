package com.adatos.neo4j.repositories;

import com.adatos.neo4j.domain.Alumno;
import org.springframework.data.neo4j.repository.Neo4jRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.stereotype.Service;

@Service
@RepositoryRestResource(collectionResourceRel = "alumnos", path = "alumnos")
public interface AlumnoRepository extends Neo4jRepository<Alumno,Long> {

}
