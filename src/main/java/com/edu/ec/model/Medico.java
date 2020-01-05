package com.edu.ec.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ForeignKey;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

 
@Entity
@Table
public class Medico {
	@Id
    private String cedulaMedico;
	@Column(name = "nombre", nullable = false, length = 50)
    private String nombre;
	@Column(name = "apellido", nullable = false, length = 50)
    private String apellido;
	@Column(name = "direccion", nullable = false, length = 50)
    private String direccion;
	@Column(name = "telefono", nullable = false, length = 10)
    private String telefono;
 
	@ManyToOne
	@JoinColumn(name = "id_genero", nullable = false, foreignKey = @ForeignKey(name = "FK_medico_genero"))
    private Genero genero;
    
	public Medico() {
		super();
	}
 
	public String getCedulaMedico() {
		return cedulaMedico;
	}

	public void setCedulaMedico(String cedulaMedico) {
		this.cedulaMedico = cedulaMedico;
	}

	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getApellido() {
		return apellido;
	}
	public void setApellido(String apellido) {
		this.apellido = apellido;
	}
	public String getDireccion() {
		return direccion;
	}
	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}
	public String getTelefono() {
		return telefono;
	}
	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}
	public Genero getGenero() {
		return genero;
	}
	public void setGenero(Genero genero) {
		this.genero = genero;
	}
    
}
