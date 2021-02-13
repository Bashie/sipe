package sipe.controller.model;

public class Tutor extends Usuario {
	private Persona hijo;

	public Persona getHijo() {
		return hijo;
	}

	public void setHijo(Persona hijo) {
		this.hijo = hijo;
	}

	@Override
	public String toString() {
		return "Tutor [hijo=" + hijo + ", parent=" + super.toString() + "]";
	}
	

}
