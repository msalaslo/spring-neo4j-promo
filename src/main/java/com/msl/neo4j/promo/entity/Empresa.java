package com.msl.neo4j.promo.entity;

import java.util.List;

import org.neo4j.ogm.annotation.GeneratedValue;
import org.neo4j.ogm.annotation.Id;
import org.neo4j.ogm.annotation.Index;
import org.neo4j.ogm.annotation.NodeEntity;
import org.neo4j.ogm.annotation.Relationship;

@NodeEntity(label="empresa")
public class Empresa implements Promocionable,RelacionableParent{
	
	@Id @GeneratedValue
    public Long id;
		
	@Index
	public String cempresa;
	
	public String name;
	
	@Relationship(type = "PROMOTED")
	private List<Promocion> promociones;
	
	public List<Promocion> getPromociones() {
		return promociones;
	}

	public void setPromociones(List<Promocion> promociones) {
		this.promociones = promociones;
	}
	
	public Empresa() {
	}
	
	public Empresa(String cempresa, String name) {
		super();
		this.cempresa = cempresa;
		this.name= name;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getCempresa() {
		return cempresa;
	}

	public void setCempresa(String cempresa) {
		this.cempresa = cempresa;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

}
