package com.msl.neo4j.promo.entity;

import java.util.List;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.neo4j.ogm.annotation.GeneratedValue;
import org.neo4j.ogm.annotation.Id;
import org.neo4j.ogm.annotation.Index;
import org.neo4j.ogm.annotation.NodeEntity;
import org.neo4j.ogm.annotation.Relationship;

@NodeEntity(label="producto")
public class Producto implements Promocionable,Relacionable{
	@Id @GeneratedValue
	public Long id;

	@Index
	public String referencia;

	public String name;

	// @Relations(edges = ProductoPromocion.class, lazy = true)
	@Relationship(type = "PROMOTED")
	private List<Promocion> promociones;

	// @Relations(edges = ProductoMarca.class, lazy = true)
	@Relationship(type = "MARCA")
	private Marca marca;
	
	@Relationship(type = "FAMILIA")
	private Familia familia;
	
	@Relationship(type = "CENTRO")
	private Centro centro;

	public Producto() {
	}
	
	public Producto(String referencia, String name) {
		super();
		this.referencia = referencia;
		this.name = name;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getReferencia() {
		return referencia;
	}

	public void setReferencia(String referencia) {
		this.referencia = referencia;
	}

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

	
	public Marca getMarca() {
		return marca;
	}

	public void setMarca(Marca marca) {
		this.marca = marca;
	}

	public Familia getFamilia() {
		return familia;
	}

	public void setFamilia(Familia familia) {
		this.familia = familia;
	}

	public Centro getCentro() {
		return centro;
	}

	public void setCentro(Centro centro) {
		this.centro = centro;
	}

	@Override
    public String toString() {
        return new ToStringBuilder(this).
        		append("PRODUCTO:" + name).
        		append("id", id).
                append("referencia", referencia).
                append("promociones", promociones).
          	    append("marca", marca).
        		toString();
	}
}
