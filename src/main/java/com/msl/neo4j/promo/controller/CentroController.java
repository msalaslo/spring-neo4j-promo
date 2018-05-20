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

import com.msl.neo4j.promo.entity.Centro;
import com.msl.neo4j.promo.entity.Promocion;
import com.msl.neo4j.promo.service.CentroService;


@RestController
@RequestMapping("/centro")
public class CentroController {
	
	private static final Logger logger = LoggerFactory.getLogger(CentroController.class.getName());
	
	@Autowired
	CentroService service;
	
	@GetMapping(path = "/findByid")
    public Optional<Centro> findByid(@RequestParam(value="id", required=false, defaultValue="0") Long id, Model model) {
        logger.debug("Buscando centro por id...");
        return service.findByid(id);
    }
	
	@GetMapping(path = "/findByName")
    public Iterable<Centro> findByName(@RequestParam(value="name", required=false, defaultValue="0") String name, Model model) {
        logger.debug("Buscando centro por name...");
        return service.findByName(name);
    }
	
	@GetMapping(path = "/findByCentroo")
    public Iterable<Centro> findByCentroo(@RequestParam(value="centroo", required=false, defaultValue="0") String centroo, Model model) {
        logger.debug("Buscando centro por centroo...");
        return service.findByCentroo(centroo);
    }
	
	@GetMapping(path = "/findPromocionesById")
    public Iterable<Promocion> findPromocionesById(@RequestParam(value="id", required=false, defaultValue="0") Long id, Model model) {
        logger.debug("Buscando promociones por id...");
        return service.findPromocionesById(id);
    }	
	
	@GetMapping(path = "/findPromocionesByCentroo")
    public Iterable<Promocion> findPromocionesByCentroo(@RequestParam(value="centroo", required=false, defaultValue="0") String centroo, Model model) {
        logger.debug("Buscando promociones por centroo...");
        return service.findPromocionesByCentroo(centroo);
    }	
		
    @PostMapping(path = "/save")
    public ResponseEntity<Centro> save(@RequestBody Centro centro) {
    	Centro savedProduct = this.service.save(centro);
        return new ResponseEntity<>(savedProduct, HttpStatus.CREATED);
    }
}