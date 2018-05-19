package com.msl.neo4j.promo.loader;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.msl.neo4j.promo.entity.Marca;
import com.msl.neo4j.promo.entity.Promocion;
import com.msl.neo4j.promo.entity.Promocionable;
import com.msl.neo4j.promo.repository.MarcaRepository;


@Component
public class MarcaPromocionRelationsLoader extends AbstractPromocionableRepositoryLoader implements IPromocionableRepositoryLoader{
	@Autowired
	private MarcaRepository repository;
		
	@Override
	public void loadPromociones() {
		Iterable<Marca> marcas = repository.findAll();
		List<Promocionable> promocionables = new ArrayList<Promocionable>();
		for (Marca marca : marcas) {
			promocionables.add((Promocionable)marca);
		}
		super.loadPromociones(promocionables);
	}
	
	@Override
	public void deletePromociones() {
		Iterable<Marca> marcas = repository.findAll();
		for (Marca marca : marcas) {
			List<Promocion> promocionesProd = marca.getPromociones();
			if(promocionesProd != null && !promocionesProd.isEmpty()) {
				marca.setPromociones(Collections.<Promocion>emptyList());
				repository.save(marca);
			}
		}
	}

	@Override
	public void saveCasting(Promocionable promocionable) {
		repository.save((Marca)promocionable);
	}
}
