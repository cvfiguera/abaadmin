package cl.abaadmin.vo;

public class EstadoVO {
	
	private Integer estadoId;
	private String descripcion;
	
	public EstadoVO() {
		super();
	}

	public EstadoVO(Integer estadoId, String descripcion) {
		super();
		this.estadoId = estadoId;
		this.descripcion = descripcion;
	}

	public Integer getEstadoId() {
		return estadoId;
	}

	public void setEstadoId(Integer estadoId) {
		this.estadoId = estadoId;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}
}
