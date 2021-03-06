package com.adatos.neo4j.repositories;

import com.adatos.neo4j.domain.Curso;
import org.springframework.data.neo4j.repository.Neo4jRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.stereotype.Service;

@Service
@RepositoryRestResource(collectionResourceRel = "clases", path = "clases")
public interface CursoRepository extends Neo4jRepository<Curso, Long> {

}
