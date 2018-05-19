package com.msl.neo4j.promo.entity;

import org.neo4j.ogm.annotation.GeneratedValue;
import org.neo4j.ogm.annotation.Id;
import org.neo4j.ogm.annotation.Index;
import org.neo4j.ogm.annotation.NodeEntity;

@NodeEntity(label="talla")
public class Talla {
	
	@Id @GeneratedValue
    public Long id;
	
	@Index
	public String ctallaec;
	
	public Talla() {}
	
	public Talla(String ctallaec) {
		super();
		this.ctallaec = ctallaec;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getCtallaec() {
		return ctallaec;
	}

	public void setCtallaec(String ctallaec) {
		this.ctallaec = ctallaec;
	}

}
