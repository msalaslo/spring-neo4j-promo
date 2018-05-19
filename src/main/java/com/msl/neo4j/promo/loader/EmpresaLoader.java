package com.msl.neo4j.promo.loader;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.msl.neo4j.promo.entity.Empresa;
import com.msl.neo4j.promo.repository.EmpresaRepository;

@Component
public class EmpresaLoader implements IRepositoryLoader {

	@Autowired
	private EmpresaRepository repository;

	@Override
	public void deleteAll() {
		repository.deleteAll();
	}

	@Override
	public void load() {
		List<Empresa> createEmpresas = createEmpresas(RepositoryConfig.NUM_EMPRESAS);
		repository.saveAll(createEmpresas);
	}

	private static List<Empresa> createEmpresas(int numEmpresas) {
		String namePrefix = "empresa";
		List<Empresa> empresas = new ArrayList<Empresa>();
		for (int cempresa = 0; cempresa < numEmpresas; cempresa++) {
			String cempresaStr = String.format("%03d", Integer.valueOf(cempresa));
			Empresa empresa = new Empresa(cempresaStr, namePrefix + cempresa);
			empresas.add(empresa);
		}
		return empresas;
	}
}