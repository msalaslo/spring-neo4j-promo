package com.msl.neo4j.promo.repository;

import java.util.Optional;

import org.springframework.data.neo4j.repository.Neo4jRepository;

import com.msl.neo4j.promo.entity.Empresa;
import com.msl.neo4j.promo.entity.Promocion;

public interface EmpresaRepository extends Neo4jRepository<Empresa,Long> {
	public Optional<Empresa> findById(Long id);
	public Iterable<Empresa> findByCempresa(String cempresa);
	public Iterable<Empresa> findByName(String cempresa);
	public Iterable<Empresa> findPromocionesByCempresa(String cempresa);
	public Iterable<Promocion> findPromocionesById(Long id);
	public Iterable<Promocion> findPromocionesByName(String name);
}