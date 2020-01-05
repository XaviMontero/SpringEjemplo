package com.edu.ec.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.edu.ec.model.Examen;
import com.edu.ec.repo.IExamenRepo;
import com.edu.ec.service.ICrud;

@Service
public class ExamenServiceImpl implements ICrud<Examen> {

	@Autowired 
	private IExamenRepo repo; 
	
	@Override
	public Examen save(Examen obj) { 
		return repo.save(obj);
	}

	@Override
	public Examen update(Examen obj) {
		// TODO Auto-generated method stub
		return repo.save(obj);
	}

	@Override
	public List<Examen> list() {
		// TODO Auto-generated method stub
		return repo.findAll();
	}

	@Override
	public boolean eliminar(Integer id) {
		// TODO Auto-generated method stub
		repo.deleteById(id);
		return true; 
	}

	@Override
	public Examen getOne(Integer id) {

		return  repo.getOne(id);
	}

}