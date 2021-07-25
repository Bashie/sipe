package sipe.controller.dto;

import org.junit.jupiter.api.Test;
import org.meanbean.test.BeanTester;

public class UsuarioDTOTest {

	@Test
	public void testUsuarioDTO() {
		BeanTester beanTester = new BeanTester();
		beanTester.testBean(UsuarioDTO.class);
	}
}
