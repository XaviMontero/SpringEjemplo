package com.edu.ec.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.edu.ec.model.Paciente;

@Repository
public interface IPacienteRepo extends JpaRepository<Paciente,String> {

}
