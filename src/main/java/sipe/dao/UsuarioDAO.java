package sipe.dao;

import java.util.List;

import javax.persistence.NoResultException;
import javax.persistence.TypedQuery;

import org.springframework.stereotype.Component;

import sipe.model.Usuario;

@Component
public class UsuarioDAO extends BaseDAO<Usuario> {

    public UsuarioDAO() {
    }
 
    public List<Usuario> findAll() {
		TypedQuery<Usuario> q = entityManager.createQuery("select t from Usuario t", Usuario.class);
		return q.getResultList();
	}

	public Usuario findByUsername(String username) throws NoResultException {
		TypedQuery<Usuario> q = entityManager.createQuery("select t from Usuario t where dni=:username", Usuario.class).setParameter("username", Integer.parseInt(username));
		return q.getSingleResult();
	}
    
}