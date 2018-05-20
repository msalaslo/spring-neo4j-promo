package com.msl.neo4j.promo.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.msl.neo4j.promo.entity.Familia;
import com.msl.neo4j.promo.entity.Promocion;
import com.msl.neo4j.promo.repository.FamiliaRepository;

@Service
public class FamiliaService {

	@Autowired
	FamiliaRepository repository;
	
    public Optional<Familia> findByid(Long id){
    	return repository.findById(id);
    }
    
    public Iterable<Familia> findByCfamilia(String cfamilia){
    	return repository.findByCfamilia(cfamilia);
    }
    
    public Iterable<Familia> findByName(String name){
    	return repository.findByName(name);
    }
    
    public Iterable<Promocion> findPromocionesById(Long id){
    	return repository.findPromocionesById(id);
    }
    
    public Iterable<Promocion> findPromocionesByCfamilia(String cfamilia){
    	return repository.findPromocionesByCfamilia(cfamilia);
    }
    
    public Iterable<Promocion> findPromocionesByName(String name){
    	return repository.findPromocionesByName(name);
    }

	public Familia save(Familia product) {
		return repository.save(product);
	}
}
