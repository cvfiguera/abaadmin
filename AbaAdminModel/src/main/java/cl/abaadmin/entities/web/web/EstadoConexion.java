package cl.abaadmin.entities.web.web;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

@Entity
@Table(name="conectado_estados", schema="web")
public class EstadoConexion implements java.io.Serializable {

	private static final long serialVersionUID = -2512544237599108757L;
	@Id @GenericGenerator(name="idgen" , strategy="increment") @GeneratedValue(generator="idgen")
	@Column(name = "conectado_estado_id", nullable = false, updatable = false)
	private int estadoId;
	@Column(name = "conectado_estado_tx")
	private String descripcion;
	
	public EstadoConexion() {
		super();
	}

	public EstadoConexion(int estadoId, String descripcion) {
		super();
		this.estadoId = estadoId;
		this.descripcion = descripcion;
	}

	public int getEstadoId() {
		return estadoId;
	}

	public void setEstadoId(int estadoId) {
		this.estadoId = estadoId;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}
}
