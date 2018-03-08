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
@Table(name="adjudicado_estados", schema="web")
public class EstadoAdjudicacion implements java.io.Serializable {

	private static final long serialVersionUID = -5328431023633597397L;
	@Id @GenericGenerator(name="idgen" , strategy="increment") @GeneratedValue(generator="idgen")
	@Column(name = "adjudicado_estado_id", nullable = false, updatable = false)
	private int estadoId;
	@ManyToOne
	@JoinColumn(name = "adj_adjudicado_estado_id", referencedColumnName = "adjudicado_estado_id")
	private EstadoAdjudicacion padre;
	@Column(name = "adjudicado_estado_tx")
	private String descripcion;
	
	public EstadoAdjudicacion() {
		super();
	}

	public EstadoAdjudicacion(int estadoId, EstadoAdjudicacion padreId, String descripcion) {
		super();
		this.estadoId = estadoId;
		this.padre = padre;
		this.descripcion = descripcion;
	}

	public int getEstadoId() {
		return estadoId;
	}

	public void setEstadoId(int estadoId) {
		this.estadoId = estadoId;
	}

	public EstadoAdjudicacion getPadre() {
		return padre;
	}

	public void setPadre(EstadoAdjudicacion padre) {
		this.padre = padre;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}
}
