package sipe.model;

import java.time.LocalTime;

import org.junit.jupiter.api.Test;
import org.meanbean.lang.Factory;
import org.meanbean.test.BeanTester;

public class PracticaProfesionalTest {

	@Test
	public void testPracticaProfesional() {
		BeanTester beanTester = new BeanTester();
		beanTester.getFactoryCollection().addFactory(LocalTime.class, new LocalTimeFactory());
		beanTester.testBean(PracticaProfesional.class);
	}
}

class LocalTimeFactory implements Factory<LocalTime> {
	@Override
	public LocalTime create() {
		return LocalTime.now();
	}
}
