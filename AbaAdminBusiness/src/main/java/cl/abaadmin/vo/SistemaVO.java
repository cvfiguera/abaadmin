package cl.abaadmin.vo;

import java.util.List;

public class SistemaVO implements java.io.Serializable {

	private static final long serialVersionUID = 5350264176609531169L;
	private Integer id;
	private String nombre;
	private List<RolVO> roles;
	
	public SistemaVO() {
		super();
	}

	public SistemaVO(Integer id, String nombre, List<RolVO> roles) {
		super();
		this.id = id;
		this.nombre = nombre;
		this.roles = roles;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public List<RolVO> getRoles() {
		return roles;
	}

	public void setRoles(List<RolVO> roles) {
		this.roles = roles;
	}
}
