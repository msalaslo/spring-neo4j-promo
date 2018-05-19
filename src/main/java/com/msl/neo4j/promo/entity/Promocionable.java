package com.msl.neo4j.promo.entity;

import java.util.List;

public interface Promocionable {
	
	public List<Promocion> getPromociones();
	public void setPromociones(List<Promocion> promociones);

}
