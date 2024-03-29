package sipe.controller.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.google.gson.JsonObject;

public class UsuarioDTO {
	
	private String login;
	private String claveEncriptada;
	private String nombre;
	private String apellido;
	private Integer dni;
	private String email;
	
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
	public String getClaveEncriptada() {
		return claveEncriptada;
	}
	public void setClaveEncriptada(String claveEncriptada) {
		this.claveEncriptada = claveEncriptada;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public JsonObject toJson() {
		JsonObject json = new JsonObject();
		json.addProperty("nombre", nombre);
		json.addProperty("apellido", apellido);
		json.addProperty("dni", dni);
		json.addProperty("email", email);
		return json;
	}
}
