package com.msl.neo4j.promo.entity;

import org.neo4j.ogm.annotation.GeneratedValue;
import org.neo4j.ogm.annotation.Id;
import org.neo4j.ogm.annotation.Index;
import org.neo4j.ogm.annotation.NodeEntity;

@NodeEntity(label="nivel")
public class Nivel {
	
	@Id @GeneratedValue
    public Long id;
	
	@Index
	public String cniveln;
	
	public Nivel() {
	}
	
	public Nivel(String cniveln) {
		super();
		this.cniveln = cniveln;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getCniveln() {
		return cniveln;
	}

	public void setCniveln(String cniveln) {
		this.cniveln = cniveln;
	}

}
