package cl.abaadmin.entities.hist.facturaciones;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="regiones", schema="facturaciones")
public class Region implements java.io.Serializable {
	
	private static final long serialVersionUID = -1194032031154226957L;
	@Id @GeneratedValue(strategy= GenerationType.AUTO)
	@Column(name="region_id")
	private int regionId;
	private String nombre;
	private int numero;
	
	public Region() {
		super();
	}

	public Region(int regionId, String nombre, int numero) {
		super();
		this.regionId = regionId;
		this.nombre = nombre;
		this.numero = numero;
	}

	public int getRegionId() {
		return regionId;
	}

	public void setRegionId(int regionId) {
		this.regionId = regionId;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public int getNumero() {
		return numero;
	}

	public void setNumero(int numero) {
		this.numero = numero;
	}
}
