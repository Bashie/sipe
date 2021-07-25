package sipe.model;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import sipe.controller.dto.TurnoDTO;

@Entity
@Table(name = "Turno")
public class Turno implements Guardable{
	private static final DateTimeFormatter formatter = DateTimeFormatter.ofPattern("EEE MMM dd yyyy HH:mm:ss 'GMT-0300 (Argentina Standard Time)'");
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	private LocalDateTime start;
	private LocalDateTime end;
	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "practicaProfesional")
	private PracticaProfesional practicaProfesional;
	private Boolean confirmado = false;
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public LocalDateTime getStart() {
		return start;
	}
	public void setStart(LocalDateTime start) {
		this.start = start;
	}
	public LocalDateTime getEnd() {
		return end;
	}
	public void setEnd(LocalDateTime end) {
		this.end = end;
	}
	public PracticaProfesional getPracticaProfesional() {
		return practicaProfesional;
	}
	public void setPracticaProfesional(PracticaProfesional practicaProfesional) {
		this.practicaProfesional = practicaProfesional;
	}
	public Boolean getConfirmado() {
		return confirmado;
	}
	public void setConfirmado(Boolean confirmado) {
		this.confirmado = confirmado;
	}
	@Override
	public String toString() {
		return "Turno [id=" + id + ", start=" + start + ", end=" + end + ", practicaProfesional=" + practicaProfesional
				+ ", confirmado=" + confirmado + "]";
	}
	
	public TurnoDTO toDTO() {
		TurnoDTO dto = new TurnoDTO();
		dto.setId(getId());
		dto.setEnd(getEnd().format(formatter));
		dto.setStart(getStart().format(formatter));
		dto.setConfirmado(getConfirmado());
		dto.setPracticaProfesional(getPracticaProfesional().toDTO());
		dto.setPracticaProfesionalId(getPracticaProfesional().getId());
		return dto;
	}
	
	public static Turno fromDTO(TurnoDTO dto, PracticaProfesional practicaProfesional) {
		Turno turno = new Turno();
		turno.setId(dto.getId());
		turno.setEnd(LocalDateTime.parse(dto.getEnd(), formatter));
		turno.setStart(LocalDateTime.parse(dto.getStart(), formatter));
		turno.setConfirmado(dto.getConfirmado());
		turno.setPracticaProfesional(practicaProfesional);
		return turno;
	}
}
