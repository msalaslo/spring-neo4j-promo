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

import com.msl.neo4j.promo.entity.Producto;
import com.msl.neo4j.promo.entity.Promocion;
import com.msl.neo4j.promo.service.ProductoService;


@RestController
@RequestMapping("/producto")
public class ProductoController {
	
	private static final Logger logger = LoggerFactory.getLogger(ProductoController.class);
	
	@Autowired
	ProductoService service;
	
	@GetMapping(path = "/findByid")
    public Optional<Producto> findByid(@RequestParam(value="id", required=false, defaultValue="0") Long id, Model model) {
        logger.debug("Buscando producto por id..." + id);
        return service.findByid(id);
    }
	
	@GetMapping(path = "/findByReferencia")
    public Iterable<Producto> findByReferencia(@RequestParam(value="referencia", required=false, defaultValue="0") String referencia, Model model) {
        logger.debug("Buscando producto por referencia..." + referencia);
        return service.findByReferencia(referencia);
    }
	
	@GetMapping(path = "/findByName")
    public Producto findByName(@RequestParam(value="name", required=false, defaultValue="0") String name, Model model) {
        logger.debug("Buscando producto por name..." + name);
        return service.findByName(name);
    }
	
	@GetMapping(path = "/findPromocionesById")
    public Iterable<Promocion> findPromocionesById(@RequestParam(value="id", required=false, defaultValue="0") Long id, Model model) {
        logger.debug("Buscando promociones por id..." + id);
        return service.findPromocionesById(id);
    }	
	
	@GetMapping(path = "/findPromocionesByReferencia")
    public Iterable<Promocion> findPromocionesByReferencia(@RequestParam(value="referencia", required=false, defaultValue="0") String referencia, Model model) {
        logger.debug("Buscando promociones por referencia..." + referencia);
        return service.findPromocionesByReferencia(referencia);
    }	
	
	@GetMapping(path = "/test")
    public Producto test(@RequestParam(value="referencia", required=false, defaultValue="0") String referencia, Model model) {
        logger.debug("Test...");
        return new Producto(referencia, "test");
    }
	
    @PostMapping(path = "/save")
    public ResponseEntity<Producto> save(@RequestBody Producto producto) {
    	Producto savedProduct = this.service.save(producto);
        return new ResponseEntity<>(savedProduct, HttpStatus.CREATED);
    }
    
	@GetMapping(path = "/add")
    public void add(@RequestParam(value="num", required=false, defaultValue="0") int num) {
        logger.debug("Añadiendo productos..." + num);
        service.add(num);
    }
	
	@GetMapping(path = "/findAllPromocionesById")
    public Iterable<Promocion> findAllPromocionesById(@RequestParam(value="id", required=false, defaultValue="0") String id, Model model) {
        logger.debug("Buscando TODAS promociones por id..." + id);
        return service.findAllPromocionesById(id);
    }	
}