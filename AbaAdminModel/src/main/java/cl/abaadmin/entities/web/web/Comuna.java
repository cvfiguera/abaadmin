package cl.abaadmin.entities.web.web;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="comunas", schema="web")
public class Comuna implements java.io.Serializable {

	private static final long serialVersionUID = 6738923883876820428L;
	@Id @GeneratedValue(strategy= GenerationType.AUTO)
	@Column(name= "comuna_id")
	private int comunaId;
	@Column(name= "numero_comuna")
	private Integer numero;
	@Column(name="nombre_comuna_tx")
	private String nombre;
	@ManyToOne
	@JoinColumn(name= "region_id")
	private Region region;
	
	public Comuna() {
		super();
	}

	public Comuna(int comunaId, Integer numero, String nombre, Region region) {
		super();
		this.comunaId = comunaId;
		this.numero = numero;
		this.nombre = nombre;
		this.region = region;
	}

	public int getComunaId() {
		return comunaId;
	}

	public void setComunaId(int comunaId) {
		this.comunaId = comunaId;
	}

	public Integer getNumero() {
		return numero;
	}

	public void setNumero(Integer numero) {
		this.numero = numero;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public Region getRegion() {
		return region;
	}

	public void setRegion(Region region) {
		this.region = region;
	}
}
