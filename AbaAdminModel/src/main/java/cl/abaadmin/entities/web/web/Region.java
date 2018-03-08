package cl.abaadmin.entities.web.web;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="regiones", schema="web")
public class Region implements java.io.Serializable {

	private static final long serialVersionUID = -6941151831122517211L;
	@Id @GeneratedValue(strategy= GenerationType.AUTO)
	@Column(name="region_id")
	private int regionId;
	@Column(name="numero_region_tx")
	private Integer numero;
	@Column(name="nombre_region_tx")
	private String nombre;
	
	public Region() {
		super();
	}

	public Region(int regionId, Integer numero, String nombre) {
		super();
		this.regionId = regionId;
		this.numero = numero;
		this.nombre = nombre;
	}

	public int getRegionId() {
		return regionId;
	}

	public void setRegionId(int regionId) {
		this.regionId = regionId;
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
	
}
