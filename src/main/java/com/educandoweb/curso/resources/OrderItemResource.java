package com.educandoweb.curso.resources;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.educandoweb.curso.entities.OrderItem;
import com.educandoweb.curso.services.OrderItemService;

@RestController
@RequestMapping(value = "/orderitems")
public class OrderItemResource {
	
	@Autowired
	public OrderItemService service;
	
	@GetMapping
	public ResponseEntity<List<OrderItem>> findAll(){
		List<OrderItem> list = service.findAll();
		return ResponseEntity.ok().body(list);
	}
	
	@GetMapping(value = "/{id}")
	public ResponseEntity<OrderItem> findById(@PathVariable Integer id){
		OrderItem obj = service.findyBuId(id);
		return ResponseEntity.ok().body(obj);
	}

}
