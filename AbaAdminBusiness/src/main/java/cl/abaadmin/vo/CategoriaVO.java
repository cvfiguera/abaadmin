package cl.abaadmin.vo;

public class CategoriaVO {
	
	private Integer id;
	private String descripcion;
	
	
	public CategoriaVO() {
		super();
	}
	
	public CategoriaVO(Integer id, String descripcion) {
		super();
		this.id = id;
		this.descripcion = descripcion;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}
}
