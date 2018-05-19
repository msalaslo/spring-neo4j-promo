package com.msl.neo4j.promo.entity;

import java.util.List;

import org.neo4j.ogm.annotation.Relationship;

public class AbstractPromocionable implements Promocionable {

	private String name;

	// @Relations(edges = ProductoPromocion.class, lazy = true)
	@Relationship(type = "PROMOTED")
	private List<Promocion> promociones;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public List<Promocion> getPromociones() {
		return promociones;
	}

	public void setPromociones(List<Promocion> promociones) {
		this.promociones = promociones;
	}
}
