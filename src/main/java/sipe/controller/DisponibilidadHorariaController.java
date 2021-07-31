package sipe.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import sipe.controller.dto.DisponibilidadHorariaDTO;
import sipe.model.DisponibilidadHoraria;
import sipe.service.DisponibilidadHorariaService;

@RestController
@CrossOrigin(origins = "http://localhost:3000")
public class DisponibilidadHorariaController {

	Logger logger = LoggerFactory.getLogger(DisponibilidadHorariaController.class);
	
	@Autowired
	private DisponibilidadHorariaService disponibilidadHorariaService;
	
	@RequestMapping("/disponibilidad/nuevo")
	@ResponseBody
	public DisponibilidadHorariaDTO saveDisponibilidadHoraria (
			@RequestParam(name="id", required = false) Integer id,
			@RequestParam(name="profesionalId", required = true) Integer profesionalId,
			@RequestParam(name="inicio") String inicio,
			@RequestParam(name="fin", required = true) String fin
			) {
		
		DisponibilidadHorariaDTO disponibilidad = new DisponibilidadHorariaDTO();
		disponibilidad.setFin(inicio);
		disponibilidad.setProfesionalId(profesionalId);
		disponibilidad.setInicio(fin);
		disponibilidad.setId(id);
		DisponibilidadHoraria result = disponibilidadHorariaService.save(disponibilidad);
		disponibilidad.setId(result.getId());
		return disponibilidad;
	}
	
	@RequestMapping("/disponibilidad/list/{id}")
	@ResponseBody
	public List<DisponibilidadHorariaDTO> getDisponibilidadHorarias(@PathVariable(name="id", required = true) Integer id) {
		logger.info("List Practicas");
		return disponibilidadHorariaService.findAllByProfesional(id);
	}
	
	@RequestMapping("/disponibilidad/delete/{id}")
	@ResponseBody
	public Boolean deleteDisponibilidadHoraria(@PathVariable(name="id", required = true) Integer id) {
		return disponibilidadHorariaService.delete(id);
	}
}
