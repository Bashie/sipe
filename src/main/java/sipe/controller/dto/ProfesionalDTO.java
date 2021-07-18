package sipe.controller.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

public class ProfesionalDTO {
	private String areaDesarrollo;
	private String nombre;
	private String apellido;
	private Integer dni;
	
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
	@JsonProperty("id")
	public Integer getDni() {
		return dni;
	}
	@JsonProperty("id")
	public void setDni(Integer dni) {
		this.dni = dni;
	}
	public String getAreaDesarrollo() {
		return areaDesarrollo;
	}

	public void setAreaDesarrollo(String areaDesarrollo) {
		this.areaDesarrollo = areaDesarrollo;
	}
	@Override
	public String toString() {
		return "ProfesionalDTO [areaDesarrollo=" + areaDesarrollo + ", nombre=" + nombre + ", apellido="
				+ apellido + ", dni=" + dni + "]";
	}

	
}
