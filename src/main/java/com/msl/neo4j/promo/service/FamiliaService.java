package com.msl.neo4j.promo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.msl.neo4j.promo.entity.Familia;
import com.msl.neo4j.promo.entity.Promocion;
import com.msl.neo4j.promo.repository.FamiliaRepository;

@Service
public class FamiliaService {

	@Autowired
	FamiliaRepository repository;
    
    public List<Familia> findByCfamilia(String cfamilia){
    	return repository.findByCfamilia(cfamilia);
    }
    
    public List<Promocion> findPromocionesByCfamilia(String cfamilia){
    	return repository.findPromocionesByCfamilia(cfamilia);
    }

	public Familia save(Familia familia) {
		return repository.save(familia);
	}
}
