package sipe.dao;

import java.util.List;

import javax.persistence.TypedQuery;

import org.springframework.stereotype.Component;

import sipe.model.PracticaProfesional;
import sipe.model.Sesion;

@Component
public class SesionDAO extends BaseDAO<Sesion> {

    public SesionDAO() {
    }
 
    public List<Sesion> findAll() {
		TypedQuery<Sesion> q = entityManager.createQuery("select t from sesion t", Sesion.class);

		return q.getResultList();
	}
    public List<Sesion> findAllByPractica(Integer id) {
		TypedQuery<Sesion> q = entityManager.createQuery("select t from Sesion t where practicaProfesional.id = " + id, Sesion.class);

		return q.getResultList();
	}
}