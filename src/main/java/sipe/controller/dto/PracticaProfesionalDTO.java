package sipe.controller.dto;

import java.io.Serializable;

public class PracticaProfesionalDTO implements Serializable {

	private static final long serialVersionUID = 8559217347806576065L;
	private Integer id;
	private Integer dayOfWeek;
	private String startTime;
	private String endTime;
	private String profesional;
	private Integer profesionalId;
	private String areaDesarrollo;
	private Integer tutorDni;
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public Integer getDayOfWeek() {
		return dayOfWeek;
	}
	public void setDayOfWeek(Integer dayOfWeek) {
		this.dayOfWeek = dayOfWeek;
	}
	public String getStartTime() {
		return startTime;
	}
	public void setStartTime(String startTime) {
		this.startTime = startTime;
	}
	public String getEndTime() {
		return endTime;
	}
	public void setEndTime(String endTime) {
		this.endTime = endTime;
	}
	public String getProfesional() {
		return profesional;
	}
	public void setProfesional(String profesional) {
		this.profesional = profesional;
	}
	
	public Integer getProfesionalId() {
		return profesionalId;
	}
	public void setProfesionalId(Integer profesionalId) {
		this.profesionalId = profesionalId;
	}
	
	public Integer getTutorDni() {
		return tutorDni;
	}
	public void setTutorDni(Integer tutorDni) {
		this.tutorDni = tutorDni;
	}
	
	public String getAreaDesarrollo() {
		return areaDesarrollo;
	}
	public void setAreaDesarrollo(String areaDesarrollo) {
		this.areaDesarrollo = areaDesarrollo;
	}
	@Override
	public String toString() {
		return "PracticaProfesionalDTO [id=" + id + ", dayOfWeek=" + dayOfWeek + ", startTime=" + startTime
				+ ", endTime=" + endTime + ", profesional=" + profesional + "]";
	}
	
}
