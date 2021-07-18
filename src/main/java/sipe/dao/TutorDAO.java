package sipe.dao;

import java.util.List;

import javax.persistence.TypedQuery;

import org.springframework.stereotype.Component;

import sipe.model.Tutor;

@Component
public class TutorDAO extends BaseDAO<Tutor> {

    public TutorDAO() {
    }
 
    public List<Tutor> findAll() {
		TypedQuery<Tutor> q = entityManager.createQuery("select t from Tutor t", Tutor.class);
		return q.getResultList();
	}
}