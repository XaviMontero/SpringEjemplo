package com.edu.ec.service.impl;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.edu.ec.model.Orden;
import com.edu.ec.repo.IOrdenRepo;
import com.edu.ec.service.ICrud;
@Service
public class CosultaServiceImpl implements ICrud<Orden> {

	@Autowired 
	private IOrdenRepo repo; 
	
	@Transactional
	@Override
	public Orden save(Orden obj) { 
		Orden s =repo.save(obj);
		
		return s;
	}

	@Override
	public Orden update(Orden obj) {
		// TODO Auto-generated method stub
		return repo.save(obj);
	}

	@Override
	public List<Orden> list() {
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
	public Orden getOne(Integer id) {

		return  repo.getOne(id);
	}

}
