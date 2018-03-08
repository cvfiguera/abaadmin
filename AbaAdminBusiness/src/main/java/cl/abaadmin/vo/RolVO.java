package cl.abaadmin.vo;

public class RolVO {
	
	private Integer rolId;
	private String nombre;
	private String descripcion;
	
	public RolVO() {
		super();
	}

	public RolVO(Integer rolId, String nombre, String descripcion) {
		super();
		this.rolId = rolId;
		this.nombre = nombre;
		this.descripcion = descripcion;
	}

	public Integer getRolId() {
		return rolId;
	}

	public void setRolId(Integer rolId) {
		this.rolId = rolId;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}	
}
