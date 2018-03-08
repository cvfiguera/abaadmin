package cl.abaadmin.entities.hist.facturaciones;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import org.hibernate.annotations.GenericGenerator;

@Entity
@Table(name="comunas", schema="facturaciones")
public class Comuna implements java.io.Serializable {

	private static final long serialVersionUID = -2325086960547431575L;
	@Id
	@GenericGenerator(name="idgen" , strategy="increment")
	@GeneratedValue(generator="idgen")
	@Column(name = "comuna_id", nullable = false, updatable = false)
	private Integer comunaId;
	private String nombre;
	@ManyToOne
	@JoinColumn(name= "region_id")
	private Region region;
	
	public Comuna() {
		super();
	}

	public Comuna(Integer comunaId, String nombre, Region region) {
		super();
		this.comunaId = comunaId;
		this.nombre = nombre;
		this.region = region;
	}

	public Integer getComunaId() {
		return comunaId;
	}

	public void setComunaId(Integer comunaId) {
		this.comunaId = comunaId;
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
