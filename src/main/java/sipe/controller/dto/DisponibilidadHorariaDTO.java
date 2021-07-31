package sipe.controller.dto;

import java.io.Serializable;

public class DisponibilidadHorariaDTO implements Serializable {
	private static final long serialVersionUID = 7864518569578130616L;

	private Integer id;
	private String inicio;
	private String fin;
	private Integer profesionalId;
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
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
	public Integer getProfesionalId() {
		return profesionalId;
	}
	public void setProfesionalId(Integer profesionalId) {
		this.profesionalId = profesionalId;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
		
}
