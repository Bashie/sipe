package sipe.model;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import sipe.controller.dto.SesionDTO;

@Entity
@Table(name = "Sesion")
public class Sesion implements Guardable {
	private static final DateTimeFormatter formatter = DateTimeFormatter.ofPattern("EEE MMM dd yyyy HH:mm:ss 'GMT-0300 (Argentina Standard Time)'");
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	private LocalDateTime inicio;
	private LocalDateTime fin;
	@OneToOne()
	private PracticaProfesional practicaProfesional;
	private String notas;
	
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

	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getNotas() {
		return notas;
	}
	public void setNotas(String notas) {
		this.notas = notas;
	}
	
	public PracticaProfesional getPracticaProfesional() {
		return practicaProfesional;
	}
	public void setPracticaProfesional(PracticaProfesional practicaProfesional) {
		this.practicaProfesional = practicaProfesional;
	}
	public SesionDTO toDTO() {
		SesionDTO dto = new SesionDTO();
		dto.setId(getId());
		dto.setFin(getFin().format(formatter));
		dto.setInicio(getInicio().format(formatter));
		dto.setNotas(getNotas());
		dto.setPracticaProfesional(getPracticaProfesional().toDTO());
		dto.setPracticaProfesionalId(getPracticaProfesional().getId());
		return dto;
	}
	
	public static Sesion fromDTO(SesionDTO dto, PracticaProfesional practicaProfesional) {
		Sesion sesion = new Sesion();
		sesion.setId(dto.getId());
		System.out.println(LocalDateTime.now().format(formatter));
		sesion.setFin(LocalDateTime.parse(dto.getFin(), formatter));
		sesion.setInicio(LocalDateTime.parse(dto.getInicio(), formatter));
		sesion.setNotas(dto.getNotas());
		sesion.setPracticaProfesional(practicaProfesional);
		return sesion;
	}
}
