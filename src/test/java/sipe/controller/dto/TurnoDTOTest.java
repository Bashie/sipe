package sipe.controller.dto;

import org.junit.jupiter.api.Test;
import org.meanbean.test.BeanTester;

public class TurnoDTOTest {

	@Test
	public void testTurnoDTO() {
		BeanTester beanTester = new BeanTester();
		beanTester.testBean(TurnoDTO.class);
	}
}
