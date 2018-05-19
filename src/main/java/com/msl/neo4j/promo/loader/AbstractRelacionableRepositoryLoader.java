package com.msl.neo4j.promo.loader;

import java.util.Iterator;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.msl.neo4j.promo.entity.EntityUtils;
import com.msl.neo4j.promo.entity.Relacionable;
import com.msl.neo4j.promo.entity.RelacionableParent;


public abstract class AbstractRelacionableRepositoryLoader implements IRelacionableRepositoryLoader{
	
	private static final Logger logger = LoggerFactory.getLogger(AbstractPromocionableRepositoryLoader.class.getName());

	
	public void loadRelaciones(Iterable<Relacionable> relacionables, Iterable<RelacionableParent> parents) {
		int numParents = EntityUtils.getSize(parents);
		int numRelacionables = EntityUtils.getSize(relacionables);
		Iterator<RelacionableParent> ite = parents.iterator();
		int section = numRelacionables/numParents;
		int cont = 1;
		RelacionableParent parent = ite.next();
		logger.debug("Asociando el padre " + parent);
		for (Relacionable relacionable : relacionables) {		
//			logger.debug("Asociando el padre " + parent + " al relacionable " + relacionable );
			this.save(relacionable, parent);
			if(cont == section) {
				logger.debug("Cambiando el padre " + parent);
				if(ite.hasNext()) {
					parent = ite.next();
				}
				cont = 1;
			}else {
				cont++;
			}			
		}				
	}
	
	public abstract void save(Relacionable relacionable, RelacionableParent parent);

}
