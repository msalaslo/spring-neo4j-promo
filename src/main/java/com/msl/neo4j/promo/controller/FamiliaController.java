package com.msl.neo4j.promo.controller;

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
	
	Logger logger = LoggerFactory.getLogger(FamiliaController.class.getName());
	
	@Autowired
	FamiliaService service;
	
	@GetMapping(path = "/findByCfamilia")
    public Iterable<Familia> findByCfamilia(@RequestParam(value="cfamilia", required=false, defaultValue="0") String cfamilia, Model model) {
        logger.debug("Buscando marca por cfamilia...");
        return service.findByCfamilia(cfamilia);
    }
	
	@GetMapping(path = "/findPromocionesByCfamilia")
    public Iterable<Promocion> findPromocionesByCfamilia(@RequestParam(value="cfamilia", required=false, defaultValue="0") String cfamilia, Model model) {
        logger.debug("Buscando promociones por cfamilia...");
        return service.findPromocionesByCfamilia(cfamilia);
    }	
		
    @PostMapping(path = "/save")
    public ResponseEntity<Familia> save(@RequestBody Familia marca) {
    	Familia savedProduct = this.service.save(marca);
        return new ResponseEntity<>(savedProduct, HttpStatus.CREATED);
    }
}