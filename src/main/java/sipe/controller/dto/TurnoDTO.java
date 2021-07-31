package sipe.controller.dto;

public class TurnoDTO extends BaseDTO {
	private Integer id;
	private String inicio;
	private String fin;
	private PracticaProfesionalDTO practicaProfesional;
	private Integer practicaProfesionalId;
	private Boolean confirmado = false;
	
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
	public Boolean getConfirmado() {
		return confirmado;
	}
	public void setConfirmado(Boolean confirmado) {
		this.confirmado = confirmado;
	}
}
