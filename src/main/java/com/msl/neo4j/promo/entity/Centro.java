package com.msl.neo4j.promo.entity;

import java.util.List;

import org.neo4j.ogm.annotation.GeneratedValue;
import org.neo4j.ogm.annotation.Id;
import org.neo4j.ogm.annotation.Index;
import org.neo4j.ogm.annotation.NodeEntity;
import org.neo4j.ogm.annotation.Relationship;

@NodeEntity(label="centro")
public class Centro extends AbstractPromocionable implements Relacionable,RelacionableParent {
	
	@Id @GeneratedValue
    public Long id;
	
	@Index
	public String centroo;
		
	@Relationship(type = "PROMOTED")
	private List<Promocion> promociones;

	
	public List<Promocion> getPromociones() {
		return promociones;
	}

	public void setPromociones(List<Promocion> promociones) {
		this.promociones = promociones;
	}
	
	@Relationship(type = "BELONGS")
	private Empresa empresa;
	
	public Centro() {
	}
	
	public Centro(String centroo, String name) {
		super();
		this.centroo = centroo;
		super.setName(name);
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getCentroo() {
		return centroo;
	}

	public void setCentroo(String centroo) {
		this.centroo = centroo;
	}

	public Empresa getEmpresa() {
		return empresa;
	}

	public void setEmpresa(Empresa empresa) {
		this.empresa = empresa;
	}



}
