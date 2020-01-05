package com.edu.ec.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.edu.ec.model.Medico;
import com.edu.ec.repo.IMedicoRepo;
import com.edu.ec.service.ICrudP;
@Service
public class MedicoServiceImpl implements ICrudP<Medico> {

	@Autowired 
	private IMedicoRepo repo; 
	
	@Override
	public Medico save(Medico obj) { 
		return repo.save(obj);
	}

	@Override
	public Medico update(Medico obj) {
		// TODO Auto-generated method stub
		return repo.save(obj);
	}

	@Override
	public List<Medico> list() {
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
	public Medico getOne(String id) {

		return  repo.getOne(id);
	}

}
