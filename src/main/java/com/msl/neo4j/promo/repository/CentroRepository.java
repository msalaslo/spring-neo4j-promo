package com.msl.neo4j.promo.repository;

import java.util.List;

import org.springframework.data.neo4j.repository.Neo4jRepository;

import com.msl.neo4j.promo.entity.Centro;
import com.msl.neo4j.promo.entity.Promocion;

public interface CentroRepository extends Neo4jRepository<Centro,Long> {
	public List<Centro> findByCentroo(String centroo);
	List<Promocion> findPromocionesByCentroo(String centroo);
}