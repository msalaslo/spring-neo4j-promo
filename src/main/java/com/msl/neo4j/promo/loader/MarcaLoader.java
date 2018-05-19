package com.msl.neo4j.promo.loader;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Component;

import com.msl.neo4j.promo.entity.Marca;
import com.msl.neo4j.promo.repository.MarcaRepository;

@Component
public class MarcaLoader implements IRepositoryLoader {

	private static final Logger logger = LoggerFactory.getLogger(MarcaLoader.class.getName());

	@Autowired
	private MarcaRepository repository;

	@Override
	public void deleteAll() {
		repository.deleteAll();
	}

	@Override
	public void load() {
		Collection<Marca> createMarcas = createMarcas(RepositoryConfig.NUM_MARCAS);
		// logger.debug(String.format("Save %s additional marcas", numMarcas));
		repository.saveAll(createMarcas);

		// Iterable<Marca> all = repository.findAll();
		// long count =
		// StreamSupport.stream(Spliterators.spliteratorUnknownSize(all.iterator(), 0),
		// false).count();
		// logger.debug(String.format("A total of %s marcas are persisted in the
		// database", count));

		// printAllMarcasByName(repository);
	}

	public static void printAllMarcasByName(MarcaRepository repository) {
		Iterable<Marca> allSorted = repository.findAll(new Sort(Sort.Direction.ASC, "name"));
		allSorted.forEach(item -> logger.debug(item.toString()));
	}

	private static Collection<Marca> createMarcas(int numMarcas) {
		String namePrefix = "marca";
		List<Marca> marcas = new ArrayList<Marca>();
		for (int cmarmuma = 0; cmarmuma < numMarcas; cmarmuma++) {
			String cmarmumaStr = String.format("%014d", Integer.valueOf(cmarmuma));
			Marca marca = new Marca(cmarmumaStr, namePrefix + cmarmuma);
			marcas.add(marca);
		}
		return marcas;
	}
}
