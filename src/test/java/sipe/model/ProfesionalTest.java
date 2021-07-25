package sipe.model;

import org.junit.jupiter.api.Test;
import org.meanbean.test.BeanTester;

public class ProfesionalTest {

	@Test
	public void testProfesional() {
		BeanTester beanTester = new BeanTester();
		beanTester.testBean(Profesional.class);
	}
}

