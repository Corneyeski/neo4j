package com.adatos.neo4j.repositories;

import com.adatos.neo4j.domain.relationships.Estudia;
import org.springframework.data.neo4j.repository.Neo4jRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.stereotype.Service;

@Service
@RepositoryRestResource(collectionResourceRel = "estudia", path = "estudia")
public interface EstudiaRepository extends Neo4jRepository<Estudia, Long> {
}
