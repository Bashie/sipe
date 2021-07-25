package sipe.model;

import java.time.LocalDateTime;
import java.time.LocalTime;

import org.junit.jupiter.api.Test;
import org.meanbean.lang.Factory;
import org.meanbean.test.BeanTester;

public class SesionTest {

	@Test
	public void testSesion() {
		BeanTester beanTester = new BeanTester();
		beanTester.getFactoryCollection().addFactory(LocalDateTime.class, new LocalDateTimeFactory());
		beanTester.getFactoryCollection().addFactory(LocalTime.class, new LocalTimeFactory());
		beanTester.testBean(Sesion.class);
	}
}

class LocalDateTimeFactory implements Factory<LocalDateTime> {
	@Override
	public LocalDateTime create() {
		return LocalDateTime.now();
	}
}