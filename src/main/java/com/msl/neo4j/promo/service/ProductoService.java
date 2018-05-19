package com.msl.neo4j.promo.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.msl.neo4j.promo.entity.Producto;
import com.msl.neo4j.promo.entity.Promocion;
import com.msl.neo4j.promo.loader.ProductoLoader;
import com.msl.neo4j.promo.repository.ProductoRepository;

@Service
public class ProductoService {

	@Autowired
	ProductoRepository repository;
	
	@Autowired
	ProductoLoader loader;
	
    public Optional<Producto> findByid(String id){
    	return repository.findById(new Long(id));
    }
    
    public Iterable<Producto> findByReferencia(String referencia){
    	return repository.findByReferencia(referencia);
    }
    
    public Iterable<Promocion> findPromocionesById(String id){
    	return repository.findPromocionesById(id);
    }
    
    public Iterable<Promocion> findPromocionesByName(String name){
    	return repository.findPromocionesByName(name);
    }
    
    public Iterable<Promocion> findPromocionesByReferencia(String referencia){
    	return repository.findPromocionesByReferencia(referencia);
    }

	public Producto save(Producto product) {
		return repository.save(product);
	}
	public void add(int numProductos) {
		loader.add(numProductos);
	}
}
