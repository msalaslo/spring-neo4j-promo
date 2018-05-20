package com.msl.neo4j.promo;

import org.neo4j.ogm.session.SessionFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.neo4j.repository.config.EnableNeo4jRepositories;
import org.springframework.data.neo4j.transaction.Neo4jTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@Configuration
//@EnableTransactionManagement
@ComponentScan("com.msl.neo4j.promo")
@EnableNeo4jRepositories("com.msl.neo4j.promo.repository")
public class SpringDataNeo4jPersistenceContext {
	
	  @Bean
	  public SessionFactory sessionFactory() {
	    return new SessionFactory(configuration(), "com.msl.neo4j.promo");
	  }

	  @Bean
	  public Neo4jTransactionManager transactionManager() throws Exception {
	    return new Neo4jTransactionManager(sessionFactory());
	  }

	  @Bean
	  public org.neo4j.ogm.config.Configuration configuration() {
	    return new org.neo4j.ogm.config.Configuration.Builder()
	      .uri("bolt://localhost")
	      .credentials("neo4j", "promo")
	      .build();
	  }
}
