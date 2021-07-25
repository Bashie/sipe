package sipe.model;

import org.junit.jupiter.api.Test;
import org.meanbean.test.BeanTester;

public class TutorTest {

	 @Test
	 public void testTutor() {
	  BeanTester beanTester = new BeanTester();
	  beanTester.testBean(Tutor.class);
	 }
	
}
