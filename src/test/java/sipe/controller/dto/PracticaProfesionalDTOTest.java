package sipe.controller.dto;

import org.junit.jupiter.api.Test;
import org.meanbean.test.BeanTester;

public class PracticaProfesionalDTOTest {

	@Test
	public void testPracticaProfesionalDTO() {
		BeanTester beanTester = new BeanTester();
		beanTester.testBean(PracticaProfesionalDTO.class);
	}
}
