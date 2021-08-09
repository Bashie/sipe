package sipe.service;

import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import sipe.controller.dto.TurnoDTO;
import sipe.dao.DisponibilidadHorariaDAO;
import sipe.dao.PracticaProfesionalDAO;
import sipe.dao.TurnoDAO;
import sipe.model.DisponibilidadHoraria;
import sipe.model.PracticaProfesional;
import sipe.model.Turno;
import sipe.service.exception.ErrorException;
import sipe.util.Mailer;

@Component
public class TurnoService {
	
	@Autowired
	private TurnoDAO turnoDAO;
	@Autowired
	private PracticaProfesionalDAO practicaProfesionalDao;
	@Autowired
	private Mailer mailer;
	@Autowired
	private DisponibilidadHorariaDAO disponibilidadHorariaDAO;
	
	public Turno save(TurnoDTO turnoDto) throws ErrorException {
		PracticaProfesional practicaProfesional = practicaProfesionalDao.findById(turnoDto.getPracticaProfesionalId());
		Turno turno = Turno.fromDTO(turnoDto, practicaProfesional);
		List<DisponibilidadHoraria> disponibilidad = disponibilidadHorariaDAO.findAllByProfesionalDeLaFecha(practicaProfesional.getProfesional().getId(), turno.getInicio());
		if(disponibilidad.isEmpty() || controlarDisponibilidad(turno, disponibilidad)) {
			return turnoDAO.save(turno);
		}
		throw new ErrorException("El profesional no dispone de horarios este día.");
	}
	
	private Boolean controlarDisponibilidad(Turno turno, List<DisponibilidadHoraria> disponibilidad) {
		for (DisponibilidadHoraria disponibilidadHoraria : disponibilidad) {
			if (disponibilidadHoraria.getInicio().isBefore(turno.getInicio()) && disponibilidadHoraria.getFin().isAfter(turno.getFin())) {
				return true;
			}
		}
		return false;
	}

	public List<TurnoDTO> getAllTurnosByPractica(Integer id) {
		return turnoDAO.findAllByPractica(id).stream().map(Turno::toDTO).collect(Collectors.toList());
	}
	
	public TurnoDTO delete(Integer id) {
		Turno turno = turnoDAO.findById(id);
		turnoDAO.delete(turno);
		return turno.toDTO();
	}

	public TurnoDTO confirmar(Integer id) {
		Turno turno = turnoDAO.findById(id);
		turno.setConfirmado(true);
		if(!Objects.isNull(turno.getPracticaProfesional().getProfesional().getEmail())) {
			mailer.sendMail(turno.getPracticaProfesional().getProfesional().getEmail(), "Su turno ha sido confirmado", mailer.getTurnoMessageBody(turno, true), null);
		}
		if(!Objects.isNull(turno.getPracticaProfesional().getTutor().getEmail())) {
			mailer.sendMail(turno.getPracticaProfesional().getTutor().getEmail(), "Su turno ha sido confirmado", mailer.getTurnoMessageBody(turno, true), null);
		}
		return turnoDAO.save(turno).toDTO();
	}

	public List<TurnoDTO> getAllTurnosByProfesional(Integer id) {
		List<PracticaProfesional> practicas = practicaProfesionalDao.findAllByProfesional(id);
		List<String> practicaIds = practicas.stream().map(item -> {return String.valueOf(item.getId());}).collect(Collectors.toList());
		return turnoDAO.findAllByProfesional(id, practicaIds).stream().map(Turno::toDTO).collect(Collectors.toList());
	}

	public TurnoDTO cancelar(Integer id) {
		Turno turno = turnoDAO.findById(id);
		turno.setConfirmado(false);
		if(!Objects.isNull(turno.getPracticaProfesional().getProfesional().getEmail())) {
			mailer.sendMail(turno.getPracticaProfesional().getProfesional().getEmail(), "Su turno ha sido cancelado", mailer.getTurnoMessageBody(turno, false), null);
		}
		if(!Objects.isNull(turno.getPracticaProfesional().getTutor().getEmail())) {
			mailer.sendMail(turno.getPracticaProfesional().getTutor().getEmail(), "Su turno ha sido cancelado", mailer.getTurnoMessageBody(turno, false), null);
		}
		return turnoDAO.save(turno).toDTO();
	}
	
}
