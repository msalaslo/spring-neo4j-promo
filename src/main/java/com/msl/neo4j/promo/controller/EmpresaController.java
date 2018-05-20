package com.msl.neo4j.promo.controller;

import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.msl.neo4j.promo.entity.Empresa;
import com.msl.neo4j.promo.entity.Promocion;
import com.msl.neo4j.promo.service.EmpresaService;


@RestController
@RequestMapping("/empresa")
public class EmpresaController {
	
	private static final Logger logger = LoggerFactory.getLogger(EmpresaController.class.getName());
	
	@Autowired
	EmpresaService service;
	
	@GetMapping(path = "/findByid")
    public Optional<Empresa> findByid(@RequestParam(value="id", required=false, defaultValue="0") Long id, Model model) {
        logger.debug("Buscando empresa por id...");
        return service.findByid(id);
    }
	
	@GetMapping(path = "/findByName")
    public Iterable<Empresa> findByName(@RequestParam(value="name", required=false, defaultValue="0") String name, Model model) {
        logger.debug("Buscando empresa por name...");
        return service.findByName(name);
    }
	
	@GetMapping(path = "/findByCempresa")
    public Iterable<Empresa> findByCempresa(@RequestParam(value="cempresa", required=false, defaultValue="0") String cempresa, Model model) {
        logger.debug("Buscando empresa por cempresa...");
        return service.findByCempresa(cempresa);
    }
	
	@GetMapping(path = "/findPromocionesById")
    public Iterable<Promocion> findPromocionesById(@RequestParam(value="id", required=false, defaultValue="0") Long id, Model model) {
        logger.debug("Buscando promociones por id...");
        return service.findPromocionesById(id);
    }	
	
	@GetMapping(path = "/findPromocionesByCempresa")
    public Iterable<Promocion> findPromocionesByCempresa(@RequestParam(value="cempresa", required=false, defaultValue="0") String cempresa, Model model) {
        logger.debug("Buscando promociones por cempresa...");
        return service.findPromocionesByCempresa(cempresa);
    }	
		
    @PostMapping(path = "/save")
    public ResponseEntity<Empresa> save(@RequestBody Empresa empresa) {
    	Empresa savedProduct = this.service.save(empresa);
        return new ResponseEntity<>(savedProduct, HttpStatus.CREATED);
    }
}