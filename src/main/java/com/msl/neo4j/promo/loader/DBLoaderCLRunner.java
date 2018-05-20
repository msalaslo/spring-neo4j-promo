package com.msl.neo4j.promo.loader;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.ComponentScan;

@ComponentScan("com.msl")
public class DBLoaderCLRunner implements CommandLineRunner {
	
	private static final Logger logger = LoggerFactory.getLogger(DBLoaderCLRunner.class.getName());
	
	@Autowired
	EmpresaLoader empresaLoader;
	
	@Autowired
	CentroLoader centroLoader;
	
	@Autowired
	FamiliaLoader familiaLoader;

	@Autowired
	MarcaLoader marcaLoader;

	@Autowired
	ProductoLoader productoLoader;

	@Autowired
	PromocionLoader promocionLoader;
	
	@Autowired
	CentroEmpresaRelationsLoader centroEmpresaLoader;

	@Autowired
	ProductoMarcaRelationsLoader productoMarcaLoader;
	
	@Autowired
	ProductoCentroRelationsLoader productoCentroLoader;
	
	@Autowired
	ProductoFamiliaRelationsLoader productoFamiliaLoader;
	
	@Autowired
	EmpresaPromocionRelationsLoader empresaPromocionLoader;
	
	@Autowired
	CentroPromocionRelationsLoader centroPromocionLoader;
	
	@Autowired
	FamiliaPromocionRelationsLoader familiaPromocionLoader;

	@Autowired
	ProductoPromocionRelationsLoader productoPromocionLoader;

	@Autowired
	MarcaPromocionRelationsLoader marcaPromocionLoader;
	
	@Override
	public void run(final String... args) throws Exception {
		IRepositoryLoader[] loaders = {empresaLoader, centroLoader, familiaLoader, marcaLoader, productoLoader, promocionLoader};
		IRelacionableRepositoryLoader[] relacionableLoaders = {centroEmpresaLoader, productoCentroLoader, productoMarcaLoader, productoFamiliaLoader};
		IPromocionableRepositoryLoader[] promocionLoaders = {empresaPromocionLoader, centroPromocionLoader, marcaPromocionLoader, familiaPromocionLoader, productoPromocionLoader};
		deleteRepositories(loaders);
		deletePromociones(promocionLoaders);
		deleteRelaciones(relacionableLoaders);
		loadRepositories(loaders);		
		loadPromociones(promocionLoaders);
		loadRelaciones(relacionableLoaders);
	}
	
	private void deleteRepositories(IRepositoryLoader[] loaders) {
		for (IRepositoryLoader loader : loaders) {
			logger.debug("Borrando datos sobre " + loader);
			loader.deleteAll();
		}
	}
	
	private void loadRepositories(IRepositoryLoader[] loaders) {
		for (IRepositoryLoader loader : loaders) {
			logger.debug("Cargando datos sobre " + loader);
			loader.load();
		}
	}
	
	private void deleteRelaciones(IRelacionableRepositoryLoader[] loaders) {
		for (IRelacionableRepositoryLoader loader : loaders) {
			logger.debug("Borrando relaciones sobre " + loader);
			loader.deleteRelaciones();
		}
	}
	
	private void loadRelaciones(IRelacionableRepositoryLoader[] loaders) {
		for (IRelacionableRepositoryLoader loader : loaders) {
			logger.debug("Cargando relaciones sobre " + loader);
			loader.loadRelaciones();
		}
	}
	
	private void deletePromociones(IPromocionableRepositoryLoader[] loaders) {
		for (IPromocionableRepositoryLoader loader : loaders) {
			logger.debug("Borrado promociones de " + loader);
			loader.deletePromociones();
		}
	}
	
	private void loadPromociones(IPromocionableRepositoryLoader[] loaders) {
		for (IPromocionableRepositoryLoader loader : loaders) {
			logger.debug("Cargando promociones sobre " + loader);
			loader.loadPromociones();
		}
	}
}
