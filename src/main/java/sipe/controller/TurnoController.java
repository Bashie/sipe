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

import sipe.controller.dto.TurnoDTO;
import sipe.model.Turno;
import sipe.service.TurnoService;

@RestController
@CrossOrigin(origins = "http://localhost:3000")
public class TurnoController {

	Logger logger = LoggerFactory.getLogger(TurnoController.class);
	
	@Autowired
	private TurnoService turnoService;
	
	@RequestMapping("/turnos/nuevo")
	@ResponseBody
	public TurnoDTO saveTurno(
			@RequestParam(name="end", required = true) String end,
			@RequestParam(name="confirmado", required = true) Boolean confirmado,
			@RequestParam(name="id", required = false) Integer id,
			@RequestParam(name="practicaProfesionalId", required = true) Integer practicaProfesionalId,
			@RequestParam(name="start", required = true) String start
			) {
		
		TurnoDTO turno = new TurnoDTO();
		turno.setEnd(end);
		turno.setId(id);
		turno.setConfirmado(confirmado);
		turno.setPracticaProfesionalId(practicaProfesionalId);
		turno.setStart(start);
		Turno result = turnoService.save(turno);
		turno.setId(result.getId());
		return turno;
		
	}
	
	@RequestMapping("/turnos/confirmar")
	@ResponseBody
	public TurnoDTO confirmarTurno(@RequestParam(name="id", required = true) Integer id) {
		TurnoDTO turno = turnoService.confirmar(id);
		return turno;
		
	}
	
	@RequestMapping("/turnos/cancelar")
	@ResponseBody
	public TurnoDTO cancelarTurno(@RequestParam(name="id", required = true) Integer id) {
		TurnoDTO turno = turnoService.cancelar(id);
		return turno;
	}
	
	@RequestMapping("/turnos/list/{id}")
	@CrossOrigin(origins = "http://localhost:3000")
	@ResponseBody
	public List<TurnoDTO> getTurnos(@PathVariable(name="id", required = true) Integer id) {
		logger.info("List Turnos");
		return turnoService.getAllTurnosByPractica(id);
	}
	
	@RequestMapping("/turnos/profesional/{id}")
	@CrossOrigin(origins = "http://localhost:3000")
	@ResponseBody
	public List<TurnoDTO> getTurnosProfesional(@PathVariable(name="id", required = true) Integer id) {
		logger.info("List Turnos");
		return turnoService.getAllTurnosByProfesional(id);
	}
	
	@RequestMapping("/turnos/delete/{id}")
	@ResponseBody
	public Boolean deleteTurno(@PathVariable(name="id", required = true) Integer id) {
		return turnoService.delete(id);
	}
}
