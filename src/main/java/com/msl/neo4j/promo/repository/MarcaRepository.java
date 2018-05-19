package com.msl.neo4j.promo.repository;

import java.util.List;

import org.springframework.data.neo4j.repository.Neo4jRepository;

import com.msl.neo4j.promo.entity.Marca;
import com.msl.neo4j.promo.entity.Promocion;

public interface MarcaRepository extends Neo4jRepository<Marca,Long> {
	public List<Marca> findByCmarmuma(String cmarmuma);
	public List<Marca> findByName(String name);
	List<Promocion> findPromocionesById(String id);
	List<Promocion> findPromocionesByCmarmuma(String cmarmuma);
}