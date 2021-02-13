package sipe.controller.model;

public class Profesional extends Usuario {
	private PracticaProfesional practicaProfesional;

	public PracticaProfesional getPracticaProfesional() {
		return practicaProfesional;
	}

	public void setPracticaProfesional(PracticaProfesional practicaProfesional) {
		this.practicaProfesional = practicaProfesional;
	}

	@Override
	public String toString() {
		return "Profesional [practicaProfesional=" + practicaProfesional + ", parent=" + super.toString() + "]";
	}
	
}
