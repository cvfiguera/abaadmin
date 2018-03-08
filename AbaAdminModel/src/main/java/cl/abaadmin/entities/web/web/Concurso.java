package cl.abaadmin.entities.web.web;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import org.hibernate.annotations.GenericGenerator;

@Entity
@Table(name="concursos", schema="web")
public class Concurso implements java.io.Serializable {

	private static final long serialVersionUID = 3494725837628606249L;
	@Id
	@GenericGenerator(name="idgen" , strategy="increment")
	@GeneratedValue(generator="idgen")
	@Column(name = "concurso_id", nullable = false, updatable = false)
	private int concursoId;
	private String nombre;
	@Column(name = "fecha_inicio")
	private Date fechaInicio;
	@Column(name = "fecha_termino")
	private Date fechaTermino;
	private String comentarios;
	
	public Concurso() {
		super();
	}

	public Concurso(int concursoId, String nombre, Date fechaInicio, Date fechaTermino, String comentarios) {
		super();
		this.concursoId = concursoId;
		this.nombre = nombre;
		this.fechaInicio = fechaInicio;
		this.fechaTermino = fechaTermino;
		this.comentarios = comentarios;
	}

	public int getConcursoId() {
		return concursoId;
	}

	public void setConcursoId(int concursoId) {
		this.concursoId = concursoId;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public Date getFechaInicio() {
		return fechaInicio;
	}

	public void setFechaInicio(Date fechaInicio) {
		this.fechaInicio = fechaInicio;
	}

	public Date getFechaTermino() {
		return fechaTermino;
	}

	public void setFechaTermino(Date fechaTermino) {
		this.fechaTermino = fechaTermino;
	}

	public String getComentarios() {
		return comentarios;
	}

	public void setComentarios(String comentarios) {
		this.comentarios = comentarios;
	}
}
