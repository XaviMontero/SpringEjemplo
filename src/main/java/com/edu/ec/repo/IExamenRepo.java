package com.edu.ec.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.edu.ec.model.Examen;
 
@Repository
public interface IExamenRepo extends JpaRepository<Examen,Integer>{

}
