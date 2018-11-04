package com.msl.neo4j.promo.repository;

import java.util.List;
import java.util.Optional;
import java.util.stream.Stream;

import org.springframework.data.neo4j.annotation.Query;
import org.springframework.data.neo4j.repository.Neo4jRepository;
import org.springframework.data.repository.query.Param;

import com.msl.neo4j.promo.entity.Producto;
import com.msl.neo4j.promo.entity.Promocion;

public interface ProductoRepository extends Neo4jRepository<Producto,Long> {
	public Optional<Producto> findById(Long id);
	public Iterable<Producto> findByReferencia(String referencia);
	public Producto findByName(String name);
	public List<Producto> findAll();
	Iterable<Promocion> findPromocionesById(Long id);
	Iterable<Promocion> findPromocionesByName(String name);
	Iterable<Promocion> findPromocionesByReferencia(String referencia);

	@Query("MATCH (n:producto {referencia={0}})-[PROMOTED*1..10]-> (p:promocion) RETURN p")
	Iterable<Promocion> findAllPromocionesById(String ref);
	
	@Query("MATCH (n:`producto`) RETURN n")
	public Stream<Producto> findAllAsStream();
}