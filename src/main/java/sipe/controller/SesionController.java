package sipe.controller;

import java.util.List;
import java.util.Objects;

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
	public SesionDTO saveSesion(@RequestParam(name = "fin", required = true) String fin,
			@RequestParam(name = "notas", required = false) String notas,
			@RequestParam(name = "fileName", required = false) String fileName,
			@RequestBody JsonNode fileData,
			@RequestParam(name = "id", required = false) Integer id,
			@RequestParam(name = "practicaProfesionalId", required = true) Integer practicaProfesionalId,
			@RequestParam(name = "inicio", required = true) String inicio) {
		SesionDTO sesion = new SesionDTO();
		if (Objects.isNull(fileName) && Objects.isNull(notas)) {
			sesion.setErrorMessage("Debe cargar un archivo o notas");
			return sesion;
		}
		sesion.setFin(fin);
		sesion.setId(id);
		sesion.setNotas(notas);
		sesion.setContenido(fileData.get("fileData").asText());
		sesion.setNombreArchivo(fileName);
		sesion.setPracticaProfesionalId(practicaProfesionalId);
		sesion.setInicio(inicio);
		Sesion result = sesionService.save(sesion);
		sesion.setId(result.getId());
		return sesion;

	}

	@RequestMapping("/sesiones/list/{id}")
	@CrossOrigin(origins = "http://localhost:3000")
	@ResponseBody
	public List<SesionDTO> getSesiones(@PathVariable(name = "id", required = true) Integer id) {
		logger.info("List Profesionales");
		return sesionService.getAllSesionesByPractica(id);
	}

	@RequestMapping("/sesiones/delete/{id}")
	@ResponseBody
	public SesionDTO deleteSesion(@PathVariable(name = "id", required = true) Integer id) {
		return sesionService.delete(id);
	}

	@RequestMapping("/sesiones/compartir/{sesionId}/{profesionalId}/{comentario}")
	@ResponseBody
	public SesionDTO compartirSesion(@PathVariable(name = "sesionId", required = true) Integer sesionId,
			@PathVariable(name = "profesionalId", required = true) Integer profesionalId,
			@PathVariable(name = "comentario", required = true) String comentario) {
		return sesionService.compartir(sesionId, profesionalId, comentario);
	}
}
