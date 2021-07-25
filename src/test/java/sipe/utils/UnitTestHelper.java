package sipe.utils;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import sipe.controller.dto.PracticaProfesionalDTO;
import sipe.controller.dto.ProfesionalDTO;
import sipe.controller.dto.SesionDTO;
import sipe.controller.dto.TurnoDTO;

public class UnitTestHelper {

	private static final DateTimeFormatter formatter = DateTimeFormatter
			.ofPattern("EEE MMM dd yyyy HH:mm:ss 'GMT-0300 (Argentina Standard Time)'");

	public static final String INICIO = LocalDateTime.now().format(formatter);
	public static final String FIN = LocalDateTime.now().format(formatter);
	public static final Integer PRACTICA_ID = 1;
	public static final Integer TURNO_ID = 2;
	public static final Integer SESION_ID = 3;
	public static final Integer DIA_SEMANA = 1;
	public static final String PROFESIONAL_NOMBRE = "Juan";
	public static final String PROFESIONAL_APELLIDO = "Perez";
	public static final Integer PROFESIONAL_DNI = 33056168;
	public static final String AREA_DESARROLLO = "Terapeuta";
	public static final Integer PROFESIONAL_ID = 5;
	public static final Integer TUTOR_DNI = 30591745;
	public static final String PRACTICA_FIN = LocalDateTime.now().format(DateTimeFormatter.ISO_TIME);
	public static final String PRACTICA_INCIO = LocalDateTime.now().format(DateTimeFormatter.ISO_TIME);
	public static final String MAIL = "pepe@pepe.com";
	public static final String NOTAS = "Algunas notas";
	
	public static TurnoDTO getTurnoDto() {
		TurnoDTO turno = new TurnoDTO();
		turno.setEnd(FIN);
		turno.setConfirmado(false);
		turno.setPracticaProfesionalId(PRACTICA_ID);
		turno.setStart(INICIO);
		turno.setId(TURNO_ID);
		return turno;
	}

	public static PracticaProfesionalDTO getPracticaProfesionalDto() {
		PracticaProfesionalDTO practicaProfesional = new PracticaProfesionalDTO();
		practicaProfesional.setDayOfWeek(DIA_SEMANA);
		practicaProfesional.setStartTime(PRACTICA_INCIO);
		practicaProfesional.setEndTime(PRACTICA_FIN);
		practicaProfesional.setProfesionalId(PROFESIONAL_ID);
		practicaProfesional.setTutorDni(TUTOR_DNI);
		practicaProfesional.setId(PRACTICA_ID);
		return practicaProfesional;
	}
	
	public static ProfesionalDTO getProfesionalDto() {
		ProfesionalDTO profesional = new ProfesionalDTO();
		profesional.setNombre(PROFESIONAL_NOMBRE);
		profesional.setApellido(PROFESIONAL_APELLIDO);
		profesional.setDni(PROFESIONAL_DNI);
		profesional.setAreaDesarrollo(AREA_DESARROLLO);
		return profesional;
	}
	
	public static SesionDTO getSesionDto() {
		SesionDTO sesion = new SesionDTO();
		sesion.setEnd(FIN);
		sesion.setId(SESION_ID);
		sesion.setNotas(NOTAS);
		sesion.setStart(INICIO);
		return sesion;
	}
}
