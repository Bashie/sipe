package sipe.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import sipe.controller.dto.PracticaProfesionalDTO;
import sipe.dao.PracticaProfesionalDAO;
import sipe.dao.ProfesionalDAO;
import sipe.dao.TutorDAO;
import sipe.model.PracticaProfesional;
import sipe.model.Profesional;
import sipe.model.Tutor;

@Component
public class PracticaProfesionalService {
	
	@Autowired
	private PracticaProfesionalDAO practicaProfesionalDao;
	@Autowired
	private ProfesionalDAO profesionalDao;
	@Autowired
	private TutorDAO tutorDao;
	
	public PracticaProfesional save(PracticaProfesionalDTO practicaProfesional) {
		try {
			Tutor tutor = tutorDao.findById(practicaProfesional.getTutorDni());
			Profesional profesional = profesionalDao.findById(practicaProfesional.getProfesionalId());
			return practicaProfesionalDao.save(PracticaProfesional.fromDTO(practicaProfesional, profesional, tutor));
		} catch (Exception e) {
			return null;
		}
	}
	
	public List<PracticaProfesionalDTO> getAllPracticasProfesionalesByProfesional() {
		return practicaProfesionalDao.findAll().stream().map(PracticaProfesional::toDTO).collect(Collectors.toList());
	}
	
	public Boolean delete(Integer id) {
		PracticaProfesional practica = practicaProfesionalDao.findById(id);
		try {
			practicaProfesionalDao.delete(practica);
		} catch (Exception e) {
			return false;
		}
		return true;
	}
	
}
