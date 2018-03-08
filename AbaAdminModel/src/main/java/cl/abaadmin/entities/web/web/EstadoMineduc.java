package cl.abaadmin.entities.web.web;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

@Entity
@Table(name="mineduc_estados", schema="web")
public class EstadoMineduc implements java.io.Serializable {

	private static final long serialVersionUID = -2707502107137778009L;
	@Id @GenericGenerator(name="idgen" , strategy="increment") @GeneratedValue(generator="idgen")
	@Column(name = "mineduc_estado_id", nullable = false, updatable = false)
	private int estadoId;
	@Column(name = "mineduc_estado_tx")
	private String descripcion;
	
	public EstadoMineduc() {
		super();
	}

	public EstadoMineduc(int estadoId, String descripcion) {
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
