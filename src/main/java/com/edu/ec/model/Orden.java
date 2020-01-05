package com.edu.ec.model;

import java.time.LocalDate;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.ForeignKey;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

 
@Entity
@Table
public class Orden {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer idOrden;
	@Column
	private LocalDate fechaEmision;
	@Column
	private LocalDate fechaEntrega;
 
	@ManyToOne
	@JoinColumn(name = "cedula", nullable = false, foreignKey = @ForeignKey(name = "FK_Medico_orden"))
	private Paciente paciente;
 
	@ManyToOne
	@JoinColumn(name = "cedula_medico", nullable = false, foreignKey = @ForeignKey(name = "FK_Medico_orden"))
	private Medico medico;

    
    @ManyToMany(fetch = FetchType.EAGER)
	@JoinTable(name = "orden_examen", joinColumns = @JoinColumn(name = "id_orden", referencedColumnName = "idOrden"), inverseJoinColumns = @JoinColumn(name = "id_examen", referencedColumnName = "idExamen"))
    private List<Examen> examens; 

	public List<Examen> getExamens() {
		return examens;
	}

	public void setExamens(List<Examen> examens) {
		this.examens = examens;
	}

	public void setIdOrden(Integer idOrden) {
		this.idOrden = idOrden;
	}

	public Orden() {
		super();
	}

	public int getIdOrden() {
		return idOrden;
	}

	public void setIdOrden(int idOrden) {
		this.idOrden = idOrden;
	}

	public LocalDate getFechaEmision() {
		return fechaEmision;
	}

	public void setFechaEmision(LocalDate fechaEmision) {
		this.fechaEmision = fechaEmision;
	}

	public LocalDate getFechaEntrega() {
		return fechaEntrega;
	}

	public void setFechaEntrega(LocalDate fechaEntrega) {
		this.fechaEntrega = fechaEntrega;
	}

	public Paciente getPaciente() {
		return paciente;
	}

	public void setPaciente(Paciente paciente) {
		this.paciente = paciente;
	}

	public Medico getMedico() {
		return medico;
	}

	public void setMedico(Medico medico) {
		this.medico = medico;
	}



}
