package sipe.controller.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

public class ProfesionalDTO {
	private String practicaProfesional;
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
	public String getPracticaProfesional() {
		return practicaProfesional;
	}

	public void setPracticaProfesional(String practicaProfesional) {
		this.practicaProfesional = practicaProfesional;
	}
	@Override
	public String toString() {
		return "ProfesionalDTO [practicaProfesional=" + practicaProfesional + ", nombre=" + nombre + ", apellido="
				+ apellido + ", dni=" + dni + "]";
	}

	
}
