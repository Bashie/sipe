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

import sipe.model.Tutor;
import sipe.utils.UnitTestHelper;

public class TutorDAOTest {

	@Spy
	@InjectMocks
	private TutorDAO tutorDAO;
	@Mock
	private EntityManager entityManager;
	@Mock
	private TypedQuery<Tutor> query;
	
	@BeforeEach
	public void setUp() {
		MockitoAnnotations.openMocks(this);
	}
	
	@Test
	public void findAllTest() {
		doReturn(query).when(entityManager).createQuery(any(), any());
		List<Tutor> listaTurnos = new ArrayList<Tutor>() {{
			add(new Tutor() {{setDni(UnitTestHelper.TUTOR_DNI);}});
		}};
		doReturn(listaTurnos).when(query).getResultList();
		List<Tutor> resultado = tutorDAO.findAll();
		Assertions.assertEquals(resultado.size(), 1);
		Assertions.assertEquals(resultado.get(0).getDni(), UnitTestHelper.TUTOR_DNI);
	}
}
