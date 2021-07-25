package sipe.controller.dto;

import org.junit.jupiter.api.Test;
import org.meanbean.test.BeanTester;

public class SesionDTOTest {

	@Test
	public void testSesionDTO() {
		BeanTester beanTester = new BeanTester();
		beanTester.testBean(SesionDTO.class);
	}
}
