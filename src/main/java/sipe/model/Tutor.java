package sipe.model;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;


@Entity
@Table(name = "tutor")
@PrimaryKeyJoinColumn(name = "dni")
public class Tutor extends Persona {
	@OneToOne(cascade = CascadeType.ALL)
	private Persona hijo;
	@OneToMany(cascade =
        {
                CascadeType.DETACH,
                CascadeType.MERGE,
                CascadeType.REFRESH,
                CascadeType.PERSIST
        })
	private List<PracticaProfesional> practicas;
	
	public Persona getHijo() {
		return hijo;
	}
	public void setHijo(Persona hijo) {
		this.hijo = hijo;
	}
	
	public List<PracticaProfesional> getPracticas() {
		return practicas;
	}
	public void setPracticas(List<PracticaProfesional> practicas) {
		this.practicas = practicas;
	}

	public void addPractica(PracticaProfesional practica) {
		if(Objects.isNull(practicas)) {
			practicas = new ArrayList<>();
		}
		this.practicas.add(practica);
	}

	
	@Override
	public String toString() {
		return "Tutor [hijo=" + hijo + ", parent=" + super.toString() + "]";
	}
}
