package com.edu.ec.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.edu.ec.model.Paciente;
import com.edu.ec.repo.IPacienteRepo;
import com.edu.ec.service.ICrudP;
 
@Service
public class PacienteServiceImpl implements ICrudP<Paciente> {

	@Autowired 
	private IPacienteRepo repo; 
	
	@Override
	public Paciente save(Paciente obj) { 
		return repo.save(obj);
	}

	@Override
	public Paciente update(Paciente obj) {
		// TODO Auto-generated method stub
		return repo.save(obj);
	}

	@Override
	public List<Paciente> list() {
		// TODO Auto-generated method stub
		return repo.findAll();
	}

	@Override
	public boolean eliminar(String id) {
		// TODO Auto-generated method stub
		repo.deleteById(id);
		return true; 
	}

	@Override
	public Paciente getOne(String id) {

		return  repo.getOne(id);
	}

}
