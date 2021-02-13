package sipe.controller.model;

public class Usuario extends Persona {
	
	private String login;
	private String encryptedPassword;
	
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
		return "Usuario [login=" + login + ", encryptedPassword=" + encryptedPassword + ", parent="	+ super.toString() + "]";
	}
}
