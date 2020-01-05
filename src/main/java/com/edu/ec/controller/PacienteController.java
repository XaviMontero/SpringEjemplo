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

import com.edu.ec.model.Paciente;
import com.edu.ec.service.impl.PacienteServiceImpl;

@RestController
@RequestMapping("/paciente")
public class PacienteController {
	 
	@Autowired 
	PacienteServiceImpl service; 
	
		@GetMapping
		public  ResponseEntity<List<Paciente>> getPaciente(){
			List<Paciente> pacientes =service.list();
			return  new ResponseEntity<>(pacientes,HttpStatus.OK); 
		}
		@GetMapping("/{cedula}")
		public ResponseEntity<Paciente>  getPacienteId( @PathVariable("cedula") String id ) {
			Paciente paciente = service.getOne(id);
			if (paciente.getCedula()==null) {
				//throw new Ex("El paciete no existe"); 
			}
			return  new ResponseEntity<>(paciente,HttpStatus.OK); 
		}
	 
		@PostMapping
		public ResponseEntity<Object> registrar(@Valid @RequestBody Paciente paciente) {
		Paciente pac = service.save(paciente);
			//pacientes/4
			URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(pac.getCedula()).toUri();
			return ResponseEntity.created(location).build();
		}
		
		@PutMapping
		public ResponseEntity<Paciente> updatePaciente (@Valid @RequestBody Paciente paciente) {
			Paciente pacienteg =service.update(paciente); 
			
			 return new ResponseEntity<>(pacienteg,HttpStatus.CREATED); 
			
		}
		
		@DeleteMapping("/{cedula}")
		public ResponseEntity<Object>  deleteMaping( @PathVariable("cedula") String id ) {
			Paciente paciente = service.getOne(id);
			if (paciente.getCedula()==null) {
				//throw new MitocodeException("El paciete no existe"); 
			}
			boolean estado = service.eliminar(id); 
			return  new ResponseEntity<>(estado,HttpStatus.OK); 
		}
}
