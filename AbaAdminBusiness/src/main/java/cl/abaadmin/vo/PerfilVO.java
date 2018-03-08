package cl.abaadmin.vo;

public class PerfilVO {
	
	private Integer usuarioId;
	private String username;
	private String pass;
	private String newpass;
	private String email;
	private String rut;
	private String telefono;
	private String organizacion;
	private String nombre;
	private String apellido;
	private String rol;
	
	public PerfilVO() {
		super();
	}

	public PerfilVO(Integer usuarioId, String username, String pass, String newpass, String email, String rut,
			String telefono, String organizacion, String nombre, String apellido, String rol) {
		super();
		this.usuarioId = usuarioId;
		this.username = username;
		this.pass = pass;
		this.newpass = newpass;
		this.email = email;
		this.rut = rut;
		this.telefono = telefono;
		this.organizacion = organizacion;
		this.nombre = nombre;
		this.apellido = apellido;
		this.rol = rol;
	}

	public Integer getUsuarioId() {
		return usuarioId;
	}

	public void setUsuarioId(Integer usuarioId) {
		this.usuarioId = usuarioId;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPass() {
		return pass;
	}

	public void setPass(String pass) {
		this.pass = pass;
	}

	public String getNewpass() {
		return newpass;
	}

	public void setNewpass(String newpass) {
		this.newpass = newpass;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getRut() {
		return rut;
	}

	public void setRut(String rut) {
		this.rut = rut;
	}

	public String getTelefono() {
		return telefono;
	}

	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}

	public String getOrganizacion() {
		return organizacion;
	}

	public void setOrganizacion(String organizacion) {
		this.organizacion = organizacion;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getApellido() {
		return apellido;
	}

	public void setApellido(String apellido) {
		this.apellido = apellido;
	}

	public String getRol() {
		return rol;
	}

	public void setRol(String rol) {
		this.rol = rol;
	}
}
