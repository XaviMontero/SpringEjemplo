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

import com.edu.ec.model.Examen;
import com.edu.ec.service.impl.ExamenServiceImpl;

@RestController
@RequestMapping("/examen")
public class ExamenController {
	@Autowired 
	ExamenServiceImpl service; 
	
		@GetMapping
		public  ResponseEntity<List<Examen>> getExamen(){
			List<Examen> pacientes =service.list();
			return  new ResponseEntity<>(pacientes,HttpStatus.OK); 
		}
		@GetMapping("/{id}")
		public ResponseEntity<Examen>  getExamenId( @PathVariable("id") Integer id ) {
			Examen paciente = service.getOne(id);
			if (paciente.getIdExamen()==null) {
				//throw new Ex("El paciete no existe"); 
			}
			return  new ResponseEntity<>(paciente,HttpStatus.OK); 
		}
	 
		@PostMapping
		public ResponseEntity<Object> registrar(@Valid @RequestBody Examen paciente) {
		Examen pac = service.save(paciente);
			//pacientes/4
			URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(pac.getIdExamen()).toUri();
			return ResponseEntity.created(location).build();
		}
		
		@PutMapping
		public ResponseEntity<Examen> updateExamen (@Valid @RequestBody Examen paciente) {
			Examen pacienteg =service.update(paciente); 
			
			 return new ResponseEntity<>(pacienteg,HttpStatus.CREATED); 
			
		}
		
		@DeleteMapping("/{id}")
		public ResponseEntity<Object>  deleteMaping( @PathVariable("id") Integer id ) {
			Examen paciente = service.getOne(id);
			if (paciente.getIdExamen()==null) {
				//throw new MitocodeException("El paciete no existe"); 
			}
			boolean estado = service.eliminar(id); 
			return  new ResponseEntity<>(estado,HttpStatus.OK); 
		}
}
