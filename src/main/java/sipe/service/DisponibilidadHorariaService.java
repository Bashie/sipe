package sipe.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import sipe.controller.dto.DisponibilidadHorariaDTO;
import sipe.dao.DisponibilidadHorariaDAO;
import sipe.dao.ProfesionalDAO;
import sipe.model.DisponibilidadHoraria;
import sipe.model.Profesional;

@Component
public class DisponibilidadHorariaService {
	@Autowired
	private DisponibilidadHorariaDAO disponibilidadHorariaDAO;
	@Autowired 
	private ProfesionalDAO profesionalDao;
	
	public DisponibilidadHoraria save(DisponibilidadHorariaDTO disponibilidad) {
		try {
			Profesional profesional = profesionalDao.findById(disponibilidad.getProfesionalId());
			return disponibilidadHorariaDAO.save(DisponibilidadHoraria.fromDTO(disponibilidad, profesional));
		} catch (Exception e) {
			return null;
		}
	}
	
	public List<DisponibilidadHorariaDTO> findAllByProfesional(Integer id) {
		return disponibilidadHorariaDAO.findAllByProfesional(id).stream().map(DisponibilidadHoraria::toDTO).collect(Collectors.toList());
	}
	
	public Boolean delete(Integer id) {
		DisponibilidadHoraria disponibilidad = disponibilidadHorariaDAO.findById(id);
		try {
			disponibilidadHorariaDAO.delete(disponibilidad);
		} catch (Exception e) {
			return false;
		}
		return true;
	}
}
