package sipe.service;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.doReturn;
import static org.mockito.Mockito.verify;

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
import sipe.dao.PracticaProfesionalDAO;
import sipe.dao.SesionDAO;
import sipe.model.PracticaProfesional;
import sipe.model.Profesional;
import sipe.model.Sesion;
import sipe.model.Tutor;
import sipe.utils.UnitTestHelper;

public class SesionServiceTest {
	
	@Spy
	@InjectMocks
	private SesionService sesionService;
	@Mock
	private SesionDAO sesionDao;
	@Mock
	private PracticaProfesionalDAO practicaProfesionalDao;
	
	@BeforeEach
	public void setUp() {
		MockitoAnnotations.openMocks(this);
	}
	
	@Test
	public void saveTest() {
		Sesion sesion = Sesion.fromDTO(UnitTestHelper.getSesionDto(), null, null);
		sesion.setId(UnitTestHelper.SESION_ID);
		SesionDTO dto = UnitTestHelper.getSesionDto();
		doReturn(sesion).when(sesionDao).save(any());
		doReturn(new PracticaProfesional()).when(practicaProfesionalDao).findById(UnitTestHelper.PRACTICA_ID);
		
		Sesion result = sesionService.save(dto);
		Assertions.assertEquals(result.getNotas(), UnitTestHelper.NOTAS);
	}
	
	@Test
	public void getAllSesionesByPracticaTest() {
		Sesion sesion = Sesion.fromDTO(UnitTestHelper.getSesionDto(), null, null);
		sesion.setId(UnitTestHelper.SESION_ID);
		sesion.setPracticaProfesional(PracticaProfesional.fromDTO(UnitTestHelper.getPracticaProfesionalDto(), Profesional.fromDTO(UnitTestHelper.getProfesionalDto()), new Tutor()));
		List<Sesion> listaSesiones = new ArrayList<Sesion>() {{
			add(sesion);
		}};
		doReturn(listaSesiones).when(sesionDao).findAllByPractica(UnitTestHelper.PRACTICA_ID);
		
		List<SesionDTO> result = sesionService.getAllSesionesByPractica(UnitTestHelper.PRACTICA_ID);
		Assertions.assertEquals(result.size(), 1);
		Assertions.assertEquals(result.get(0).getNotas(), UnitTestHelper.NOTAS);
	}
	
	@Test
	public void testDelete() {
		Sesion sesion = Sesion.fromDTO(UnitTestHelper.getSesionDto(), null, null);
		sesion.setId(UnitTestHelper.SESION_ID);
		doReturn(sesion).when(sesionDao).save(sesion);
		doReturn(sesion).when(sesionDao).findById(UnitTestHelper.SESION_ID);
		
		SesionDTO result = sesionService.delete(UnitTestHelper.SESION_ID);
		Assertions.assertNotNull(result);
		verify(sesionDao).delete(any());
	}

}
