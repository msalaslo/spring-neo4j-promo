package com.msl.neo4j.promo.entity;

import org.neo4j.ogm.annotation.GeneratedValue;
import org.neo4j.ogm.annotation.Id;
import org.neo4j.ogm.annotation.Index;
import org.neo4j.ogm.annotation.NodeEntity;

@NodeEntity(label="fabrica")
public class Fabrica {
	
	@Id @GeneratedValue
    public Long id;
	
	@Index
	public String cfabrica;
	
	public Fabrica() {
	}
	
	public Fabrica(String cfabrica) {
		super();
		this.cfabrica = cfabrica;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getCfabrica() {
		return cfabrica;
	}

	public void setCfabrica(String cfabrica) {
		this.cfabrica = cfabrica;
	}

}
