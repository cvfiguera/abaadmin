package cl.abaadmin.vo;

public class SubEstadoVO {

	private Integer estadoId;
	private EstadoVO padre;
	private String descripcion;
	
	public SubEstadoVO() {
		super();
	}

	public SubEstadoVO(Integer estadoId, EstadoVO padre, String descripcion) {
		super();
		this.estadoId = estadoId;
		this.padre = padre;
		this.descripcion = descripcion;
	}

	public Integer getEstadoId() {
		return estadoId;
	}

	public void setEstadoId(Integer estadoId) {
		this.estadoId = estadoId;
	}

	public EstadoVO getPadre() {
		return padre;
	}

	public void setPadre(EstadoVO padre) {
		this.padre = padre;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}
}
