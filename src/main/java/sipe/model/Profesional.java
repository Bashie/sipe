package sipe.model;

import java.util.List;
import java.util.Objects;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

import sipe.controller.dto.ProfesionalDTO;

@Entity
@Table(name = "Profesional")
@PrimaryKeyJoinColumn(name = "dni")
public class Profesional extends Persona {
	private String areaDesarrollo;
	
	@OneToMany(cascade = CascadeType.ALL)
	private List<PracticaProfesional> practicasProfesionales;
	@OneToMany(cascade = CascadeType.ALL)
	private List<DisponibilidadHoraria> disponibilidadesHorarias;
	
	public List<PracticaProfesional> getPracticasProfesionales() {
		return practicasProfesionales;
	}

	public void setPracticasProfesionales(List<PracticaProfesional> practicasProfesionales) {
		this.practicasProfesionales = practicasProfesionales;
	}

	public String getAreaDesarrollo() {
		return areaDesarrollo;
	}

	public void setAreaDesarrollo(String areaDesarrollo) {
		this.areaDesarrollo = areaDesarrollo;
	}

	public List<DisponibilidadHoraria> getDisponibilidadesHorarias() {
		return disponibilidadesHorarias;
	}

	public void setDisponibilidadesHorarias(List<DisponibilidadHoraria> disponibilidadesHorarias) {
		this.disponibilidadesHorarias = disponibilidadesHorarias;
	}

	@Override
	public String toString() {
		return "Profesional [areaDesarrollo=" + areaDesarrollo + ", getNombre()=" + getNombre() + ", getApellido()="
				+ getApellido() + ", getDni()=" + getDni() + "]";
	}
	
	public ProfesionalDTO toDTO() {
		ProfesionalDTO dto = new ProfesionalDTO();
		dto.setDni(getDni());
		dto.setApellido(getApellido());
		dto.setNombre(getNombre());
		dto.setAreaDesarrollo(getAreaDesarrollo());
		dto.setEmail(getEmail());
		return dto;
	}
	
	public static Profesional fromDTO(ProfesionalDTO dto) {
		Profesional profesional = new Profesional();
		profesional.setNombre(dto.getNombre());
		profesional.setApellido(dto.getApellido());
		profesional.setDni(dto.getDni());
		profesional.setAreaDesarrollo(dto.getAreaDesarrollo());
		profesional.setEmail(dto.getEmail());
		return profesional;
	}
}
