package sipe.dao;

import java.util.List;

import javax.persistence.TypedQuery;

import org.springframework.stereotype.Component;

import sipe.model.Profesional;

@Component
public class ProfesionalDAO extends BaseDAO<Profesional> {

    public ProfesionalDAO() {
    }
 
    public List<Profesional> findAll() {
		TypedQuery<Profesional> q = entityManager.createQuery("select t from Profesional t", Profesional.class);

		return q.getResultList();
	}
    
}