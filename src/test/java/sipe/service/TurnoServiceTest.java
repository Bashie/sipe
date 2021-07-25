package sipe.service;

import static org.mockito.Mockito.doReturn;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.any;
import static org.mockito.Mockito.doCallRealMethod;
import static org.mockito.Mockito.doNothing;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.Spy;

import sipe.controller.dto.TurnoDTO;
import sipe.dao.PracticaProfesionalDAO;
import sipe.dao.TurnoDAO;
import sipe.model.PracticaProfesional;
import sipe.model.Profesional;
import sipe.model.Turno;
import sipe.model.Tutor;
import sipe.util.Mailer;
import sipe.utils.UnitTestHelper;

public class TurnoServiceTest {
	
	@Spy
	@InjectMocks
	private TurnoService turnoService;
	
	@Mock
	private TurnoDAO turnoDAO;
	@Mock
	private PracticaProfesionalDAO practicaProfesionalDao;
	@Mock
	private Mailer mailer;
	
	@BeforeEach
	public void setUp() {
		MockitoAnnotations.openMocks(this);
	}
	
	@Test
	public void saveTest() {
		Turno turno = Turno.fromDTO(UnitTestHelper.getTurnoDto(), null);
		turno.setId(UnitTestHelper.TURNO_ID);
		TurnoDTO dto = UnitTestHelper.getTurnoDto();
		doReturn(turno).when(turnoDAO).save(any());
		doReturn(new PracticaProfesional()).when(practicaProfesionalDao).findById(UnitTestHelper.PRACTICA_ID);
		
		Turno result = turnoService.save(dto);
		Assertions.assertEquals(result.getId(), UnitTestHelper.TURNO_ID);
	}
	
	
	@Test
	public void getTurnosTest() {
		Turno turno = Turno.fromDTO(UnitTestHelper.getTurnoDto(), PracticaProfesional.fromDTO(UnitTestHelper.getPracticaProfesionalDto(), Profesional.fromDTO(UnitTestHelper.getProfesionalDto()), new Tutor()));
		turno.setId(UnitTestHelper.TURNO_ID);
		List<Turno> listaTurnos = new ArrayList<Turno>() {{
			add(turno);
		}};
		doReturn(listaTurnos).when(turnoDAO).findAllByPractica(UnitTestHelper.PRACTICA_ID);
		
		List<TurnoDTO> result = turnoService.getAllTurnosByPractica(UnitTestHelper.PRACTICA_ID);
		Assertions.assertEquals(result.size(), 1);
		Assertions.assertEquals(result.get(0).getId(), UnitTestHelper.TURNO_ID);
	}
	
	@Test
	public void testDelete() {
		Turno turno = Turno.fromDTO(UnitTestHelper.getTurnoDto(), PracticaProfesional.fromDTO(UnitTestHelper.getPracticaProfesionalDto(), Profesional.fromDTO(UnitTestHelper.getProfesionalDto()), new Tutor()));
		turno.setId(UnitTestHelper.TURNO_ID);
		doReturn(turno).when(turnoDAO).save(turno);
		doReturn(turno).when(turnoDAO).findById(UnitTestHelper.TURNO_ID);
		
		Boolean result = turnoService.delete(UnitTestHelper.TURNO_ID);
		Assertions.assertTrue(result);
		verify(turnoDAO).delete(any());
	}
	
	@Test
	public void testConfirmar() {
		Profesional profesional = Profesional.fromDTO(UnitTestHelper.getProfesionalDto());
		profesional.setEmail(UnitTestHelper.MAIL);
		Turno turno = Turno.fromDTO(UnitTestHelper.getTurnoDto(), PracticaProfesional.fromDTO(UnitTestHelper.getPracticaProfesionalDto(), profesional, new Tutor()));
		turno.setConfirmado(true);
		doReturn(turno).when(turnoDAO).findById(UnitTestHelper.TURNO_ID);
		doReturn(turno).when(turnoDAO).save(any());
		doNothing().when(mailer).sendMail(any(), any(), any());
		doCallRealMethod().when(mailer).getTurnoMessageBody(turno, true);
		
		TurnoDTO result = turnoService.confirmar(UnitTestHelper.TURNO_ID);
		verify(mailer).sendMail(any(), any(), any());
		Assertions.assertEquals(Boolean.TRUE, result.getConfirmado());
	}
	
	@Test
	public void testCancelar() {
		Profesional profesional = Profesional.fromDTO(UnitTestHelper.getProfesionalDto());
		profesional.setEmail(UnitTestHelper.MAIL);
		Turno turno = Turno.fromDTO(UnitTestHelper.getTurnoDto(), PracticaProfesional.fromDTO(UnitTestHelper.getPracticaProfesionalDto(), profesional, new Tutor()));
		turno.setConfirmado(false);
		doReturn(turno).when(turnoDAO).findById(UnitTestHelper.TURNO_ID);
		doReturn(turno).when(turnoDAO).save(any());
		doNothing().when(mailer).sendMail(any(), any(), any());
		doCallRealMethod().when(mailer).getTurnoMessageBody(turno, false);
		
		TurnoDTO result = turnoService.cancelar(UnitTestHelper.TURNO_ID);
		verify(mailer).sendMail(any(), any(), any());
		Assertions.assertEquals(Boolean.FALSE, result.getConfirmado());
	}
	
	@Test
	public void getAllTurnosByProfesionalTest() {
		Turno turno = Turno.fromDTO(UnitTestHelper.getTurnoDto(), PracticaProfesional.fromDTO(UnitTestHelper.getPracticaProfesionalDto(), Profesional.fromDTO(UnitTestHelper.getProfesionalDto()), new Tutor()));
		turno.setId(UnitTestHelper.TURNO_ID);
		List<Turno> listaTurnos = new ArrayList<Turno>() {{
			add(turno);
		}};
		List<PracticaProfesional> listaPracticas = new ArrayList<PracticaProfesional>() {{
			add(PracticaProfesional.fromDTO(UnitTestHelper.getPracticaProfesionalDto(), Profesional.fromDTO(UnitTestHelper.getProfesionalDto()), new Tutor()));
		}};
		doReturn(listaTurnos).when(turnoDAO).findAllByProfesional(any(), any());
		doReturn(listaPracticas).when(practicaProfesionalDao).findAllByProfesional(UnitTestHelper.PROFESIONAL_ID);
		
		List<TurnoDTO> result = turnoService.getAllTurnosByProfesional(UnitTestHelper.PROFESIONAL_ID);
		Assertions.assertEquals(result.size(), 1);
		Assertions.assertEquals(result.get(0).getId(), UnitTestHelper.TURNO_ID);
	}
}
