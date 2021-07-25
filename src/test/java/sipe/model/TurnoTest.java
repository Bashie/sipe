package sipe.model;

import java.time.LocalDateTime;
import java.time.LocalTime;

import org.junit.jupiter.api.Test;
import org.meanbean.test.BeanTester;

public class TurnoTest {

	@Test
	public void testTurno() {
		BeanTester beanTester = new BeanTester();
		beanTester.getFactoryCollection().addFactory(LocalDateTime.class, new LocalDateTimeFactory());
		beanTester.getFactoryCollection().addFactory(LocalTime.class, new LocalTimeFactory());
		beanTester.testBean(Turno.class);
	}
}

