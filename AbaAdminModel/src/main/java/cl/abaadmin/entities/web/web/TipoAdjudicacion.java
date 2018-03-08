package cl.abaadmin.entities.web.web;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

@Entity
@Table(name="tipo_adjudicaciones", schema="web")
public class TipoAdjudicacion implements java.io.Serializable {

	private static final long serialVersionUID = 7178867717447866081L;
	@Id @GenericGenerator(name="idgen" , strategy="increment")
	@GeneratedValue(generator="idgen")
	@Column(name = "tipo_adj_id", nullable = false, updatable = false)
	private int tipoAdjudicacionId;
	@Column(name="tipo_espera_tx")
	private String tipoAdjudicacion;
	@Column(name="descripcion_tx")
	private String descripcion;
	
	public TipoAdjudicacion() {
		super();
	}

	public TipoAdjudicacion(int tipoAdjudicacionId, String tipoAdjudicacion, String descripcion) {
		super();
		this.tipoAdjudicacionId = tipoAdjudicacionId;
		this.tipoAdjudicacion = tipoAdjudicacion;
		this.descripcion = descripcion;
	}

	public int getTipoAdjudicacionId() {
		return tipoAdjudicacionId;
	}

	public void setTipoAdjudicacionId(int tipoAdjudicacionId) {
		this.tipoAdjudicacionId = tipoAdjudicacionId;
	}

	public String getTipoAdjudicacion() {
		return tipoAdjudicacion;
	}

	public void setTipoAdjudicacion(String tipoAdjudicacion) {
		this.tipoAdjudicacion = tipoAdjudicacion;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}
}
