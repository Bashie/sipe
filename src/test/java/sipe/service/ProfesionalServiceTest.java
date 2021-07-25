package sipe.service;

import static org.mockito.Mockito.doReturn;
import static org.mockito.ArgumentMatchers.any;
import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.Spy;

import sipe.controller.dto.ProfesionalDTO;
import sipe.dao.ProfesionalDAO;
import sipe.model.Profesional;
import sipe.utils.UnitTestHelper;

public class ProfesionalServiceTest {

	@Spy
	@InjectMocks
	private ProfesionalService profesionalService;
	@Mock
	private ProfesionalDAO profesionalDao;
	
	@BeforeEach
	public void setUp() {
		MockitoAnnotations.openMocks(this);
	}
	
	@Test
	public void saveTest() {
		doReturn(Profesional.fromDTO(UnitTestHelper.getProfesionalDto())).when(profesionalDao).save(any());
		
		Profesional resultado = profesionalService.save(UnitTestHelper.getProfesionalDto());
		Assertions.assertEquals(resultado.getDni(), UnitTestHelper.PROFESIONAL_DNI);
	}
	
	@Test
	public void getAllProfesionalesTest() {
		List<Profesional> listaProfesionales = new ArrayList<Profesional>() {{
			add(Profesional.fromDTO(UnitTestHelper.getProfesionalDto()));
		}};
		doReturn(listaProfesionales).when(profesionalDao).findAllByTutorId();
		
		List<ProfesionalDTO> resultado = profesionalService.getAllProfesionales();
		Assertions.assertEquals(resultado.size(), 1);
		Assertions.assertEquals(resultado.get(0).getDni(), UnitTestHelper.PROFESIONAL_DNI);
	}
	
	@Test
	public void deleteTest() {
		doReturn(Profesional.fromDTO(UnitTestHelper.getProfesionalDto())).when(profesionalDao).findById(UnitTestHelper.PROFESIONAL_ID);
		Boolean resultado = profesionalService.delete(UnitTestHelper.PROFESIONAL_ID);
		Assertions.assertTrue(resultado);
	}
	
}
