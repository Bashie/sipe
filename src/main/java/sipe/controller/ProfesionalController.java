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

import sipe.controller.dto.ProfesionalDTO;
import sipe.model.Profesional;
import sipe.service.ProfesionalService;

@RestController
@CrossOrigin(origins = "http://localhost:3000")
public class ProfesionalController {

	Logger logger = LoggerFactory.getLogger(ProfesionalController.class);
	
	@Autowired
	private ProfesionalService profesionalService;
	
	@RequestMapping("/profesionales/nuevo")
	@ResponseBody
	public ProfesionalDTO saveProfesional(
			@RequestParam(name="nombre", required = true) String nombre,
			@RequestParam(name="apellido", required = true) String apellido,
			@RequestParam(name="dni") Integer dni,
			@RequestParam(name="areaDesarrollo", required = true) String areaDesarrollo
			) {
		
		ProfesionalDTO profesional = new ProfesionalDTO();
		profesional.setNombre(nombre);
		profesional.setApellido(apellido);
		profesional.setDni(dni);
		profesional.setAreaDesarrollo(areaDesarrollo);
		Profesional result =  profesionalService.save(profesional);
		profesional.setDni(result.getId());
		return profesional;
	}
	
	@RequestMapping("/profesionales/list")
	@CrossOrigin(origins = "http://localhost:3000")
	@ResponseBody
	public List<ProfesionalDTO> getProfesionales() {
		logger.info("List Profesionales");
		return profesionalService.getAllProfesionales();
	}
	
	@RequestMapping("/profesionales/delete/{id}")
	@ResponseBody
	public Boolean deleteProfesional(@PathVariable(name="id", required = true) Integer id) {
		return profesionalService.delete(id);
	}
}
