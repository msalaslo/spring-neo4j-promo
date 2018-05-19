package com.msl.neo4j.promo.entity;

import org.neo4j.ogm.annotation.GeneratedValue;
import org.neo4j.ogm.annotation.Id;
import org.neo4j.ogm.annotation.Index;
import org.neo4j.ogm.annotation.NodeEntity;

@NodeEntity(label="departamento")
public class Departamento {

	@Id @GeneratedValue
    public Long id;
	
	@Index
	public String cdepartm;
	
	public Departamento() {
	}
	
	public Departamento(String cdepartm) {
		super();
		this.cdepartm = cdepartm;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getCdepartm() {
		return cdepartm;
	}

	public void setCdepartm(String cdepartm) {
		this.cdepartm = cdepartm;
	}





}
