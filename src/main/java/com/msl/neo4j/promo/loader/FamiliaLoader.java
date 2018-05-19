package com.msl.neo4j.promo.loader;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.msl.neo4j.promo.entity.Familia;
import com.msl.neo4j.promo.repository.FamiliaRepository;

@Component
public class FamiliaLoader implements IRepositoryLoader{

	@Autowired
	private FamiliaRepository repository;
	
	@Override
	public void deleteAll() {
	    repository.deleteAll();
	}

	@Override
	public void load() {
		Collection<Familia> createFamilias = createFamilias(RepositoryConfig.NUM_FAMILIAS);
		repository.saveAll(createFamilias);
	}

	private static Collection<Familia> createFamilias(int numFamilias) {
		String namePrefix = "familia";
		List<Familia> familias = new ArrayList<Familia>();
		for (int cfamilia = 0; cfamilia < numFamilias; cfamilia++) {
			String cfamiliaStr = String.format("%03d", Integer.valueOf(cfamilia));
			Familia familia = new Familia(cfamiliaStr, namePrefix + cfamilia);
			familias.add(familia);
		}
		return familias;
	}
}