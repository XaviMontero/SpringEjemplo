package com.edu.ec.model;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;


@Entity
@Table
public class Genero {
	
 	@Id
 	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer idGenero; 
 	
    @Column(name = "nombre",  nullable = false, length = 50)
    private String nombre;
    @JsonIgnore
	@OneToMany(mappedBy = "genero",cascade = {CascadeType.ALL},orphanRemoval = true)
	private List<Paciente> pacientes;
    @JsonIgnore
	@OneToMany(mappedBy = "genero",cascade = {CascadeType.ALL},orphanRemoval = true)
	private List<Medico> medicos;
	public Genero() {
		super();
	}
	

	public List<Paciente> getPacientes() {
		return pacientes;
	}


	public void setPacientes(List<Paciente> pacientes) {
		this.pacientes = pacientes;
	}


	public Integer getIdGenero() {
		return idGenero;
	}

	public void setIdGenero(Integer idGenero) {
		this.idGenero = idGenero;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
    
}
