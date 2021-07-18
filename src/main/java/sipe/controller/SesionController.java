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

import sipe.controller.dto.SesionDTO;
import sipe.model.Sesion;
import sipe.service.SesionService;

@RestController
@CrossOrigin(origins = "http://localhost:3000")
public class SesionController {

	Logger logger = LoggerFactory.getLogger(SesionController.class);
	
	@Autowired
	private SesionService sesionService;
	
	@RequestMapping("/sesiones/nuevo")
	@ResponseBody
	public SesionDTO saveSesion(
			@RequestParam(name="end", required = true) String end,
			@RequestParam(name="notas", required = true) String notas,
			@RequestParam(name="id", required = false) Integer id,
			@RequestParam(name="practicaProfesionalId", required = true) Integer practicaProfesionalId,
			@RequestParam(name="start", required = true) String start
			) {
		
		SesionDTO sesion = new SesionDTO();
		sesion.setEnd(end);
		sesion.setId(id);
		sesion.setNotas(notas);
		sesion.setPracticaProfesionalId(practicaProfesionalId);
		sesion.setStart(start);
		Sesion result = sesionService.save(sesion);
		sesion.setId(result.getId());
		return sesion;
		
	}
	
	@RequestMapping("/sesiones/list/{id}")
	@CrossOrigin(origins = "http://localhost:3000")
	@ResponseBody
	public List<SesionDTO> getSesiones(@PathVariable(name="id", required = true) Integer id) {
		logger.info("List Profesionales");
		return sesionService.getAllSesionesByPractica(id);
	}
	
	@RequestMapping("/sesiones/delete/{id}")
	@ResponseBody
	public Boolean deleteSesion(@PathVariable(name="id", required = true) String id) {
		return sesionService.delete(Integer.valueOf(id));
	}
}
