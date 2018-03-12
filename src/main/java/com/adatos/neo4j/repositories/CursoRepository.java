package com.adatos.neo4j.repositories;

import com.adatos.neo4j.domain.Curso;
import org.springframework.data.neo4j.repository.Neo4jRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource(collectionResourceRel = "movies", path = "movies")
public interface CursoRepository extends Neo4jRepository<Curso, Long> {


}
