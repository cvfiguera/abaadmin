package cl.abaadmin.entities.web.security;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "roles", schema = "security")
public class Role implements java.io.Serializable {

	private static final long serialVersionUID = -7536075735230179533L;
	@Id
	@Column(name = "rol_id", nullable = false, updatable = false)
	private int roleId;
	@Column(name = "nombre_rol", nullable = false)
	private String name;
	@Column(name = "descripcion")
	private String description;
	
	public Role() {
		super();
	}

	public Role(int roleId, String name, String description) {
		super();
		this.roleId = roleId;
		this.name = name;
		this.description = description;
	}

	public int getRoleId() {
		return roleId;
	}

	public void setRoleId(int roleId) {
		this.roleId = roleId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

}
