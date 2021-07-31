package sipe.model;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import sipe.controller.dto.DisponibilidadHorariaDTO;

@Entity
@Table(name = "DisponibilidadHoraria")
public class DisponibilidadHoraria implements Guardable {

	private static final DateTimeFormatter formatter = DateTimeFormatter.ofPattern("EEE MMM dd yyyy HH:mm:ss 'GMT-0300 (Argentina Standard Time)'");
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	private LocalDateTime inicio;
	private LocalDateTime fin;
	@ManyToOne()
	private Profesional profesional;
	
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
	public Profesional getProfesional() {
		return profesional;
	}
	public void setProfesional(Profesional profesional) {
		this.profesional = profesional;
	}
	
	public DisponibilidadHorariaDTO toDTO() {
		DisponibilidadHorariaDTO dto = new DisponibilidadHorariaDTO();
		dto.setId(getId());
		dto.setInicio(getInicio().format(formatter));
		dto.setFin(getFin().format(formatter));
		dto.setProfesionalId(getProfesional().getId());
		return dto;
	}
	
	public static DisponibilidadHoraria fromDTO(DisponibilidadHorariaDTO dto, Profesional profesional) {
		DisponibilidadHoraria practicaProfesional = new DisponibilidadHoraria();
		practicaProfesional.setId(dto.getId());
		practicaProfesional.setInicio(LocalDateTime.parse(dto.getInicio(), formatter));
		practicaProfesional.setFin(LocalDateTime.parse(dto.getFin(), formatter));
		practicaProfesional.setProfesional(profesional);
		return practicaProfesional;
	}

}
