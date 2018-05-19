package com.msl.neo4j.promo.loader;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.msl.neo4j.promo.entity.Centro;
import com.msl.neo4j.promo.entity.EntityUtils;
import com.msl.neo4j.promo.entity.Producto;
import com.msl.neo4j.promo.entity.Relacionable;
import com.msl.neo4j.promo.entity.RelacionableParent;
import com.msl.neo4j.promo.repository.CentroRepository;
import com.msl.neo4j.promo.repository.ProductoRepository;


@Component
public class ProductoCentroRelationsLoader extends AbstractRelacionableRepositoryLoader implements IRelacionableRepositoryLoader{
	@Autowired
	private ProductoRepository productoRepo;
	
	@Autowired
	private CentroRepository centroRepo;
		
	@Override
	public void loadRelaciones() {
		super.loadRelaciones(EntityUtils.toRelacionable(productoRepo.findAll()), EntityUtils.toRelacionableParent(centroRepo.findAll()));
	}
	
	@Override
	public void deleteRelaciones() {
		List<Producto> productos = productoRepo.findAll();
		for (Producto producto : productos) {
			Centro centrosProd = producto.getCentro();
			if(centrosProd != null) {
				producto.setCentro(null);
				productoRepo.save(producto);
			}
		}
	}

	@Override
	public void save(Relacionable relacionable, RelacionableParent parent) {
		Producto producto = (Producto)relacionable;
		producto.setCentro((Centro)parent);
		productoRepo.save(producto);
	}
}
