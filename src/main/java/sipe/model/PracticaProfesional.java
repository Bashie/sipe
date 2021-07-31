package sipe.model;

import java.time.DayOfWeek;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Objects;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import sipe.controller.dto.PracticaProfesionalDTO;

@Entity
@Table(name = "PracticaProfesional")
public class PracticaProfesional implements Guardable {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	private DayOfWeek diaSemana;
	private LocalTime inicio;
	private LocalTime fin;
	@ManyToOne()
	private Profesional profesional;
	@OneToMany(cascade = CascadeType.ALL, mappedBy = "practicaProfesional")
	private List<Sesion> sesiones;
	@ManyToOne()
	private Tutor tutor;
	@OneToMany(cascade = CascadeType.ALL, mappedBy = "practicaProfesional")
	private List<Turno> turnos;
	
	public List<Turno> getTurnos() {
		return turnos;
	}

	public void setTurnos(List<Turno> turnos) {
		this.turnos = turnos;
	}

	public Profesional getProfesional() {
		return profesional;
	}

	public void setProfesional(Profesional profesional) {
		this.profesional = profesional;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public DayOfWeek getDiaSemana() {
		return diaSemana;
	}

	public void setDiaSemana(DayOfWeek diaSemana) {
		this.diaSemana = diaSemana;
	}

	public LocalTime getInicio() {
		return inicio;
	}

	public void setInicio(LocalTime inicio) {
		this.inicio = inicio;
	}

	public LocalTime getFin() {
		return fin;
	}

	public void setFin(LocalTime fin) {
		this.fin = fin;
	}

	public List<Sesion> getSesiones() {
		return sesiones;
	}
	public void setSesiones(List<Sesion> sesiones) {
		this.sesiones = sesiones;
	}

	public Tutor getTutor() {
		return tutor;
	}

	public void setTutor(Tutor tutor) {
		this.tutor = tutor;
	}

	public PracticaProfesionalDTO toDTO() {
		PracticaProfesionalDTO dto = new PracticaProfesionalDTO();
		dto.setId(getId());
		dto.setInicio(getInicio().format(DateTimeFormatter.ISO_TIME));
		dto.setFin(getFin().format(DateTimeFormatter.ISO_TIME));
		dto.setProfesional(getProfesional().getApellido() + ", " + getProfesional().getNombre());
		dto.setProfesionalId(getProfesional().getDni());
		dto.setTutorDni(getTutor().getDni());
		dto.setDiaSemana(Objects.isNull(getDiaSemana()) ? 1 : getDiaSemana().getValue());
		dto.setAreaDesarrollo(getProfesional().getAreaDesarrollo());
		return dto;
	}
	
	public static PracticaProfesional fromDTO(PracticaProfesionalDTO dto, Profesional profesional, Tutor tutor) {
		PracticaProfesional practicaProfesional = new PracticaProfesional();
		practicaProfesional.setId(dto.getId());
		practicaProfesional.setInicio(LocalTime.parse(dto.getInicio(), DateTimeFormatter.ISO_TIME));
		practicaProfesional.setFin(LocalTime.parse(dto.getFin(), DateTimeFormatter.ISO_TIME));
		practicaProfesional.setProfesional(profesional);
		practicaProfesional.setTutor(tutor);
		practicaProfesional.setDiaSemana(DayOfWeek.of(dto.getDiaSemana()));
		return practicaProfesional;
	}
}
