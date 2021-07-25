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

import sipe.controller.dto.PracticaProfesionalDTO;
import sipe.model.PracticaProfesional;
import sipe.model.Profesional;
import sipe.model.Tutor;
import sipe.service.PracticaProfesionalService;
import sipe.utils.UnitTestHelper;

public class PracticaControllerTest {

	@Spy
	@InjectMocks
	private PracticaController practicaController;
	@Mock
	private PracticaProfesionalService practicaProfesionalService;
	
	@BeforeEach
	public void setUp() {
		MockitoAnnotations.openMocks(this);
	}
	
	@Test
	public void savePracticaProfesionalTest() {
		doReturn(PracticaProfesional.fromDTO(UnitTestHelper.getPracticaProfesionalDto(), Profesional.fromDTO(UnitTestHelper.getProfesionalDto()), new Tutor())).when(practicaProfesionalService).save(any());
		
		PracticaProfesionalDTO resultado = practicaController.savePracticaProfesional(UnitTestHelper.DIA_SEMANA, UnitTestHelper.PRACTICA_ID, UnitTestHelper.PROFESIONAL_ID, UnitTestHelper.TUTOR_DNI, UnitTestHelper.INICIO, UnitTestHelper.FIN);
		Assertions.assertEquals(resultado.getId(), UnitTestHelper.PRACTICA_ID);
	}
	
	@Test
	public void getPracticaProfesionalesTest() {
		List<PracticaProfesionalDTO> listaPracticas = new ArrayList<PracticaProfesionalDTO>() {{
			add(UnitTestHelper.getPracticaProfesionalDto());
		}};
		doReturn(listaPracticas).when(practicaProfesionalService).getAllPracticasProfesionalesByTutor(any());

		List<PracticaProfesionalDTO> resultado = practicaController.getPracticaProfesionales(UnitTestHelper.TUTOR_DNI);
		Assertions.assertEquals(resultado.size(), 1);
		Assertions.assertEquals(resultado.get(0).getId(), UnitTestHelper.PRACTICA_ID);
	}
	
	@Test
	public void deletePracticaProfesionalTest() {
		doReturn(Boolean.TRUE).when(practicaProfesionalService).delete(UnitTestHelper.PRACTICA_ID);
		
		Boolean resultado = practicaController.deletePracticaProfesional(UnitTestHelper.PRACTICA_ID);
		Assertions.assertTrue(resultado);
	}
}
