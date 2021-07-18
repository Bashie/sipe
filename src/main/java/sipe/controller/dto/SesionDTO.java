package sipe.controller.dto;

public class SesionDTO {
	private String notas;
	private String end;
	private String start;
	private Integer id;
	private PracticaProfesionalDTO practicaProfesional;
	private Integer practicaProfesionalId;
	public String getNotas() {
		return notas;
	}
	public void setNotas(String notas) {
		this.notas = notas;
	}
	public String getEnd() {
		return end;
	}
	public void setEnd(String end) {
		this.end = end;
	}
	public String getStart() {
		return start;
	}
	public void setStart(String start) {
		this.start = start;
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
	@Override
	public String toString() {
		return "SesionDTO [notas=" + notas + ", end=" + end + ", start=" + start + ", id=" + id
				+ ", practicaProfesional=" + practicaProfesional + "]";
	}

}
