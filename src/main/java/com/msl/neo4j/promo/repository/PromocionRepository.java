package com.msl.neo4j.promo.repository;

import java.util.List;

import org.springframework.data.neo4j.repository.Neo4jRepository;

import com.msl.neo4j.promo.entity.Promocion;
 
public interface PromocionRepository extends Neo4jRepository<Promocion,Long> {
	public Promocion findByCodpromoci(String codpromoci);
    public List<Promocion> findByCanlvnta(String canlvnta);   
}