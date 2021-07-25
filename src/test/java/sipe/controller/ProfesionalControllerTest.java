package sipe.controller;

import static org.mockito.Mockito.doReturn;

import java.util.ArrayList;
import java.util.List;

import static org.mockito.ArgumentMatchers.any;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.Spy;

import sipe.controller.dto.PracticaProfesionalDTO;
import sipe.controller.dto.ProfesionalDTO;
import sipe.model.Profesional;
import sipe.service.ProfesionalService;
import sipe.utils.UnitTestHelper;

public class ProfesionalControllerTest {

	@Spy
	@InjectMocks
	private ProfesionalController profesionalController;
	@Mock
	private ProfesionalService profesionalService;
	
	@BeforeEach
	public void setUp() {
		MockitoAnnotations.openMocks(this);
	}
	
	@Test
	public void saveProfesionalTest() {
		doReturn(Profesional.fromDTO(UnitTestHelper.getProfesionalDto())).when(profesionalService).save(any());
		
		ProfesionalDTO resultado = profesionalController.saveProfesional(UnitTestHelper.PROFESIONAL_NOMBRE, UnitTestHelper.PROFESIONAL_APELLIDO, UnitTestHelper.PROFESIONAL_DNI, UnitTestHelper.AREA_DESARROLLO);
		Assertions.assertEquals(resultado.getDni(), UnitTestHelper.PROFESIONAL_DNI);
	}
	
	@Test
	public void getProfesionalesTest() {
		List<ProfesionalDTO> listaProfesionales = new ArrayList<ProfesionalDTO>() {{
			add(UnitTestHelper.getProfesionalDto());
		}};
		doReturn(listaProfesionales).when(profesionalService).getAllProfesionales();

		List<ProfesionalDTO> resultado = profesionalController.getProfesionales();
		Assertions.assertEquals(resultado.size(), 1);
		Assertions.assertEquals(resultado.get(0).getDni(), UnitTestHelper.PROFESIONAL_DNI);
	}
	
	@Test
	public void deleteProfesionalTest() {
		doReturn(Boolean.TRUE).when(profesionalService).delete(UnitTestHelper.PROFESIONAL_ID);
		
		Boolean resultado = profesionalController.deleteProfesional(UnitTestHelper.PROFESIONAL_ID);
		Assertions.assertTrue(resultado);
	}
}
