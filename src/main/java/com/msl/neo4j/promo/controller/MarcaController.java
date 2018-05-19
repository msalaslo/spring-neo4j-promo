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

import com.msl.neo4j.promo.entity.Marca;
import com.msl.neo4j.promo.entity.Promocion;
import com.msl.neo4j.promo.service.MarcaService;


@RestController
@RequestMapping("/marca")
public class MarcaController {
	
	Logger logger = LoggerFactory.getLogger(MarcaController.class.getName());
	
	@Autowired
	MarcaService service;
	
//	@GetMapping(path = "/findByid")
//    public Marca findByid(@RequestParam(value="id", required=false, defaultValue="0") String id, Model model) {
//        logger.debug("Buscando marca por id...");
//        return service.findByid(id);
//    }
	
	@GetMapping(path = "/findByCmarmuma")
    public Iterable<Marca> findByCmarmuma(@RequestParam(value="cmarmuma", required=false, defaultValue="0") String cmarmuma, Model model) {
        logger.debug("Buscando marca por cmarmuma...");
        return service.findByCmarmuma(cmarmuma);
    }
	
	@GetMapping(path = "/findPromocionesById")
    public Iterable<Promocion> findPromocionesById(@RequestParam(value="id", required=false, defaultValue="0") String id, Model model) {
        logger.debug("Buscando promociones por id...");
        return service.findPromocionesById(id);
    }	
	
	@GetMapping(path = "/findPromocionesByCmarmuma")
    public Iterable<Promocion> findPromocionesByCmarmuma(@RequestParam(value="cmarmuma", required=false, defaultValue="0") String cmarmuma, Model model) {
        logger.debug("Buscando promociones por cmarmuma...");
        return service.findPromocionesByCmarmuma(cmarmuma);
    }	
		
    @PostMapping(path = "/save")
    public ResponseEntity<Marca> save(@RequestBody Marca marca) {
    	Marca savedProduct = this.service.save(marca);
        return new ResponseEntity<>(savedProduct, HttpStatus.CREATED);
    }
}