package sipe.model;

public class Usuario {
	
	private String login;
	private String encryptedPassword;
	private Boolean admin = false;
	private Persona persona;
	
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
	public Boolean isAdmin() {
		return admin;
	}
	public void setAdmin(Boolean admin) {
		this.admin = admin;
	}
	public Persona getPersona() {
		return persona;
	}
	public void setPersona(Persona persona) {
		this.persona = persona;
	}
	@Override
	public String toString() {
		return "Usuario [login=" + login + ", encryptedPassword=" + encryptedPassword + ", parent="	+ super.toString() + "]";
	}
}
