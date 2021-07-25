package sipe.model;

import java.io.Serializable;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinColumns;
import javax.persistence.MapsId;
import javax.persistence.OneToOne;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

import sipe.controller.dto.UsuarioDTO;

@Entity
@Table(name = "Usuario")
@PrimaryKeyJoinColumn(name = "dni")
public class Usuario implements Guardable, Serializable {
	private static final long serialVersionUID = 7993715622903491479L;
	
	public enum TipoUsuario {
		  TUTOR(0),
		  PROFESIONAL(1);
		private final Integer id;
		private TipoUsuario(Integer id) {
			this.id = id;
	    }
		public Integer getId() {
	        return id;
	    }
	}
	@Id
	private Integer dni;
	private String encryptedPassword;
	private TipoUsuario type;
	@MapsId
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumns(value = {
		@JoinColumn(name = "persona", referencedColumnName = "dni")
	})
	private Persona persona;

	public Usuario() {
		
	}
	
	public UsuarioDTO toDTO() {
		UsuarioDTO dto = new UsuarioDTO();
		dto.setDni(getDni());
		dto.setApellido(getPersona().getApellido());
		dto.setNombre(getPersona().getNombre());
		dto.setEmail(getPersona().getEmail());
		return dto;
	}
	
	public Integer getDni() {
		return dni;
	}
	public void setDni(Integer dni) {
		this.dni = dni;
	}
	public String getEncryptedPassword() {
		return encryptedPassword;
	}
	public void setEncryptedPassword(String encryptedPassword) {
		this.encryptedPassword = encryptedPassword;
	}
	public TipoUsuario getType() {
		return type;
	}
	public void setType(TipoUsuario type) {
		this.type = type;
	}
	public Persona getPersona() {
		return persona;
	}
	public void setPersona(Persona persona) {
		this.persona = persona;
	}

	@Override
	public Integer getId() {
		return persona.getDni();
	}
}
