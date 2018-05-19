package com.msl.neo4j.promo.loader;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.msl.neo4j.promo.entity.Familia;
import com.msl.neo4j.promo.entity.Promocion;
import com.msl.neo4j.promo.entity.Promocionable;
import com.msl.neo4j.promo.repository.FamiliaRepository;


@Component
public class FamiliaPromocionRelationsLoader extends AbstractPromocionableRepositoryLoader implements IPromocionableRepositoryLoader{
	
	@Autowired
	private FamiliaRepository repository;
		
	@Override
	public void loadPromociones() {
		Iterable<Familia> familias = repository.findAll();
		List<Promocionable> promocionables = new ArrayList<Promocionable>();
		for (Familia familia : familias) {
			promocionables.add((Promocionable)familia);
		}
		super.loadPromociones(promocionables);
	}

	@Override
	public void deletePromociones() {
		Iterable<Familia> familias = repository.findAll();
		for (Familia familia : familias) {
			List<Promocion> promocionesProd = familia.getPromociones();
			if(promocionesProd != null && !promocionesProd.isEmpty()) {
				familia.setPromociones(Collections.<Promocion>emptyList());
				repository.save(familia);
			}
		}
	}

	@Override
	public void saveCasting(Promocionable promocionable) {
		repository.save((Familia)promocionable);
	}
}
