package com.msl.neo4j.promo;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.msl.neo4j.promo.loader.DBLoaderCLRunner;

@SpringBootApplication
public class SpringDataNeo4jPromoApplication {

	private static final Logger logger = LoggerFactory.getLogger(SpringDataNeo4jPromoApplication.class);
	public final static String name = "Neo4J Promo";
	
	public static void main(final String... args) {
		logger.info("Iniciando aplicacion " + name);
//		SpringApplication.run(GotApp.class, args);
		SpringApplication.run(DBLoaderCLRunner.class, args);
//		System.exit(SpringApplication.exit(SpringApplication.run(runner, args)));
		logger.info("Aplicacion " + name + " iniciada");
	}
}
