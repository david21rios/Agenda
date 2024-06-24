package com.rivaltec.agenda.models.entity;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.Date;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "agendas")
public class Agenda implements Serializable {

	// ID INT PRIMARY KEY AUTO_INCREMENT,
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	@Column(nullable = false)
	private String title;
	private String description;
	@Column(nullable = false, name = "fecha_inicio")
	private LocalDateTime fechaInicio;
	@Column(nullable = false, name = "fecha_fin")
	private LocalDateTime fechaFin;
	@Column(name = "recordatorio_activo")
	private boolean recordatorioActivo;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public LocalDateTime getFechaInicio() {
		return fechaInicio;
	}

	public void setFechaInicio(LocalDateTime fechaInicio) {
		this.fechaInicio = fechaInicio;
	}

	public LocalDateTime getFechaFin() {
		return fechaFin;
	}

	public void setFechaFin(LocalDateTime fechaFin) {
		this.fechaFin = fechaFin;
	}

	public boolean isRecordatorioActivo() {
		return recordatorioActivo;
	}

	public void setRecordatorioActivo(boolean recordatorioActivo) {
		this.recordatorioActivo = recordatorioActivo;
	}

	private static final long serialVersionUID = 1L;

}
