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
@Table(name="rbd_concursos", schema="web")
public class RbdConcurso implements java.io.Serializable {

	private static final long serialVersionUID = 3755952765398308973L;
	@Id @GenericGenerator(name="idgen" , strategy="increment")
	@GeneratedValue(generator="idgen")
	@Column(name = "rbd_concurso_id", nullable = false, updatable = false)
	private int rbdConcursoId;
	@Column(name = "marca_parque")
	private String marcaParque;
	@Column(name = "fecha_fin")
	private Date fechaFin;
	@ManyToOne @JoinColumn(name = "concurso_id")
	private Concurso concurso;
	@ManyToOne @JoinColumn(name = "rbd_id")
	private Rbd rbd;
	
	public RbdConcurso() {
		super();
	}

	public RbdConcurso(int rbdConcursoId, String marcaParque, Date fechaFin, Concurso concurso, Rbd rbd) {
		super();
		this.rbdConcursoId = rbdConcursoId;
		this.marcaParque = marcaParque;
		this.fechaFin = fechaFin;
		this.concurso = concurso;
		this.rbd = rbd;
	}

	public int getRbdConcursoId() {
		return rbdConcursoId;
	}

	public void setRbdConcursoId(int rbdConcursoId) {
		this.rbdConcursoId = rbdConcursoId;
	}

	public String getMarcaParque() {
		return marcaParque;
	}

	public void setMarcaParque(String marcaParque) {
		this.marcaParque = marcaParque;
	}

	public Date getFechaFin() {
		return fechaFin;
	}

	public void setFechaFin(Date fechaFin) {
		this.fechaFin = fechaFin;
	}

	public Concurso getConcurso() {
		return concurso;
	}

	public void setConcurso(Concurso concurso) {
		this.concurso = concurso;
	}

	public Rbd getRbd() {
		return rbd;
	}

	public void setRbd(Rbd rbd) {
		this.rbd = rbd;
	}
}
