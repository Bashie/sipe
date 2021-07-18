package sipe.dao;

import java.util.List;

import javax.persistence.TypedQuery;

import org.springframework.stereotype.Component;

import sipe.model.PracticaProfesional;

@Component
public class PracticaProfesionalDAO extends BaseDAO<PracticaProfesional> {

    public PracticaProfesionalDAO() {
    }
 
    public List<PracticaProfesional> findAll() {
		TypedQuery<PracticaProfesional> q = entityManager.createQuery("select t from PracticaProfesional t", PracticaProfesional.class);

		return q.getResultList();
	}
    
    public List<PracticaProfesional> findAllByProfesional(Long id) {
		TypedQuery<PracticaProfesional> q = entityManager.createQuery("select t from PracticaProfesional t where profesional.id = " + id, PracticaProfesional.class);

		return q.getResultList();
	}
    
}