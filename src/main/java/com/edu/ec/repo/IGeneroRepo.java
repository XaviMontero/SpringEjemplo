package com.edu.ec.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.edu.ec.model.Genero;

@Repository
public interface IGeneroRepo  extends JpaRepository<Genero,Integer> {

}
