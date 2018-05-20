package com.msl.neo4j.promo.repository;

import java.util.Optional;

import org.springframework.data.neo4j.repository.Neo4jRepository;

import com.msl.neo4j.promo.entity.Centro;
import com.msl.neo4j.promo.entity.Promocion;

public interface CentroRepository extends Neo4jRepository<Centro,Long> {
	public Optional<Centro> findById(Long id);
	public Iterable<Centro> findByCentroo(String centroo);
	public Iterable<Centro> findByName(String centroo);
	public Iterable<Promocion> findPromocionesByCentroo(String centroo);
	public Iterable<Promocion> findPromocionesById(Long id);
	public Iterable<Promocion> findPromocionesByName(String name);
}