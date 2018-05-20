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

import com.msl.neo4j.promo.entity.Familia;
import com.msl.neo4j.promo.entity.Promocion;
import com.msl.neo4j.promo.service.FamiliaService;


@RestController
@RequestMapping("/familia")
public class FamiliaController {
	
	private static final Logger logger = LoggerFactory.getLogger(FamiliaController.class.getName());
	
	@Autowired
	FamiliaService service;
	
	@GetMapping(path = "/findByid")
    public Optional<Familia> findByid(@RequestParam(value="id", required=false, defaultValue="0") Long id, Model model) {
        logger.debug("Buscando familia por id...");
        return service.findByid(id);
    }
	
	@GetMapping(path = "/findByCfamilia")
    public Iterable<Familia> findByCfamilia(@RequestParam(value="cfamilia", required=false, defaultValue="0") String cfamilia, Model model) {
        logger.debug("Buscando familia por cfamilia...");
        return service.findByCfamilia(cfamilia);
    }
	
	@GetMapping(path = "/findByName")
    public Iterable<Familia> findByName(@RequestParam(value="name", required=false, defaultValue="0") String name, Model model) {
        logger.debug("Buscando familia por name...");
        return service.findByName(name);
    }
	
	@GetMapping(path = "/findPromocionesById")
    public Iterable<Promocion> findPromocionesById(@RequestParam(value="id", required=false, defaultValue="0") Long id, Model model) {
        logger.debug("Buscando promociones por id...");
        return service.findPromocionesById(id);
    }	
	
	@GetMapping(path = "/findPromocionesByCfamilia")
    public Iterable<Promocion> findPromocionesByCfamilia(@RequestParam(value="cfamilia", required=false, defaultValue="0") String cfamilia, Model model) {
        logger.debug("Buscando promociones por cfamilia...");
        return service.findPromocionesByCfamilia(cfamilia);
    }	
		
    @PostMapping(path = "/save")
    public ResponseEntity<Familia> save(@RequestBody Familia familia) {
    	Familia savedProduct = this.service.save(familia);
        return new ResponseEntity<>(savedProduct, HttpStatus.CREATED);
    }
}