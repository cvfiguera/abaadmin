package cl.abaadmin.vo;

public class ContactoVO {

	private Integer contactoId;
	private String nombre;
	private String cargo;
	private String telefono1;
	private String telefono2;
	private String email;
	private String fechaBaja;
	private Integer rbdId;
	
	public ContactoVO() {
		super();
	}

	public ContactoVO(Integer contactoId, String nombre, String cargo, String telefono1, String telefono2, String email,
			String fechaBaja, Integer rbdId) {
		super();
		this.contactoId = contactoId;
		this.nombre = nombre;
		this.cargo = cargo;
		this.telefono1 = telefono1;
		this.telefono2 = telefono2;
		this.email = email;
		this.fechaBaja = fechaBaja;
		this.rbdId = rbdId;
	}

	public Integer getContactoId() {
		return contactoId;
	}

	public void setContactoId(Integer contactoId) {
		this.contactoId = contactoId;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getCargo() {
		return cargo;
	}

	public void setCargo(String cargo) {
		this.cargo = cargo;
	}

	public String getTelefono1() {
		return telefono1;
	}

	public void setTelefono1(String telefono1) {
		this.telefono1 = telefono1;
	}

	public String getTelefono2() {
		return telefono2;
	}

	public void setTelefono2(String telefono2) {
		this.telefono2 = telefono2;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getFechaBaja() {
		return fechaBaja;
	}

	public void setFechaBaja(String fechaBaja) {
		this.fechaBaja = fechaBaja;
	}

	public Integer getRbdId() {
		return rbdId;
	}

	public void setRbdId(Integer rbdId) {
		this.rbdId = rbdId;
	}
}
