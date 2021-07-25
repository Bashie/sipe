package sipe.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import sipe.controller.dto.ProfesionalDTO;
import sipe.dao.ProfesionalDAO;
import sipe.model.Profesional;

@Component
public class ProfesionalService {
	
	@Autowired
	private ProfesionalDAO profesionalDao;
	
	public Profesional save(ProfesionalDTO profesional) {
		try {
			return profesionalDao.save(Profesional.fromDTO(profesional));
		} catch (Exception e) {
			return null;
		}
	}
	
	public List<ProfesionalDTO> getAllProfesionales() {
		return profesionalDao.findAllByTutorId().stream().map(Profesional::toDTO).collect(Collectors.toList());
	}
	
	public Boolean delete(Integer id) {
		Profesional profesional = profesionalDao.findById(id);
		try {
			profesionalDao.delete(profesional);
		} catch (Exception e) {
			return false;
		}
		return true;
	}
	
}
