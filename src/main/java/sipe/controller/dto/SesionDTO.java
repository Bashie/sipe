package sipe.controller.dto;

public class SesionDTO {
	private String notas;
	private String fin;
	private String inicio;
	private Integer id;
	private PracticaProfesionalDTO practicaProfesional;
	private Integer practicaProfesionalId;
	public String getNotas() {
		return notas;
	}
	public void setNotas(String notas) {
		this.notas = notas;
	}
	public String getFin() {
		return fin;
	}
	public void setFin(String fin) {
		this.fin = fin;
	}
	public String getInicio() {
		return inicio;
	}
	public void setInicio(String inicio) {
		this.inicio = inicio;
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public PracticaProfesionalDTO getPracticaProfesional() {
		return practicaProfesional;
	}
	public void setPracticaProfesional(PracticaProfesionalDTO practicaProfesional) {
		this.practicaProfesional = practicaProfesional;
	}
	
	public Integer getPracticaProfesionalId() {
		return practicaProfesionalId;
	}
	public void setPracticaProfesionalId(Integer practicaProfesionalId) {
		this.practicaProfesionalId = practicaProfesionalId;
	}
}
