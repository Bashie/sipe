package sipe.dao;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.doReturn;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.Spy;

import sipe.model.PracticaProfesional;
import sipe.model.Profesional;
import sipe.model.Sesion;
import sipe.model.Tutor;
import sipe.utils.UnitTestHelper;

public class SesionDAOTest {

	@Spy
	@InjectMocks
	private SesionDAO sesionDAO;
	@Mock
	private EntityManager entityManager;
	@Mock
	private TypedQuery<Sesion> query;
	
	@BeforeEach
	public void setUp() {
		MockitoAnnotations.openMocks(this);
	}
	
	@Test
	public void findAllTest() {
		doReturn(query).when(entityManager).createQuery(any(), any());
		List<Sesion> listaTurnos = new ArrayList<Sesion>() {{
			add(Sesion.fromDTO(UnitTestHelper.getSesionDto(), PracticaProfesional.fromDTO(UnitTestHelper.getPracticaProfesionalDto(), Profesional.fromDTO(UnitTestHelper.getProfesionalDto()), new Tutor()), null));
		}};
		doReturn(listaTurnos).when(query).getResultList();
		List<Sesion> resultado = sesionDAO.findAll();
		Assertions.assertEquals(resultado.size(), 1);
		Assertions.assertEquals(resultado.get(0).getId(), UnitTestHelper.SESION_ID);
	}
	
	@Test
	public void findAllByPracticaTest() {
		doReturn(query).when(entityManager).createQuery(any(), any());
		List<Sesion> listaTurnos = new ArrayList<Sesion>() {{
			add(Sesion.fromDTO(UnitTestHelper.getSesionDto(), PracticaProfesional.fromDTO(UnitTestHelper.getPracticaProfesionalDto(), Profesional.fromDTO(UnitTestHelper.getProfesionalDto()), new Tutor()), null));
		}};
		doReturn(listaTurnos).when(query).getResultList();
		List<Sesion> resultado = sesionDAO.findAllByPractica(UnitTestHelper.PRACTICA_ID);
		Assertions.assertEquals(resultado.size(), 1);
		Assertions.assertEquals(resultado.get(0).getId(), UnitTestHelper.SESION_ID);
	}

}
