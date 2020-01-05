package com.edu.ec.model;

import java.time.LocalDate;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ForeignKey;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table
public class Paciente {
	@Id
	private String cedula;
	@Column(name = "nombre", nullable = false, length = 50)
	private String nombre;
	@Column(name = "apellido", nullable = false, length = 50)
	private String apellido;
	@Column(name = "direccion", nullable = false, length = 50)
	private String direccion;
	@Column(name = "telefono", nullable = false, length = 10)
	private String telefono;
	@Column(name = "fechaNcimiento")
	private LocalDate fechaNcimiento;
	@Column(name = "peso")
	private Double peso;
	@Column(name = "edad")
	private int edad;
 
	@ManyToOne
	@JoinColumn(name = "id_genero", nullable = false, foreignKey = @ForeignKey(name = "FK_genero_paciente"))
	private Genero genero;
    
	public Paciente() {
		super();
	}

	public String getCedula() {
		return cedula;
	}

	public void setCedula(String cedula) {
		this.cedula = cedula;
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

	public LocalDate getFechaNcimiento() {
		return fechaNcimiento;
	}

	public void setFechaNcimiento(LocalDate fechaNcimiento) {
		this.fechaNcimiento = fechaNcimiento;
	}

	public Double getPeso() {
		return peso;
	}

	public void setPeso(Double peso) {
		this.peso = peso;
	}

	public int getEdad() {
		return edad;
	}

	public void setEdad(int edad) {
		this.edad = edad;
	}

	public Genero getGenero() {
		return genero;
	}

	public void setGenero(Genero genero) {
		this.genero = genero;
	}

}
