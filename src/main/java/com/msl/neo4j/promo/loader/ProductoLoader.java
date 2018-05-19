package com.msl.neo4j.promo.loader;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Component;

import com.msl.neo4j.promo.entity.Producto;
import com.msl.neo4j.promo.repository.ProductoRepository;

@Component
public class ProductoLoader implements IRepositoryLoader{
	
	private static final Logger logger = LoggerFactory.getLogger(ProductoLoader.class.getName());

	@Autowired
	private ProductoRepository repository;

	public void deleteAll() {
		repository.deleteAll();
	}

	public void load() {
		saveProductos(RepositoryConfig.NUM_PRODUCTOS, 0);
	}

	public void add(final int numProductos) {
		saveProductos(numProductos, 0);
	}

	public static void printAllProductosByName(ProductoRepository repository) {
		Iterable<Producto> allSorted = repository.findAll(new Sort(Sort.Direction.ASC, "name"));
		allSorted.forEach(item -> logger.debug(item.toString()));
	}

	private void saveProductos(int numProductos, int start) {
		int groups = 1;
		int groupSize = 1000;
		Iterable<Producto> productos = null;
		if (numProductos > groupSize) {
			groups = numProductos / groupSize;
		}
		if (groups > 1) {
			for (int i = 0; i < groups; i++) {
				productos = repository.saveAll(createProductos(start + i, groupSize));
			}
		} else {
			productos = repository.saveAll(createProductos(start, numProductos));
		}
		if (productos == null || !productos.iterator().hasNext()) {
			logger.error("No se ha guardado ningun producto.");
		}
	}

	private List<Producto> createProductos(int start, int numProductos) {
		logger.debug("Creando " + numProductos + " productos. Desde el id:" + start);
		List<Producto> productos = new ArrayList<Producto>();
		for (int i = start; i < numProductos + start; i++) {
			productos.add(createProducto(i));
		}
		return productos;
	}

	private Producto createProducto(int i) {
		String referencia = String.valueOf(UUID.randomUUID());
		Producto producto = new Producto(referencia, "producto" + i);
		checkCreation(producto, referencia);
		return producto;
	}

	public Producto createProductoWithAttr(int i) {
		String cempresa = String.format("%03d", Integer.valueOf(i));
		String centrooo = String.format("%04d", Integer.valueOf(i));
		String cdepartm = String.format("%04d", Integer.valueOf(i));
		String cfamilia = String.format("%03d", Integer.valueOf(i));
		String cbarraaa = String.format("%04d", Integer.valueOf(i));
		String ctallaec = String.format("%03d", Integer.valueOf(i));
		String cdivisio = String.format("%02d", Integer.valueOf(i));
		String cniveln = String.format("%01d", Integer.valueOf(i));
		String cfabrica = String.format("%06d", Integer.valueOf(i));
		String cmarmuma = String.format("%014d", Integer.valueOf(i));
		String referencia = cempresa + centrooo + cdepartm + cfamilia + cbarraaa + ctallaec + cdivisio + cniveln
				+ cfabrica + cmarmuma;
		Producto producto = new Producto(referencia, "producto" + i);
		checkCreation(producto, referencia);
		return producto;
	}

	private void checkCreation(Producto producto, String referencia) {
		if (producto == null) {
			logger.error("No se ha guardado el producto con refencia:" + referencia);
		}
	}
}
