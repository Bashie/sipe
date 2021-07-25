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

public class PracticaProfesionalDAOTest {

	@Spy
	@InjectMocks
	private PracticaProfesionalDAO practicaProfesionalDAO;
	@Mock
	private EntityManager entityManager;
	@Mock
	private TypedQuery<PracticaProfesional> query;
	
	@BeforeEach
	public void setUp() {
		MockitoAnnotations.openMocks(this);
	}
	
	@Test
	public void findAllTest() {
		doReturn(query).when(entityManager).createQuery(any(), any());
		List<PracticaProfesional> listaPracticas = new ArrayList<PracticaProfesional>() {{
			add(PracticaProfesional.fromDTO(UnitTestHelper.getPracticaProfesionalDto(), Profesional.fromDTO(UnitTestHelper.getProfesionalDto()), new Tutor()));
		}};
		doReturn(listaPracticas).when(query).getResultList();
		List<PracticaProfesional> resultado = practicaProfesionalDAO.findAll();
		Assertions.assertEquals(resultado.size(), 1);
		Assertions.assertEquals(resultado.get(0).getId(), UnitTestHelper.PRACTICA_ID);
	}
	
	@Test
	public void getAllPracticasProfesionalesByTutorTest() {
		doReturn(query).when(entityManager).createQuery(any(), any());
		List<PracticaProfesional> listaPracticas = new ArrayList<PracticaProfesional>() {{
			add(PracticaProfesional.fromDTO(UnitTestHelper.getPracticaProfesionalDto(), Profesional.fromDTO(UnitTestHelper.getProfesionalDto()), new Tutor()));
		}};
		doReturn(listaPracticas).when(query).getResultList();
		List<PracticaProfesional> resultado = practicaProfesionalDAO.getAllPracticasProfesionalesByTutor(UnitTestHelper.TUTOR_DNI);
		Assertions.assertEquals(resultado.size(), 1);
		Assertions.assertEquals(resultado.get(0).getId(), UnitTestHelper.PRACTICA_ID);
	}

	@Test
	public void findAllByProfesionalTest() {
		doReturn(query).when(entityManager).createQuery(any(), any());
		List<PracticaProfesional> listaPracticas = new ArrayList<PracticaProfesional>() {{
			add(PracticaProfesional.fromDTO(UnitTestHelper.getPracticaProfesionalDto(), Profesional.fromDTO(UnitTestHelper.getProfesionalDto()), new Tutor()));
		}};
		doReturn(listaPracticas).when(query).getResultList();
		List<PracticaProfesional> resultado = practicaProfesionalDAO.findAllByProfesional(UnitTestHelper.PROFESIONAL_ID);
		Assertions.assertEquals(resultado.size(), 1);
		Assertions.assertEquals(resultado.get(0).getId(), UnitTestHelper.PRACTICA_ID);
	}
}
