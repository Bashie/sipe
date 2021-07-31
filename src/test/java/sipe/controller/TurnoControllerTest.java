package sipe.controller;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.doReturn;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.Spy;

import sipe.controller.dto.SesionDTO;
import sipe.controller.dto.TurnoDTO;
import sipe.model.PracticaProfesional;
import sipe.model.Profesional;
import sipe.model.Turno;
import sipe.model.Tutor;
import sipe.service.TurnoService;
import sipe.service.exception.ErrorException;
import sipe.utils.UnitTestHelper;

public class TurnoControllerTest {

	@Spy
	@InjectMocks
	private TurnoController turnoController;
	@Mock
	private TurnoService turnoService;
	
	@BeforeEach
	public void setUp() {
		MockitoAnnotations.openMocks(this);
	}
	
	@Test
	public void saveTurnoTest() throws ErrorException {
		doReturn(Turno.fromDTO(UnitTestHelper.getTurnoDto(), PracticaProfesional.fromDTO(UnitTestHelper.getPracticaProfesionalDto(), Profesional.fromDTO(UnitTestHelper.getProfesionalDto()), new Tutor()))).when(turnoService).save(any());
		
		TurnoDTO resultado = turnoController.saveTurno(UnitTestHelper.FIN, Boolean.FALSE, UnitTestHelper.TURNO_ID, UnitTestHelper.PRACTICA_ID, UnitTestHelper.INICIO);
		Assertions.assertEquals(resultado.getId(), UnitTestHelper.TURNO_ID);
	}
	
	@Test
	public void getTurnosTest() {
		List<TurnoDTO> listaSesiones = new ArrayList<TurnoDTO>() {{
			add(UnitTestHelper.getTurnoDto());
		}};
		doReturn(listaSesiones).when(turnoService).getAllTurnosByPractica(UnitTestHelper.PRACTICA_ID);

		List<TurnoDTO> resultado = turnoController.getTurnos(UnitTestHelper.PRACTICA_ID);
		Assertions.assertEquals(resultado.size(), 1);
		Assertions.assertEquals(resultado.get(0).getId(), UnitTestHelper.TURNO_ID);
	}	
	
	@Test
	public void deleteTurnoTest() {
		doReturn(Boolean.TRUE).when(turnoService).delete(UnitTestHelper.TURNO_ID);
		
		TurnoDTO resultado = turnoController.deleteTurno(UnitTestHelper.TURNO_ID);
		Assertions.assertNotNull(resultado);
	}
}
