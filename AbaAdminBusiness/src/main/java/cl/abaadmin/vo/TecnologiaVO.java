package cl.abaadmin.vo;

public class TecnologiaVO {
	
	private Integer tecnologiaId;
	private String nombre;
	private String observacion;
	
	public TecnologiaVO() {
		super();
	}

	public TecnologiaVO(Integer tecnologiaId, String nombre, String observacion) {
		super();
		this.tecnologiaId = tecnologiaId;
		this.nombre = nombre;
		this.observacion = observacion;
	}

	public Integer getTecnologiaId() {
		return tecnologiaId;
	}

	public void setTecnologiaId(Integer tecnologiaId) {
		this.tecnologiaId = tecnologiaId;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getObservacion() {
		return observacion;
	}

	public void setObservacion(String observacion) {
		this.observacion = observacion;
	}
}
