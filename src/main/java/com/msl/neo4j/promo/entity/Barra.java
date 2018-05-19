package com.msl.neo4j.promo.entity;

import org.neo4j.ogm.annotation.GeneratedValue;
import org.neo4j.ogm.annotation.Id;
import org.neo4j.ogm.annotation.Index;
import org.neo4j.ogm.annotation.NodeEntity;

@NodeEntity(label="barra")
public class Barra {
	
	@Id
	@GeneratedValue 
    public Long id;
	
	@Index
	public String cbarraaa;
	
	public Barra() {
	}
	
	public Barra(String cbarraaa) {
		super();
		this.cbarraaa = cbarraaa;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getCbarraaa() {
		return cbarraaa;
	}

	public void setCbarraaa(String cbarraaa) {
		this.cbarraaa = cbarraaa;
	}

}
