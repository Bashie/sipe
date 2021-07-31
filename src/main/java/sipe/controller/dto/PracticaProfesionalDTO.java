package sipe.controller.dto;

import java.io.Serializable;

public class PracticaProfesionalDTO implements Serializable {

	private static final long serialVersionUID = 8559217347806576065L;
	private Integer id;
	private Integer diaSemana;
	private String inicio;
	private String fin;
	private String profesional;
	private Integer profesionalId;
	private String areaDesarrollo;
	private Integer tutorDni;
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public Integer getDiaSemana() {
		return diaSemana;
	}
	public void setDiaSemana(Integer diaSemana) {
		this.diaSemana = diaSemana;
	}
	public String getInicio() {
		return inicio;
	}
	public void setInicio(String inicio) {
		this.inicio = inicio;
	}
	public String getFin() {
		return fin;
	}
	public void setFin(String fin) {
		this.fin = fin;
	}
	public String getProfesional() {
		return profesional;
	}
	public void setProfesional(String profesional) {
		this.profesional = profesional;
	}
	
	public Integer getProfesionalId() {
		return profesionalId;
	}
	public void setProfesionalId(Integer profesionalId) {
		this.profesionalId = profesionalId;
	}
	
	public Integer getTutorDni() {
		return tutorDni;
	}
	public void setTutorDni(Integer tutorDni) {
		this.tutorDni = tutorDni;
	}
	
	public String getAreaDesarrollo() {
		return areaDesarrollo;
	}
	public void setAreaDesarrollo(String areaDesarrollo) {
		this.areaDesarrollo = areaDesarrollo;
	}
	
}
