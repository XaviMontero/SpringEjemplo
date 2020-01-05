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

import com.edu.ec.model.Medico;
import com.edu.ec.service.impl.MedicoServiceImpl;

@RestController
@RequestMapping("/medico")
public class MedicoController {
	 
	@Autowired 
	MedicoServiceImpl service; 
	
		@GetMapping
		public  ResponseEntity<List<Medico>> getMedico(){
			List<Medico> Medicos =service.list();
			return  new ResponseEntity<>(Medicos,HttpStatus.OK); 
		}
		@GetMapping("/{cedula}")
		public ResponseEntity<Medico>  getMedicoId( @PathVariable("cedula") String id ) {
			Medico Medico = service.getOne(id);
			if (Medico.getCedulaMedico()==null) {
				//throw new Ex("El paciete no existe"); 
			}
			return  new ResponseEntity<>(Medico,HttpStatus.OK); 
		}
	 
		@PostMapping
		public ResponseEntity<Object> registrar(@Valid @RequestBody Medico Medico) {
		Medico pac = service.save(Medico);
			//Medicos/4
			URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(pac.getCedulaMedico()).toUri();
			return ResponseEntity.created(location).build();
		}
		
		@PutMapping
		public ResponseEntity<Medico> updateMedico (@Valid @RequestBody Medico Medico) {
			Medico Medicog =service.update(Medico); 
			
			 return new ResponseEntity<>(Medicog,HttpStatus.CREATED); 
			
		}
		
		@DeleteMapping("/{cedula}")
		public ResponseEntity<Object>  deleteMaping( @PathVariable("cedula") String id ) {
			Medico Medico = service.getOne(id);
			if (Medico.getCedulaMedico()==null) {
				//throw new MitocodeException("El paciete no existe"); 
			}
			boolean estado = service.eliminar(id); 
			return  new ResponseEntity<>(estado,HttpStatus.OK); 
		}
}
