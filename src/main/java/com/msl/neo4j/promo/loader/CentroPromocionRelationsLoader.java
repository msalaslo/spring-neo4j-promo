package com.msl.neo4j.promo.loader;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.msl.neo4j.promo.entity.Centro;
import com.msl.neo4j.promo.entity.Promocion;
import com.msl.neo4j.promo.entity.Promocionable;
import com.msl.neo4j.promo.repository.CentroRepository;


@Component
public class CentroPromocionRelationsLoader extends AbstractPromocionableRepositoryLoader implements IPromocionableRepositoryLoader{
	
	@Autowired
	private CentroRepository repository;
	
	@Override
	public void loadPromociones() {
		Iterable<Centro> centros = repository.findAll();
		List<Promocionable> promocionables = new ArrayList<Promocionable>();
		for (Centro centro : centros) {
			promocionables.add((Promocionable)centro);
		}
		super.loadPromociones(promocionables);
	}
		

	@Override
	public void deletePromociones() {
		Iterable<Centro> centros = repository.findAll();
		for (Centro centro : centros) {
			List<Promocion> promocionesProd = centro.getPromociones();
			if(promocionesProd != null && !promocionesProd.isEmpty()) {
				centro.setPromociones(Collections.<Promocion>emptyList());
				repository.save(centro);
			}
		}
	}

	@Override
	public void saveCasting(Promocionable promocionable) {
		repository.save((Centro)promocionable);
	}

}
