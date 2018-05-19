package com.msl.neo4j.promo.loader;

import com.msl.neo4j.promo.entity.Promocion;
import com.msl.neo4j.promo.entity.Promocionable;

public interface IPromocionableRepositoryLoader {
	public void loadPromociones();
	public void deletePromociones();
	public void loadPromociones(Iterable<Promocionable> promocionables);
	public void save(Promocionable promocionable, Promocion promocion);
}
