package cl.abaadmin.entities.web.web;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import org.hibernate.annotations.GenericGenerator;

@Entity
@Table(name="rbd", schema="web")
public class Rbd implements java.io.Serializable {

	private static final long serialVersionUID = -6744067365927417531L;
	@Id @GenericGenerator(name="idgen" , strategy="increment")
	@GeneratedValue(generator="idgen")
	@Column(name= "rbd_id")
	private int rbdId;
	@Column(name= "rbd_nu")
	private Long rbd;
	@Column(name= "anexo_tx")
	private String anexo;
	@Column(name= "nombre_establecimiento_tx")
	private String nombre;
	@Column(name= "direccion_tx")
	private String direccion;
	@Column(name= "num_alumnos_nu")
	private Integer nAlumnos;
	@Column(name= "observacion_tx")
	private String observacion;
	@ManyToOne
	@JoinColumn(name= "comuna_id")
	private Comuna comuna;
	
	public Rbd() {
		super();
	}

	public Rbd(int rbdId, Long rbd, String anexo, String nombre, String direccion, Integer nAlumnos,
			String observacion, Comuna comuna) {
		super();
		this.rbdId = rbdId;
		this.rbd = rbd;
		this.anexo = anexo;
		this.nombre = nombre;
		this.direccion = direccion;
		this.nAlumnos = nAlumnos;
		this.observacion = observacion;
		this.comuna = comuna;
	}

	public int getRbdId() {
		return rbdId;
	}

	public void setRbdId(int rbdId) {
		this.rbdId = rbdId;
	}

	public Long getRbd() {
		return rbd;
	}

	public void setRbd(Long rbd) {
		this.rbd = rbd;
	}

	public String getAnexo() {
		return anexo;
	}

	public void setAnexo(String anexo) {
		this.anexo = anexo;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getDireccion() {
		return direccion;
	}

	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}

	public Integer getnAlumnos() {
		return nAlumnos;
	}

	public void setnAlumnos(Integer nAlumnos) {
		this.nAlumnos = nAlumnos;
	}

	public String getObservacion() {
		return observacion;
	}

	public void setObservacion(String observacion) {
		this.observacion = observacion;
	}

	public Comuna getComuna() {
		return comuna;
	}

	public void setComuna(Comuna comuna) {
		this.comuna = comuna;
	}
}
