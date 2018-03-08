package cl.abaadmin.vo;

public class ConcursoVO {
	
	private Integer concursoId;
	private String nombre;
	private String fechaInicio;
	private String fechaTermino;
	private String comentarios;
	
	public ConcursoVO() {
		super();
	}

	public ConcursoVO(Integer concursoId, String nombre, String fechaInicio, String fechaTermino, String comentarios) {
		super();
		this.concursoId = concursoId;
		this.nombre = nombre;
		this.fechaInicio = fechaInicio;
		this.fechaTermino = fechaTermino;
		this.comentarios = comentarios;
	}

	public Integer getConcursoId() {
		return concursoId;
	}

	public void setConcursoId(Integer concursoId) {
		this.concursoId = concursoId;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getFechaInicio() {
		return fechaInicio;
	}

	public void setFechaInicio(String fechaInicio) {
		this.fechaInicio = fechaInicio;
	}

	public String getFechaTermino() {
		return fechaTermino;
	}

	public void setFechaTermino(String fechaTermino) {
		this.fechaTermino = fechaTermino;
	}

	public String getComentarios() {
		return comentarios;
	}

	public void setComentarios(String comentarios) {
		this.comentarios = comentarios;
	}
}
