package com.msl.neo4j.promo.loader;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.msl.neo4j.promo.entity.Producto;
import com.msl.neo4j.promo.entity.Promocion;
import com.msl.neo4j.promo.entity.Promocionable;
import com.msl.neo4j.promo.repository.ProductoRepository;


@Component
public class ProductoPromocionRelationsLoader extends AbstractPromocionableRepositoryLoader implements IPromocionableRepositoryLoader{
	
	@Autowired
	private ProductoRepository repository;
		
	@Override
	public void loadPromociones() {
		List<Producto> productos = repository.findAll();
		List<Promocionable> promocionables = new ArrayList<Promocionable>();
		for (Producto producto : productos) {
			promocionables.add((Promocionable)producto);
		}
		super.loadPromociones(promocionables);
	}
	
	@Override
	public void deletePromociones() {
		List<Producto> productos = repository.findAll();
		for (Producto producto : productos) {
			List<Promocion> promocionesProd = producto.getPromociones();
			if(promocionesProd != null && !promocionesProd.isEmpty()) {
				producto.setPromociones(Collections.<Promocion>emptyList());
				repository.save(producto);
			}
		}
	}
	
	@Override
	public void saveCasting(Promocionable promocionable) {
		repository.save((Producto)promocionable);
	}
}
