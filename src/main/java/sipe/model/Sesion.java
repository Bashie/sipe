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
	private LocalDateTime start;
	private LocalDateTime end;
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "practicaProfesional")
	private PracticaProfesional practicaProfesional;
	private String notas;
	
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
		dto.setEnd(getEnd().format(formatter));
		dto.setStart(getStart().format(formatter));
		dto.setNotas(getNotas());
		dto.setPracticaProfesional(getPracticaProfesional().toDTO());
		dto.setPracticaProfesionalId(getPracticaProfesional().getId());
		return dto;
	}
	
	public static Sesion fromDTO(SesionDTO dto, PracticaProfesional practicaProfesional) {
		Sesion sesion = new Sesion();
		sesion.setId(dto.getId());
		System.out.println(LocalDateTime.now().format(formatter));
		sesion.setEnd(LocalDateTime.parse(dto.getEnd(), formatter));
		sesion.setStart(LocalDateTime.parse(dto.getStart(), formatter));
		sesion.setNotas(dto.getNotas());
		sesion.setPracticaProfesional(practicaProfesional);
		return sesion;
	}
}
