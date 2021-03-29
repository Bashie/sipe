package sipe.controller;

import java.util.ArrayList;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import sipe.controller.dto.ProfesionalDTO;

@RestController
public class BaseController {

	@RequestMapping("/")
	public String index() {
		return "Hola mundo SIPE!";
	}

	@RequestMapping("/profesionales/{codigo}")
	@CrossOrigin(origins = "http://localhost:3000")
	@ResponseBody
	public ArrayList<ProfesionalDTO> getProfesionales(@PathVariable(name="codigo", required = true) String codigo) {
		ProfesionalDTO profesional = new ProfesionalDTO();
		profesional.setNombre("Pepe");
		profesional.setApellido("Grillo");
		profesional.setDni(123456789);
		profesional.setPracticaProfesional("Psicoterapeuta");
		ArrayList<ProfesionalDTO> result = new ArrayList<>();
		result.add(profesional);
		return result;
	}
}
