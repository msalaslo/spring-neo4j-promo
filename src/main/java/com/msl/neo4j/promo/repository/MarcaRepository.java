package com.msl.neo4j.promo.repository;

import java.util.Optional;

import org.springframework.data.neo4j.repository.Neo4jRepository;

import com.msl.neo4j.promo.entity.Marca;
import com.msl.neo4j.promo.entity.Promocion;

public interface MarcaRepository extends Neo4jRepository<Marca,Long> {
	public Optional<Marca> findById(Long id);
	public Iterable<Marca> findByCmarmuma(String cmarmuma);
	public Iterable<Marca> findByName(String name);
	public Iterable<Promocion> findPromocionesById(Long id);
	public Iterable<Promocion> findPromocionesByName(String name);
	public Iterable<Promocion> findPromocionesByCmarmuma(String cmarmuma);
}