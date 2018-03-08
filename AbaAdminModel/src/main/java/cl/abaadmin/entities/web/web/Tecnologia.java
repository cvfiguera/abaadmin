package cl.abaadmin.entities.web.web;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import org.hibernate.annotations.GenericGenerator;

@Entity
@Table(name="tecnologias", schema="web")
public class Tecnologia implements java.io.Serializable {


	private static final long serialVersionUID = -2428713345620687607L;
	@Id
	@GenericGenerator(name="idgen" , strategy="increment")
	@GeneratedValue(generator="idgen")
	@Column(name = "tecnologia_id", nullable = false, updatable = false)
	private int tecnologiaId;
	@Column(name = "nombre_tx")
	private String nombre;
	@Column(name = "observacion_tx")
	private String observacion;
	
	public Tecnologia() {
		super();
	}

	public Tecnologia(int tecnologiaId, String nombre, String observacion) {
		super();
		this.tecnologiaId = tecnologiaId;
		this.nombre = nombre;
		this.observacion = observacion;
	}

	public int getTecnologiaId() {
		return tecnologiaId;
	}

	public void setTecnologiaId(int tecnologiaId) {
		this.tecnologiaId = tecnologiaId;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getObservacion() {
		return observacion;
	}

	public void setObservacion(String observacion) {
		this.observacion = observacion;
	}
}
