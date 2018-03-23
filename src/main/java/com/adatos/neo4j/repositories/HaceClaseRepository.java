package com.adatos.neo4j.repositories;

import com.adatos.neo4j.domain.relationships.HaceClase;
import org.springframework.data.neo4j.repository.Neo4jRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.stereotype.Service;

@Service
@RepositoryRestResource(collectionResourceRel = "haceclase", path = "haceclase")
public interface HaceClaseRepository extends Neo4jRepository<HaceClase, Long> {

}
