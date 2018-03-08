package cl.abaadmin.vo;

public class ListaEsperaVO {
	
	private Integer listaEsperaId;
	private Double velocidadSubida;
	private Double velocidadBajada;
	private Double precio;
	private Integer tipoAdjudicacion;
	private Integer operadoraId;
	private String operadora;
	private Integer tecnologiaId;
	private String tecnologia;
	private Integer rbdId;
	private Long rbd;
	private Integer concursoId;
	private String concurso;
	
	public ListaEsperaVO() {
		super();
	}

	public ListaEsperaVO(Integer listaEsperaId, Double velocidadSubida, Double velocidadBajada, Double precio,
			Integer tipoAdjudicacion, Integer operadoraId, String operadora, Integer tecnologiaId, String tecnologia,
			Integer rbdId, Long rbd, Integer concursoId, String concurso) {
		super();
		this.listaEsperaId = listaEsperaId;
		this.velocidadSubida = velocidadSubida;
		this.velocidadBajada = velocidadBajada;
		this.precio = precio;
		this.tipoAdjudicacion = tipoAdjudicacion;
		this.operadoraId = operadoraId;
		this.operadora = operadora;
		this.tecnologiaId = tecnologiaId;
		this.tecnologia = tecnologia;
		this.rbdId = rbdId;
		this.rbd = rbd;
		this.concursoId = concursoId;
		this.concurso = concurso;
	}

	public Integer getListaEsperaId() {
		return listaEsperaId;
	}

	public void setListaEsperaId(Integer listaEsperaId) {
		this.listaEsperaId = listaEsperaId;
	}

	public Double getVelocidadSubida() {
		return velocidadSubida;
	}

	public void setVelocidadSubida(Double velocidadSubida) {
		this.velocidadSubida = velocidadSubida;
	}

	public Double getVelocidadBajada() {
		return velocidadBajada;
	}

	public void setVelocidadBajada(Double velocidadBajada) {
		this.velocidadBajada = velocidadBajada;
	}

	public Double getPrecio() {
		return precio;
	}

	public void setPrecio(Double precio) {
		this.precio = precio;
	}

	public Integer getTipoAdjudicacion() {
		return tipoAdjudicacion;
	}

	public void setTipoAdjudicacion(Integer tipoAdjudicacion) {
		this.tipoAdjudicacion = tipoAdjudicacion;
	}

	public Integer getOperadoraId() {
		return operadoraId;
	}

	public void setOperadoraId(Integer operadoraId) {
		this.operadoraId = operadoraId;
	}

	public String getOperadora() {
		return operadora;
	}

	public void setOperadora(String operadora) {
		this.operadora = operadora;
	}

	public Integer getTecnologiaId() {
		return tecnologiaId;
	}

	public void setTecnologiaId(Integer tecnologiaId) {
		this.tecnologiaId = tecnologiaId;
	}

	public String getTecnologia() {
		return tecnologia;
	}

	public void setTecnologia(String tecnologia) {
		this.tecnologia = tecnologia;
	}

	public Integer getRbdId() {
		return rbdId;
	}

	public void setRbdId(Integer rbdId) {
		this.rbdId = rbdId;
	}

	public Long getRbd() {
		return rbd;
	}

	public void setRbd(Long rbd) {
		this.rbd = rbd;
	}

	public Integer getConcursoId() {
		return concursoId;
	}

	public void setConcursoId(Integer concursoId) {
		this.concursoId = concursoId;
	}

	public String getConcurso() {
		return concurso;
	}

	public void setConcurso(String concurso) {
		this.concurso = concurso;
	}
}
