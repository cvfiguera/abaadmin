package cl.abaadmin.entities.hist.facturaciones;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

@Entity
@Table(name="facturaciones", schema="facturaciones")
public class Facturacion implements java.io.Serializable {

	private static final long serialVersionUID = -2294596258461210997L;
	@Id
	@GenericGenerator(name="idgen" , strategy="increment")
	@GeneratedValue(generator="idgen")
	@Column(name = "facturacion_id", nullable = false, updatable = false)
	private Integer facturacionId;
	@Column(name = "operadora_id", nullable = false)
	private Integer operadoraId;
	@Column(name="nombre", nullable = false)
	private String nombre;
	@Column(name="anio", nullable = false)
	private Integer anio;
	@Column(name="mes", nullable = false)
	private Integer mes;
	
	public Facturacion() {
		super();
	}

	public Facturacion(Integer facturacionId, Integer operadoraId, String nombre, Integer anio, Integer mes) {
		super();
		this.facturacionId = facturacionId;
		this.operadoraId = operadoraId;
		this.nombre = nombre;
		this.anio = anio;
		this.mes = mes;
	}

	public Integer getFacturacionId() {
		return facturacionId;
	}

	public void setFacturacionId(Integer facturacionId) {
		this.facturacionId = facturacionId;
	}

	public Integer getOperadoraId() {
		return operadoraId;
	}

	public void setOperadoraId(Integer operadoraId) {
		this.operadoraId = operadoraId;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public Integer getAnio() {
		return anio;
	}

	public void setAnio(Integer anio) {
		this.anio = anio;
	}

	public Integer getMes() {
		return mes;
	}

	public void setMes(Integer mes) {
		this.mes = mes;
	}
}
