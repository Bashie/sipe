package sipe.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import sipe.dao.TutorDAO;
import sipe.model.Tutor;

@Component
public class TutorService {
	@Autowired
	private TutorDAO tutorDao;
	
	public List<Tutor> getAllTutores() {
		return tutorDao.findAll();
	}

	public Tutor findById(Integer id) {
		return tutorDao.findById(id);
	}

	public void persist(Tutor tutor) {
		tutorDao.persist(tutor);
	}
	
}
