package sipe.dao;

import java.util.List;

import javax.persistence.TypedQuery;

import org.springframework.stereotype.Component;

import sipe.model.Turno;

@Component
public class TurnoDAO extends BaseDAO<Turno> {

    public TurnoDAO() {
    }
 
    public List<Turno> findAll() {
		TypedQuery<Turno> q = entityManager.createQuery("select t from Turno t", Turno.class);

		return q.getResultList();
	}
    public List<Turno> findAllByPractica(Integer id) {
		TypedQuery<Turno> q = entityManager.createQuery("select t from Turno t where practicaProfesional.id = " + id, Turno.class);

		return q.getResultList();
	}

	public List<Turno> findAllByProfesional(Integer id, List<String> practicas) {
		TypedQuery<Turno> q = entityManager.createQuery("select t from Turno t where practicaProfesional.id in (" + String.join(",", practicas) + ")", Turno.class);
		return q.getResultList();
	}
}