package sipe.controller.dto;

import org.junit.jupiter.api.Test;
import org.meanbean.test.BeanTester;

public class ProfesionalDTOTest {

	@Test
	public void testProfesionalDTO() {
		BeanTester beanTester = new BeanTester();
		beanTester.testBean(ProfesionalDTO.class);
	}
}
