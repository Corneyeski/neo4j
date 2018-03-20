package com.adatos.neo4j.repositories;

import com.adatos.neo4j.domain.Profesor;
import org.springframework.data.neo4j.repository.Neo4jRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.stereotype.Service;

@Service
@RepositoryRestResource(collectionResourceRel = "profesores", path = "profesores")
public interface ProfesorRepository extends Neo4jRepository<Profesor, Long> {

}
