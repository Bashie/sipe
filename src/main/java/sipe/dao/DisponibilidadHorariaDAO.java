package sipe.dao;

import java.time.LocalDateTime;
import java.time.ZoneOffset;
import java.util.Date;
import java.util.List;

import javax.persistence.TypedQuery;

import org.springframework.stereotype.Component;

import sipe.model.DisponibilidadHoraria;

@Component
public class DisponibilidadHorariaDAO extends BaseDAO<DisponibilidadHoraria> {

    public List<DisponibilidadHoraria> findAll() {
		TypedQuery<DisponibilidadHoraria> q = entityManager.createQuery("select t from DisponibilidadHoraria t", DisponibilidadHoraria.class);

		return q.getResultList();
	}

    public List<DisponibilidadHoraria> findAllByProfesional(Integer id) {
		TypedQuery<DisponibilidadHoraria> q = entityManager.createQuery("select t from DisponibilidadHoraria t where profesional.id = " + id, DisponibilidadHoraria.class);

		return q.getResultList();
	}
    
    public List<DisponibilidadHoraria> findAllByProfesionalDeLaFecha(Integer id, LocalDateTime fecha) {
		TypedQuery<DisponibilidadHoraria> q = entityManager.createQuery("select t from DisponibilidadHoraria t where profesional.id = " + id + " and DATE(inicio) = DATE(:fecha)" , DisponibilidadHoraria.class);
		q.setParameter("fecha", new Date(fecha.toEpochSecond(ZoneOffset.ofHours(-3))*1000));
		return q.getResultList();
	}
}
