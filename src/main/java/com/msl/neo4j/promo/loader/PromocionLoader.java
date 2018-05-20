package com.msl.neo4j.promo.loader;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Component;

import com.msl.neo4j.promo.entity.Promocion;
import com.msl.neo4j.promo.repository.PromocionRepository;

@Component
public class PromocionLoader implements IRepositoryLoader{

	@Autowired
	private PromocionRepository repository;
	
	public void deleteAll() {
	    repository.deleteAll();
	}

	public void load() {    
	    List<Promocion> promociones = createPromos(RepositoryConfig.NUM_PROMOS);
	    repository.saveAll(promociones);
	     
//	    Iterable<Promocion> all = repository.findAll();
//	    long count = StreamSupport.stream(Spliterators.spliteratorUnknownSize(all.iterator(), 0), false).count();
//	    System.out.println(String.format("A total of %s promociones are persisted in the database", count));
	    
//	    printAllPromosByCodpromoci(repository);
	}
	
	public static void printAllPromosByCodpromoci(PromocionRepository repository) {
		System.out.println("## Return all promociones sorted by name");
		Iterable<Promocion> allSorted = repository.findAll(Sort.by(Sort.Direction.ASC, "codpromoci"));
		allSorted.forEach(System.out::println);
	}

	private List<Promocion> createPromos(int numPromociones) {
		List<Promocion> promociones = new ArrayList<Promocion>();

		String canlvnta = "CN";
		String dticprom = "TP";
		String xexcluye = "E";
		String finiefec = "20180101";
		String ffinefec = "20190101";
		String choraini = "0800";
		String chorafin = "0000";
		String cemprvnt = "001";
		String ccentvnt = "0001";
		String despromo = "Descripcion promocion";
		String ccarpeta = "01234567890123";
		String descarpe = "Descripcion carpeta";
		String coorigen = "123";
		String codplaex = "123456789012345678901234";
		String chordiad = "123";
		String chordiah = "456";
		String xtipobon = "B";
		String xusopweb = "W";

		for (int codPromocion = 0; codPromocion < numPromociones; codPromocion++) {
			String codpromoci = String.format("%08d",Integer.valueOf(codPromocion));

			Promocion promocion = new Promocion(codpromoci, canlvnta, dticprom, xexcluye, finiefec,
					ffinefec, choraini, chorafin, cemprvnt, ccentvnt, despromo, ccarpeta, descarpe, coorigen, codplaex,
					chordiad, chordiah, xtipobon, xusopweb);
			promociones.add(promocion);
		}
		return promociones;
	}
}
