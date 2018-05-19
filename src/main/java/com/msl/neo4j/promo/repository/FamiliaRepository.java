package com.msl.neo4j.promo.repository;

import java.util.List;

import org.springframework.data.neo4j.repository.Neo4jRepository;

import com.msl.neo4j.promo.entity.Familia;
import com.msl.neo4j.promo.entity.Promocion;

public interface FamiliaRepository extends Neo4jRepository<Familia,Long> {
	public List<Familia> findByCfamilia(String cfamilia);
	List<Promocion> findPromocionesByCfamilia(String cfamilia);
}