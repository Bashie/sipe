package sipe.model;

import javax.persistence.Entity;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

@Entity
@Table(name = "Profesional")
@PrimaryKeyJoinColumn(name = "dni")
public class Profesional extends Persona {
	private String areaDesarrollo;

	public String getAreaDesarrollo() {
		return areaDesarrollo;
	}

	public void setAreaDesarrollo(String areaDesarrollo) {
		this.areaDesarrollo = areaDesarrollo;
	}

	@Override
	public String toString() {
		return "Profesional [areaDesarrollo=" + areaDesarrollo + ", getNombre()=" + getNombre() + ", getApellido()="
				+ getApellido() + ", getDni()=" + getDni() + "]";
	}
}
