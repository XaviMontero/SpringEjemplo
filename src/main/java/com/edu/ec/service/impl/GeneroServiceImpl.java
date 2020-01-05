package com.edu.ec.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.edu.ec.model.Genero;
import com.edu.ec.repo.IGeneroRepo;
import com.edu.ec.service.ICrud;
@Service
public class GeneroServiceImpl implements ICrud<Genero> {

	@Autowired 
	private IGeneroRepo repo; 
	
	@Override
	public Genero save(Genero obj) { 
		return repo.save(obj);
	}

	@Override
	public Genero update(Genero obj) {
		// TODO Auto-generated method stub
		return repo.save(obj);
	}

	@Override
	public List<Genero> list() {
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
	public Genero getOne(Integer id) {

		return  repo.getOne(id);
	}

}
