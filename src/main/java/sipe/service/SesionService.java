package sipe.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import sipe.controller.dto.SesionDTO;
import sipe.dao.PracticaProfesionalDAO;
import sipe.dao.SesionDAO;
import sipe.model.PracticaProfesional;
import sipe.model.Sesion;

@Component
public class SesionService {
	
	@Autowired
	private SesionDAO sesionDao;
	@Autowired
	private PracticaProfesionalDAO practicaProfesionalDao;
	
	public Sesion save(SesionDTO session) {
		try {
			PracticaProfesional practicaProfesional = practicaProfesionalDao.findById(session.getPracticaProfesionalId());
			return sesionDao.save(Sesion.fromDTO(session, practicaProfesional));
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}
	
	public List<SesionDTO> getAllSesionesByPractica(Integer id) {
		return sesionDao.findAllByPractica(id).stream().map(Sesion::toDTO).collect(Collectors.toList());
	}
	
	public SesionDTO delete(Integer id) {
		Sesion sesion = sesionDao.findById(id);
		sesionDao.delete(sesion);
		return sesion.toDTO();
	}
}
