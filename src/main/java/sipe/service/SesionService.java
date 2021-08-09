package sipe.service;

import java.io.File;
import java.io.FileWriter;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import sipe.controller.dto.SesionDTO;
import sipe.dao.PracticaProfesionalDAO;
import sipe.dao.ProfesionalDAO;
import sipe.dao.SesionDAO;
import sipe.model.PracticaProfesional;
import sipe.model.Profesional;
import sipe.model.Sesion;
import sipe.util.Mailer;

@Component
public class SesionService {

	@Autowired
	private SesionDAO sesionDao;
	@Autowired
	private PracticaProfesionalDAO practicaProfesionalDao;
	@Autowired
	private Mailer mailer;
	@Autowired
	private ProfesionalDAO profesionalDao;
	private static final String PATH_ARCHIVO = "F:\\Facu\\workspace\\files\\";

	public Sesion save(SesionDTO session) {
		try {
			PracticaProfesional practicaProfesional = practicaProfesionalDao.findById(session.getPracticaProfesionalId());
			File archivo = new File(PATH_ARCHIVO + session.getNombreArchivo());
			archivo.createNewFile();
			FileWriter myWriter = new FileWriter(archivo);
			myWriter.write(session.getContenido());
			myWriter.flush();
			myWriter.close();
			return sesionDao.save(Sesion.fromDTO(session, practicaProfesional, PATH_ARCHIVO));
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

	public List<SesionDTO> getAllSesionesByPractica(Integer id) {
		return sesionDao.findAllByPractica(id).stream().map(Sesion::toDTO).collect(Collectors.toList());
	}

	public SesionDTO delete(Integer id) {
		Sesion sesion = sesionDao.findById(id);
		sesionDao.delete(sesion);
		return sesion.toDTO();
	}

	public SesionDTO compartir(Integer sesionId, Integer profesionalId, String comentario) {
		Sesion sesion = sesionDao.findById(sesionId);
		Profesional profesional = profesionalDao.findById(profesionalId);

		if (!Objects.isNull(profesional.getEmail())) {
			mailer.sendMail(profesional.getEmail(), "Se le ha compartido una sesión",
					mailer.getSesionMessageBody(sesion, true, comentario), sesion.getArchivo());
		}

		return sesion.toDTO();
	}
}
