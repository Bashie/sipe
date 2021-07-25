package sipe.service;

import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import sipe.controller.dto.TurnoDTO;
import sipe.dao.PracticaProfesionalDAO;
import sipe.dao.TurnoDAO;
import sipe.model.PracticaProfesional;
import sipe.model.Turno;
import sipe.util.Mailer;

@Component
public class TurnoService {
	
	@Autowired
	private TurnoDAO turnoDAO;
	@Autowired
	private PracticaProfesionalDAO practicaProfesionalDao;
	@Autowired
	private Mailer mailer;
	
	public Turno save(TurnoDTO turno) {
		try {
			PracticaProfesional practicaProfesional = practicaProfesionalDao.findById(turno.getPracticaProfesionalId());
			return turnoDAO.save(Turno.fromDTO(turno, practicaProfesional));
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}
	
	public List<TurnoDTO> getAllTurnosByPractica(Integer id) {
		return turnoDAO.findAllByPractica(id).stream().map(Turno::toDTO).collect(Collectors.toList());
	}
	
	public Boolean delete(Integer id) {
		Turno turno = turnoDAO.findById(id);
		try {
			turnoDAO.delete(turno);
		} catch (Exception e) {
			return false;
		}
		return true;
	}

	public TurnoDTO confirmar(Integer id) {
		Turno turno = turnoDAO.findById(id);
		turno.setConfirmado(true);
		if(!Objects.isNull(turno.getPracticaProfesional().getProfesional().getEmail())) {
			mailer.sendMail(turno.getPracticaProfesional().getProfesional().getEmail(), "Su turno ha sido confirmado", mailer.getTurnoMessageBody(turno, true));
		}
		if(!Objects.isNull(turno.getPracticaProfesional().getTutor().getEmail())) {
			mailer.sendMail(turno.getPracticaProfesional().getTutor().getEmail(), "Su turno ha sido confirmado", mailer.getTurnoMessageBody(turno, true));
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
			mailer.sendMail(turno.getPracticaProfesional().getProfesional().getEmail(), "Su turno ha sido cancelado", mailer.getTurnoMessageBody(turno, false));
		}
		if(!Objects.isNull(turno.getPracticaProfesional().getTutor().getEmail())) {
			mailer.sendMail(turno.getPracticaProfesional().getTutor().getEmail(), "Su turno ha sido cancelado", mailer.getTurnoMessageBody(turno, false));
		}
		return turnoDAO.save(turno).toDTO();
	}
	
}
