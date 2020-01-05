package com.edu.ec.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.edu.ec.model.Medico;
 
public interface IMedicoRepo  extends JpaRepository<Medico,String> {

}
