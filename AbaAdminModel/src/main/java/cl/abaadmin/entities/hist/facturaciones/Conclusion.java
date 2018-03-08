package cl.abaadmin.entities.hist.facturaciones;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

@Entity
@Table(name="conclusiones", schema="facturaciones")
public class Conclusion implements java.io.Serializable {

	private static final long serialVersionUID = -1529178777502557303L;
	@Id
	@GenericGenerator(name="idgen" , strategy="increment")
	@GeneratedValue(generator="idgen")
	@Column(name = "conclusion_id", nullable = false, updatable = false)
	private Integer conclusionId;
	private String conclusion;
	private String observacion;
	
	public Conclusion() {
		super();
	}

	public Conclusion(Integer conclusionId, String conclusion, String observacion) {
		super();
		this.conclusionId = conclusionId;
		this.conclusion = conclusion;
		this.observacion = observacion;
	}

	public Integer getConclusionId() {
		return conclusionId;
	}

	public void setConclusionId(Integer conclusionId) {
		this.conclusionId = conclusionId;
	}

	public String getConclusion() {
		return conclusion;
	}

	public void setConclusion(String conclusion) {
		this.conclusion = conclusion;
	}

	public String getObservacion() {
		return observacion;
	}

	public void setObservacion(String observacion) {
		this.observacion = observacion;
	}
}
