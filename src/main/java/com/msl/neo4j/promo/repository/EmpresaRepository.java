package com.msl.neo4j.promo.repository;

import java.util.List;

import org.springframework.data.neo4j.repository.Neo4jRepository;

import com.msl.neo4j.promo.entity.Empresa;
import com.msl.neo4j.promo.entity.Promocion;

public interface EmpresaRepository extends Neo4jRepository<Empresa,Long> {
	public List<Empresa> findByCempresa(String cempresa);
	List<Promocion> findPromocionesByCempresa(String cempresa);
}