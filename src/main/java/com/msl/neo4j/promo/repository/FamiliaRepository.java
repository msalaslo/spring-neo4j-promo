package com.msl.neo4j.promo.repository;

import java.util.Optional;

import org.springframework.data.neo4j.repository.Neo4jRepository;

import com.msl.neo4j.promo.entity.Familia;
import com.msl.neo4j.promo.entity.Promocion;

public interface FamiliaRepository extends Neo4jRepository<Familia,Long> {
	public Optional<Familia> findById(Long id);
	public Iterable<Familia> findByCfamilia(String cfamilia);
	public Iterable<Familia> findByName(String name);
	Iterable<Promocion> findPromocionesById(Long id);
	Iterable<Promocion> findPromocionesByName(String name);
	Iterable<Promocion> findPromocionesByCfamilia(String cfamilia);
}