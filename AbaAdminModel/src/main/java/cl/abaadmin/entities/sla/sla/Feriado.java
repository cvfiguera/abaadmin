package cl.abaadmin.entities.sla.sla;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

@Entity
@Table(name = "feriados", schema= "sla")
public class Feriado implements java.io.Serializable {
	
	private static final long serialVersionUID = -2046375299171343132L;
	@Id @GenericGenerator(name="idgen" , strategy="increment")
	@GeneratedValue(generator="idgen")
	@Column(name = "feriado_id", nullable = false, updatable = false)
	private int feriadoId;
	private Date fecha;
	private String motivo;
	
	public Feriado() {
		super();
	}

	public Feriado(int feriadoId, Date fecha, String motivo) {
		super();
		this.feriadoId = feriadoId;
		this.fecha = fecha;
		this.motivo = motivo;
	}

	public int getFeriadoId() {
		return feriadoId;
	}

	public void setFeriadoId(int feriadoId) {
		this.feriadoId = feriadoId;
	}

	public Date getFecha() {
		return fecha;
	}

	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}

	public String getMotivo() {
		return motivo;
	}

	public void setMotivo(String motivo) {
		this.motivo = motivo;
	}
}
