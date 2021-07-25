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
import sipe.model.PracticaProfesional;
import sipe.model.Profesional;
import sipe.model.Sesion;
import sipe.model.Tutor;
import sipe.service.SesionService;
import sipe.utils.UnitTestHelper;

public class SesionControllerTest {

	@Spy
	@InjectMocks
	private SesionController sesionController;
	@Mock
	private SesionService sesionService;
	
	@BeforeEach
	public void setUp() {
		MockitoAnnotations.openMocks(this);
	}
	
	@Test
	public void saveSesionTest() {
		doReturn(Sesion.fromDTO(UnitTestHelper.getSesionDto(), PracticaProfesional.fromDTO(UnitTestHelper.getPracticaProfesionalDto(), Profesional.fromDTO(UnitTestHelper.getProfesionalDto()), new Tutor()))).when(sesionService).save(any());
		
		SesionDTO resultado = sesionController.saveSesion(UnitTestHelper.FIN, UnitTestHelper.NOTAS, UnitTestHelper.SESION_ID, UnitTestHelper.PRACTICA_ID, UnitTestHelper.INICIO);
		Assertions.assertEquals(resultado.getNotas(), UnitTestHelper.NOTAS);
	}
	
	@Test
	public void getSesionesTest() {
		List<SesionDTO> listaSesiones = new ArrayList<SesionDTO>() {{
			add(UnitTestHelper.getSesionDto());
		}};
		doReturn(listaSesiones).when(sesionService).getAllSesionesByPractica(UnitTestHelper.PRACTICA_ID);

		List<SesionDTO> resultado = sesionController.getSesiones(UnitTestHelper.PRACTICA_ID);
		Assertions.assertEquals(resultado.size(), 1);
		Assertions.assertEquals(resultado.get(0).getNotas(), UnitTestHelper.NOTAS);
	}
	
	@Test
	public void deleteSesionTest() {
		doReturn(Boolean.TRUE).when(sesionService).delete(UnitTestHelper.SESION_ID);
		
		Boolean resultado = sesionController.deleteSesion(UnitTestHelper.SESION_ID);
		Assertions.assertTrue(resultado);
	}
}
