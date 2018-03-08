package cl.abaadmin.entities.web.web;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

@Entity
@Table(name="contactos", schema="web")
public class Contacto implements java.io.Serializable {
	
	private static final long serialVersionUID = -4602325105107311534L;
	@Id
	@GenericGenerator(name="idgen" , strategy="increment")
	@GeneratedValue(generator="idgen")
	@Column(name = "contacto_id", nullable = false, updatable = false)
	private int contactoId;
	@Column(name = "nombre_tx")
	private String nombre;
	@Column(name = "cargo_tx")
	private String cargo;
	@Column(name = "telefono1_tx")
	private String telefono1;
	@Column(name = "telefono2_tx")
	private String telefono2;
	@Column(name = "mail_tx")
	private String email;
	@Column(name = "fecha_baja")
	private Date fechaBaja;
	@ManyToOne
	@JoinColumn(name= "rbd_id")
	private Rbd rbd;
	
	public Contacto() {
		super();
	}

	public Contacto(int contactoId, String nombre, String cargo, String telefono1, String telefono2, String email,
			Date fechaBaja, Rbd rbd) {
		super();
		this.contactoId = contactoId;
		this.nombre = nombre;
		this.cargo = cargo;
		this.telefono1 = telefono1;
		this.telefono2 = telefono2;
		this.email = email;
		this.fechaBaja = fechaBaja;
		this.rbd = rbd;
	}

	public int getContactoId() {
		return contactoId;
	}

	public void setContactoId(int contactoId) {
		this.contactoId = contactoId;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getCargo() {
		return cargo;
	}

	public void setCargo(String cargo) {
		this.cargo = cargo;
	}

	public String getTelefono1() {
		return telefono1;
	}

	public void setTelefono1(String telefono1) {
		this.telefono1 = telefono1;
	}

	public String getTelefono2() {
		return telefono2;
	}

	public void setTelefono2(String telefono2) {
		this.telefono2 = telefono2;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Date getFechaBaja() {
		return fechaBaja;
	}

	public void setFechaBaja(Date fechaBaja) {
		this.fechaBaja = fechaBaja;
	}

	public Rbd getRbd() {
		return rbd;
	}

	public void setRbd(Rbd rbd) {
		this.rbd = rbd;
	}	
}
