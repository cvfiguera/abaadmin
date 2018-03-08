package cl.abaadmin.vo;

public class UsuarioVO {
	
	private Integer usuarioId;
	private String username;
	private String password;
	private String email;
	private Boolean bloqueado;
	private Integer intentos;
	private Integer intentosMax;
	private String rut;
	private String telefono;
	private String organizacion;
	private String nombre;
	private String apellido;
	private Integer rolId;
	
	public UsuarioVO() {
		super();
	}

	public UsuarioVO(Integer usuarioId, String username, String password, String email, Boolean bloqueado,
			Integer intentos, Integer intentosMax, String rut, String telefono, String organizacion, String nombre,
			String apellido, Integer rolId) {
		super();
		this.usuarioId = usuarioId;
		this.username = username;
		this.password = password;
		this.email = email;
		this.bloqueado = bloqueado;
		this.intentos = intentos;
		this.intentosMax = intentosMax;
		this.rut = rut;
		this.telefono = telefono;
		this.organizacion = organizacion;
		this.nombre = nombre;
		this.apellido = apellido;
		this.rolId = rolId;
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

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Boolean getBloqueado() {
		return bloqueado;
	}

	public void setBloqueado(Boolean bloqueado) {
		this.bloqueado = bloqueado;
	}

	public Integer getIntentos() {
		return intentos;
	}

	public void setIntentos(Integer intentos) {
		this.intentos = intentos;
	}

	public Integer getIntentosMax() {
		return intentosMax;
	}

	public void setIntentosMax(Integer intentosMax) {
		this.intentosMax = intentosMax;
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

	public Integer getRolId() {
		return rolId;
	}

	public void setRolId(Integer rolId) {
		this.rolId = rolId;
	}
}
