package cl.abaadmin.entities.web.web;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

@Entity
@Table(name="operadoras", schema="web")
public class Operadora implements java.io.Serializable {

	private static final long serialVersionUID = -1632027078064279773L;
	@Id
	@GenericGenerator(name="idgen" , strategy="increment")
	@GeneratedValue(generator="idgen")
	@Column(name = "operadora_id", nullable = false, updatable = false)
	private int operadoraId;
	@Column(name="rut", nullable = false, unique = true)
	private String rut;
	@Column(name="nombre_social_tx", nullable = false)
	private String nombre;
	@Column(name="alias_tx")
	private String alias;
	@Column(name="observacion_tx")
	private String observacion;
	@Column(name="usuario_sftp")
	private String usuarioSFTP;
	
	public Operadora() {
		super();
	}

	public Operadora(int operadoraId, String rut, String nombre, String alias, String observacion, String usuarioSFTP) {
		super();
		this.operadoraId = operadoraId;
		this.rut = rut;
		this.nombre = nombre;
		this.alias = alias;
		this.observacion = observacion;
		this.usuarioSFTP = usuarioSFTP;
	}

	public int getOperadoraId() {
		return operadoraId;
	}

	public void setOperadoraId(int operadoraId) {
		this.operadoraId = operadoraId;
	}

	public String getRut() {
		return rut;
	}

	public void setRut(String rut) {
		this.rut = rut;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getAlias() {
		return alias;
	}

	public void setAlias(String alias) {
		this.alias = alias;
	}

	public String getObservacion() {
		return observacion;
	}

	public void setObservacion(String observacion) {
		this.observacion = observacion;
	}

	public String getUsuarioSFTP() {
		return usuarioSFTP;
	}

	public void setUsuarioSFTP(String usuarioSFTP) {
		this.usuarioSFTP = usuarioSFTP;
	}
}
