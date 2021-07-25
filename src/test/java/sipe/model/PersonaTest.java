package sipe.model;

import org.junit.jupiter.api.Test;
import org.meanbean.test.BeanTester;

public class PersonaTest {

	 @Test
	 public void testPersona() {
	  BeanTester beanTester = new BeanTester();
	  beanTester.testBean(Persona.class);
	 }
	
}
