package sipe.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.databind.JsonNode;

import sipe.controller.dto.ProfesionalDTO;
import sipe.service.ProfesionalService;

@RestController
@CrossOrigin(origins = "http://localhost:3000")
public class ProfesionalController {

	Logger logger = LoggerFactory.getLogger(ProfesionalController.class);
	
	@Autowired
	private ProfesionalService profesionalService;
	
	@RequestMapping("/profesionales/nuevo")
	@ResponseBody
	public Boolean saveProfesional(
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
		return profesionalService.save(profesional);
	}
	
	@RequestMapping("/profesionales/list")
	@CrossOrigin(origins = "http://localhost:3000")
	@ResponseBody
	public List<ProfesionalDTO> getProfesionales(@RequestBody JsonNode payload) {
		logger.info("List Profesionales");
		return profesionalService.getAllProfesionales();
	}
	
	@RequestMapping("/profesionales/delete/{id}")
	@ResponseBody
	public Boolean deleteProfesional(@PathVariable(name="id", required = true) String id) {
		return profesionalService.delete(Integer.valueOf(id));
	}
}
