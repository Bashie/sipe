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

import sipe.controller.dto.PracticaProfesionalDTO;
import sipe.model.PracticaProfesional;
import sipe.service.PracticaProfesionalService;

@RestController
@CrossOrigin(origins = "http://localhost:3000")
public class PracticaController {

	Logger logger = LoggerFactory.getLogger(PracticaController.class);
	
	@Autowired
	private PracticaProfesionalService practicaProfesionalService;
	
	@RequestMapping("/practicas/nuevo")
	@ResponseBody
	public PracticaProfesionalDTO savePracticaProfesional(
			@RequestParam(name="diaSemana", required = true) Integer diaSemana,
			@RequestParam(name="id", required = false) Integer id,
			@RequestParam(name="profesional", required = true) Integer profesionalId,
			@RequestParam(name="tutorDni", required = true) Integer tutorDni,
			@RequestParam(name="inicio") String inicio,
			@RequestParam(name="fin", required = true) String fin
			) {
		PracticaProfesionalDTO practicaProfesional = new PracticaProfesionalDTO();
		practicaProfesional.setDiaSemana(diaSemana);
		practicaProfesional.setInicio(inicio);
		practicaProfesional.setFin(fin);
		practicaProfesional.setProfesionalId(profesionalId);
		practicaProfesional.setTutorDni(tutorDni);
		practicaProfesional.setId(id);
		PracticaProfesional result = practicaProfesionalService.save(practicaProfesional);
		practicaProfesional.setId(result.getId());
		return practicaProfesional;
	}
	
	@RequestMapping("/practicas/list/{id}")
	@ResponseBody
	public List<PracticaProfesionalDTO> getPracticaProfesionales(@PathVariable(name="id", required = true) Integer id) {
		logger.info("List Practicas");
		return practicaProfesionalService.getAllPracticasProfesionalesByTutor(id);
	}
	
	@RequestMapping("/practicas/delete/{id}")
	@ResponseBody
	public Boolean deletePracticaProfesional(@PathVariable(name="id", required = true) Integer id) {
		return practicaProfesionalService.delete(id);
	}
}
