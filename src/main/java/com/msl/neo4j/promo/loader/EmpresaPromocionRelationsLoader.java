package com.msl.neo4j.promo.loader;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.msl.neo4j.promo.entity.Empresa;
import com.msl.neo4j.promo.entity.Promocion;
import com.msl.neo4j.promo.entity.Promocionable;
import com.msl.neo4j.promo.repository.EmpresaRepository;


@Component
public class EmpresaPromocionRelationsLoader extends AbstractPromocionableRepositoryLoader implements IPromocionableRepositoryLoader{
	
	@Autowired
	private EmpresaRepository repository;
	
	@Override
	public void loadPromociones() {
		Iterable<Empresa> empresas = repository.findAll();
		List<Promocionable> promocionables = new ArrayList<Promocionable>();
		for (Empresa empresa : empresas) {
			promocionables.add((Promocionable)empresa);
		}
		super.loadPromociones(promocionables);
	}
		

	@Override
	public void deletePromociones() {
		Iterable<Empresa> empresas = repository.findAll();
		for (Empresa empresa : empresas) {
			List<Promocion> promocionesProd = empresa.getPromociones();
			if(promocionesProd != null && !promocionesProd.isEmpty()) {
				empresa.setPromociones(Collections.<Promocion>emptyList());
				repository.save(empresa);
			}
		}
	}

	@Override
	public void saveCasting(Promocionable promocionable) {
		repository.save((Empresa)promocionable);
	}

}
