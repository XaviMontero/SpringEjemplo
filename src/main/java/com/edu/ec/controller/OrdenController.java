package com.edu.ec.controller;

import java.net.URI;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.edu.ec.model.Orden;
import com.edu.ec.service.impl.CosultaServiceImpl;
 

@RestController
@RequestMapping("/orden")
public class OrdenController {
	@Autowired 
	CosultaServiceImpl service; 
	
		@GetMapping
		public  ResponseEntity<List<Orden>> getOrden(){
			List<Orden> pacientes =service.list();
			return  new ResponseEntity<>(pacientes,HttpStatus.OK); 
		}
		@GetMapping("/{id}")
		public ResponseEntity<Orden>  getOrdenId( @PathVariable("id") Integer id ) {
			Orden paciente = service.getOne(id);
			 
			return  new ResponseEntity<>(paciente,HttpStatus.OK); 
		}
	 
		@PostMapping
		public ResponseEntity<Object> registrar(@Valid @RequestBody Orden paciente) {
		Orden pac = service.save(paciente);
			//pacientes/4
			URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(pac.getIdOrden()).toUri();
			return ResponseEntity.created(location).build();
		}
		
		@PutMapping
		public ResponseEntity<Orden> updateOrden (@Valid @RequestBody Orden paciente) {
			Orden pacienteg =service.update(paciente); 
			
			 return new ResponseEntity<>(pacienteg,HttpStatus.CREATED); 
			
		}
		
		@DeleteMapping("/{id}")
		public ResponseEntity<Object>  deleteMaping( @PathVariable("id") Integer id ) {
			boolean estado = service.eliminar(id); 
			return  new ResponseEntity<>(estado,HttpStatus.OK); 
		}
}
