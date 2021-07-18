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
import javax.persistence.JoinColumn;
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
	private DayOfWeek dayOfWeek;
	private LocalTime startTime;
	private LocalTime endTime;
	@ManyToOne()
	private Profesional profesional;
	@OneToMany(cascade = CascadeType.ALL, mappedBy = "practicaProfesional")
	private List<Sesion> sesiones;
	@ManyToOne()
	private Tutor tutor;
	
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

	public DayOfWeek getDayOfWeek() {
		return dayOfWeek;
	}

	public void setDayOfWeek(DayOfWeek dayOfWeek) {
		this.dayOfWeek = dayOfWeek;
	}

	public LocalTime getStartTime() {
		return startTime;
	}

	public void setStartTime(LocalTime startTime) {
		this.startTime = startTime;
	}

	public LocalTime getEndTime() {
		return endTime;
	}

	public void setEndTime(LocalTime endTime) {
		this.endTime = endTime;
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
		dto.setStartTime(getStartTime().format(DateTimeFormatter.ISO_TIME));
		dto.setEndTime(getEndTime().format(DateTimeFormatter.ISO_TIME));
		dto.setProfesional(getProfesional().getApellido() + ", " + getProfesional().getNombre());
		dto.setProfesionalId(getProfesional().getDni());
		dto.setTutorDni(getTutor().getDni());
		dto.setDayOfWeek(Objects.isNull(getDayOfWeek()) ? 1 : getDayOfWeek().getValue());
		dto.setAreaDesarrollo(getProfesional().getAreaDesarrollo());
		return dto;
	}
	
	public static PracticaProfesional fromDTO(PracticaProfesionalDTO dto, Profesional profesional, Tutor tutor) {
		PracticaProfesional practicaProfesional = new PracticaProfesional();
		practicaProfesional.setId(dto.getId());
		practicaProfesional.setStartTime(LocalTime.parse(dto.getStartTime(), DateTimeFormatter.ISO_TIME));
		practicaProfesional.setEndTime(LocalTime.parse(dto.getEndTime(), DateTimeFormatter.ISO_TIME));
		practicaProfesional.setProfesional(profesional);
		practicaProfesional.setTutor(tutor);
		practicaProfesional.setDayOfWeek(DayOfWeek.of(dto.getDayOfWeek()));
		return practicaProfesional;
	}
}
