package sipe.controller.dto;

public class TurnoDTO {
	private Integer id;
	private String start;
	private String end;
	private PracticaProfesionalDTO practicaProfesional;
	private Integer practicaProfesionalId;
	private Boolean confirmado = false;
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getStart() {
		return start;
	}
	public void setStart(String start) {
		this.start = start;
	}
	public String getEnd() {
		return end;
	}
	public void setEnd(String end) {
		this.end = end;
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
	@Override
	public String toString() {
		return "TurnoDTO [id=" + id + ", start=" + start + ", end=" + end + ", practicaProfesional="
				+ practicaProfesional + ", practicaProfesionalId=" + practicaProfesionalId + ", confirmado="
				+ confirmado + "]";
	}
}
