package com.msl.neo4j.promo.entity;

import org.neo4j.ogm.annotation.GeneratedValue;
import org.neo4j.ogm.annotation.Id;
import org.neo4j.ogm.annotation.Index;
import org.neo4j.ogm.annotation.NodeEntity;

@NodeEntity(label="division")
public class Division {
	
	@Id @GeneratedValue
    public Long id;
	
	@Index
	public String cdivisio;
	
	public Division() {
	}
	
	public Division(String cdivisio) {
		super();
		this.cdivisio = cdivisio;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getCdivisio() {
		return cdivisio;
	}

	public void setCdivisio(String cdivisio) {
		this.cdivisio = cdivisio;
	}

}
