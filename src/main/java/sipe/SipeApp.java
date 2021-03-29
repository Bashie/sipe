package sipe;
import java.time.DayOfWeek;
import java.time.LocalTime;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;

import sipe.model.Persona;
import sipe.model.PracticaProfesional;
import sipe.model.Profesional;
import sipe.model.Tutor;
import sipe.service.TutorService;


@SpringBootApplication
public class SipeApp {

	@Autowired 
	private TutorService tutorService;
	
	public static void main(String[] args) {
		SpringApplication.run(SipeApp.class, args);
		
	}

	@Bean
	public CommandLineRunner commandLineRunner(ApplicationContext ctx) {
//		Profesional profesional = new Profesional();
//		profesional.setNombre("Ana");
//		profesional.setApellido("Lojkasek");
//		profesional.setDni(741852963);
//		profesional.setAreaDesarrollo("Discapacidad");
//
//		PracticaProfesional practicaProfesional = new PracticaProfesional();
//		practicaProfesional.setDayOfWeek(DayOfWeek.FRIDAY);
//		practicaProfesional.setProfesional(profesional);
//		practicaProfesional.setStartTime(LocalTime.now());
//		practicaProfesional.setEndTime(LocalTime.now());
//		
//		Tutor tutor = new Tutor();
//		tutor.setApellido("Gabelloni");
//		tutor.setDni(30591745);
//		tutor.setNombre("Cecilia");
//		Persona hijo = new Persona();
//		hijo.setApellido("Gabelloni");
//		hijo.setDni(123456789);
//		hijo.setNombre("asd");
//		
//		tutor.setHijo(hijo);
//		tutor.addPractica(practicaProfesional);
//		
//		tutorService.persist(tutor);
		
		
		
		return null;
//		return args -> {
//			System.out.println("Let's inspect the beans provided by Spring Boot:");
//			String[] beanNames = ctx.getBeanDefinitionNames();
//			Arrays.sort(beanNames);
//			for (String beanName : beanNames) {
//				System.out.println(beanName);
//			}
//		};
	}
}
