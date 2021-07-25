package sipe.service;

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
import sipe.dao.PracticaProfesionalDAO;
import sipe.dao.ProfesionalDAO;
import sipe.dao.TutorDAO;
import sipe.model.PracticaProfesional;
import sipe.model.Profesional;
import sipe.model.Tutor;
import sipe.utils.UnitTestHelper;

public class PracticaProfesionalServiceTest {

	@Spy
	@InjectMocks
	private PracticaProfesionalService practicaProfesionalService;
	
	@Mock
	private PracticaProfesionalDAO practicaProfesionalDao;
	@Mock
	private ProfesionalDAO profesionalDao;
	@Mock
	private TutorDAO tutorDao;
	

	@BeforeEach
	public void setUp() {
		MockitoAnnotations.openMocks(this);
	}
	
	@Test
	public void saveTest() {
		doReturn(new Tutor()).when(tutorDao).findById(any());
		doReturn(Profesional.fromDTO(UnitTestHelper.getProfesionalDto())).when(profesionalDao).findById(UnitTestHelper.PROFESIONAL_ID);
		doReturn(PracticaProfesional.fromDTO(UnitTestHelper.getPracticaProfesionalDto(), Profesional.fromDTO(UnitTestHelper.getProfesionalDto()), new Tutor())).when(practicaProfesionalDao).save(any());
		
		PracticaProfesional resultado = practicaProfesionalService.save(UnitTestHelper.getPracticaProfesionalDto());
		Assertions.assertEquals(resultado.getId(), UnitTestHelper.PRACTICA_ID);
	}
	
	@Test
	public void getAllPracticasProfesionalesByTutorTest() {
		List<PracticaProfesional> listaPracticas = new ArrayList<PracticaProfesional>() {{
			add(PracticaProfesional.fromDTO(UnitTestHelper.getPracticaProfesionalDto(), Profesional.fromDTO(UnitTestHelper.getProfesionalDto()), new Tutor()));
		}};
		doReturn(listaPracticas).when(practicaProfesionalDao).getAllPracticasProfesionalesByTutor(any());
		
		List<PracticaProfesionalDTO> resultado = practicaProfesionalService.getAllPracticasProfesionalesByTutor(UnitTestHelper.TUTOR_DNI);
		Assertions.assertEquals(resultado.size(), 1);
		Assertions.assertEquals(resultado.get(0).getId(), UnitTestHelper.PRACTICA_ID);
	}
	
	@Test
	public void deleteTest() {
		doReturn(PracticaProfesional.fromDTO(UnitTestHelper.getPracticaProfesionalDto(), Profesional.fromDTO(UnitTestHelper.getProfesionalDto()), new Tutor())).when(practicaProfesionalDao).findById(UnitTestHelper.PRACTICA_ID);
		Boolean resultado = practicaProfesionalService.delete(UnitTestHelper.PRACTICA_ID);
		Assertions.assertTrue(resultado);
	}
}
