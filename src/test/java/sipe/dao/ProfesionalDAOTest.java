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

import sipe.model.Profesional;
import sipe.model.Sesion;
import sipe.utils.UnitTestHelper;

public class ProfesionalDAOTest {

	@Spy
	@InjectMocks
	private ProfesionalDAO profesionalDAO;
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
		List<Profesional> listaTurnos = new ArrayList<Profesional>() {{
			add(Profesional.fromDTO(UnitTestHelper.getProfesionalDto()));
		}};
		doReturn(listaTurnos).when(query).getResultList();
		List<Profesional> resultado = profesionalDAO.findAll();
		Assertions.assertEquals(resultado.size(), 1);
		Assertions.assertEquals(resultado.get(0).getDni(), UnitTestHelper.PROFESIONAL_DNI);
	}
	
	@Test
	public void findAllByPracticaTest() {
		doReturn(query).when(entityManager).createQuery(any(), any());
		List<Profesional> listaTurnos = new ArrayList<Profesional>() {{
			add(Profesional.fromDTO(UnitTestHelper.getProfesionalDto()));
		}};
		doReturn(listaTurnos).when(query).getResultList();
		List<Profesional> resultado = profesionalDAO.findAllByTutorId();
		Assertions.assertEquals(resultado.size(), 1);
		Assertions.assertEquals(resultado.get(0).getDni(), UnitTestHelper.PROFESIONAL_DNI);
	}

}
