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
	private LocalDateTime inicio;
	private LocalDateTime fin;
	@ManyToOne()
	private PracticaProfesional practicaProfesional;
	private Boolean confirmado = false;
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public LocalDateTime getInicio() {
		return inicio;
	}
	public void setInicio(LocalDateTime inicio) {
		this.inicio = inicio;
	}
	public LocalDateTime getFin() {
		return fin;
	}
	public void setFin(LocalDateTime fin) {
		this.fin = fin;
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
		return "Turno [id=" + id + ", inicio=" + inicio + ", fin=" + fin + ", practicaProfesional=" + practicaProfesional
				+ ", confirmado=" + confirmado + "]";
	}
	
	public TurnoDTO toDTO() {
		TurnoDTO dto = new TurnoDTO();
		dto.setId(getId());
		dto.setFin(getFin().format(formatter));
		dto.setInicio(getInicio().format(formatter));
		dto.setConfirmado(getConfirmado());
		dto.setPracticaProfesional(getPracticaProfesional().toDTO());
		dto.setPracticaProfesionalId(getPracticaProfesional().getId());
		return dto;
	}
	
	public static Turno fromDTO(TurnoDTO dto, PracticaProfesional practicaProfesional) {
		Turno turno = new Turno();
		turno.setId(dto.getId());
		turno.setFin(LocalDateTime.parse(dto.getFin(), formatter));
		turno.setInicio(LocalDateTime.parse(dto.getInicio(), formatter));
		turno.setConfirmado(dto.getConfirmado());
		turno.setPracticaProfesional(practicaProfesional);
		return turno;
	}
}
