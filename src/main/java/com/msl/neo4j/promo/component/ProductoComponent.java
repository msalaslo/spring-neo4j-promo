package com.msl.neo4j.promo.component;

import java.io.BufferedWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.stream.Stream;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Slice;
import org.springframework.stereotype.Component;

import com.msl.neo4j.promo.entity.Producto;
import com.msl.neo4j.promo.repository.ProductoRepository;

@Component
public class ProductoComponent {

	private static final Logger logger = LoggerFactory.getLogger(ProductoComponent.class.getName());
	private static final String PATH_REF = "c:/temp/" + ProductoComponent.class.getName() + "-references.txt";
	private static final String PATH_ID = "c:/temp/" + ProductoComponent.class.getName() + "-ids.txt";
	private static final int ATTR_ID = 0;
	private static final int ATTR_REF = 1;
	private static final int PAGE_SIZE = 100;

	@Autowired
	ProductoRepository repository;

	public void generateReferencesFile() {
		generateAttrFilePaging(ATTR_REF);
	}

	public void generateIdsFile() {
		generateAttrFilePaging(ATTR_ID);
	}
	
	private void generateReferencesFileStreaming(int attr) {
		// Get the file reference
		Path path = Paths.get(getAttrPath(attr));
		log("Generando fichero de REFERENCIAS en la ruta:" + path.toAbsolutePath());
		// Use try-with-resource to get auto-closeable writer instance
		try (BufferedWriter writer = Files.newBufferedWriter(path)) {
			try (Stream<Producto> streamProductos = repository.findAllAsStream()) {
				streamProductos.forEach((producto -> {
					writeAttr(getAttr(producto, attr), writer);
				}));
			} catch (Exception e) {
				logError("Error generando fichero de IDs al leer y escribir resultados", e);
			}
		} catch (IOException e) {
			logError("Error generando fichero de IDs al abrir fichero", e);
		}
		log("Fichero generado correctamente.");
	}

	private void generateAttrFilePaging(int attr) {
		// Get the file reference
		Path path = Paths.get(getAttrPath(attr));
		log("Generando fichero en la ruta:" + path.toAbsolutePath());
		// Use try-with-resource to get auto-closeable writer instance
		try (BufferedWriter writer = Files.newBufferedWriter(path)) {
			Slice<Producto> productoPage;
			int page = 0;
			do {
				productoPage = repository.findAll(PageRequest.of(page, PAGE_SIZE));
				for (Producto producto : productoPage) {
					writeAttr(getAttr(producto, attr), writer);
				}
				page++;
			} while (productoPage.hasNext());
			writer.flush();
		} catch (IOException e) {
			logError("Error al abrir fichero", e);
		}
		log("Fichero generado correctamente.");
	}

	private static String getAttr(Producto producto, int attr) {
		switch (attr) {
		case ATTR_ID:
			return String.valueOf(producto.getId());
		case ATTR_REF:
			return String.valueOf(producto.getReferencia());
		default:
			return String.valueOf(producto.getId());
		}
	}

	private static String getAttrPath(int attr) {
		switch (attr) {
		case ATTR_ID:
			return PATH_ID;
		case ATTR_REF:
			return PATH_REF;
		default:
			return PATH_ID;
		}
	}

	private static void writeAttr(String attr, BufferedWriter writer) {
		try {
			writer.write(attr + "\n");
		} catch (IOException e) {
			throw new RuntimeException(e);
		}
	}

	private static void log(String msg) {
		logger.info(msg);
//		System.out.println(msg);
	}

	private static void logError(String msg, Exception e) {
		logger.error(msg, e);
//		System.out.println(msg);
		e.printStackTrace();
	}
}
