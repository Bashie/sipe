package sipe.controller.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

public class UsuarioDTO {
	
	private String login;
	private String encryptedPassword;
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
	public String getLogin() {
		return login;
	}
	public void setLogin(String login) {
		this.login = login;
	}
	public String getEncryptedPassword() {
		return encryptedPassword;
	}
	public void setEncryptedPassword(String encryptedPassword) {
		this.encryptedPassword = encryptedPassword;
	}
	@Override
	public String toString() {
		return "Usuario [login=" + login + ", encryptedPassword=" + encryptedPassword + ", nombre=" + nombre
				+ ", apellido=" + apellido + ", dni=" + dni + "]";
	}

}
