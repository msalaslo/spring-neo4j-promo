package com.msl.neo4j.promo.entity;

import java.util.List;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.neo4j.ogm.annotation.GeneratedValue;
import org.neo4j.ogm.annotation.Id;
import org.neo4j.ogm.annotation.Index;
import org.neo4j.ogm.annotation.NodeEntity;
import org.neo4j.ogm.annotation.Relationship;

@NodeEntity(label="marca")
public class Marca implements Promocionable, Relacionable, RelacionableParent{
			
	@Id @GeneratedValue
	public Long id;
		
	@Index
	private String cmarmuma;
				
//	@Relations(edges = MarcaPromocion.class, lazy = true)
	@Relationship(type = "PROMOTED")
	public List<Promocion> promociones;
	
	private String name; 
	
	public Marca() {
		super();
	}
	
	public Marca(String cmarmuma, String name) {
		super();
		this.cmarmuma = cmarmuma;
		this.name = name;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public List<Promocion> getPromociones() {
		return promociones;
	}

	public void setPromociones(List<Promocion> promociones) {
		this.promociones = promociones;
	}

	public String getCmarmuma() {
		return cmarmuma;
	}

	public void setCmarmuma(String cmarmuma) {
		this.cmarmuma = cmarmuma;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Override
    public String toString() {
        return new ToStringBuilder(this).
        		append("id", id).
                append("cmarmuma", cmarmuma).
                append("name", name).
                append("promociones", promociones).
        		toString();
    }
}
