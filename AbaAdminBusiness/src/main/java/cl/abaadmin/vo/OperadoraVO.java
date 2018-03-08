package cl.abaadmin.vo;

public class OperadoraVO {
	
	private Integer operadoraId;
	private String rut;
	private String nombre;
	private String alias;
	private String observacion;
	
	public OperadoraVO() {
		super();
	}

	public OperadoraVO(Integer operadoraId, String rut, String nombre, String alias, String observacion) {
		super();
		this.operadoraId = operadoraId;
		this.rut = rut;
		this.nombre = nombre;
		this.alias = alias;
		this.observacion = observacion;
	}

	public Integer getOperadoraId() {
		return operadoraId;
	}

	public void setOperadoraId(Integer operadoraId) {
		this.operadoraId = operadoraId;
	}

	public String getRut() {
		return rut;
	}

	public void setRut(String rut) {
		this.rut = rut;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getAlias() {
		return alias;
	}

	public void setAlias(String alias) {
		this.alias = alias;
	}

	public String getObservacion() {
		return observacion;
	}

	public void setObservacion(String observacion) {
		this.observacion = observacion;
	}

}
