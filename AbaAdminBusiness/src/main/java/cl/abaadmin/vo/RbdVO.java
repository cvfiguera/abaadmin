package cl.abaadmin.vo;

public class RbdVO {
	
	private Integer rbdId;
	private Long rbd;
	private String nombre;
	private String direccion;
	private Integer nAlumnos;
	private String observacion;
	private ComunaVO comuna;
	
	public RbdVO() {
		super();
	}

	public RbdVO(Integer rbdId, Long rbd, String nombre, String direccion, Integer nAlumnos, String observacion,
			ComunaVO comuna) {
		super();
		this.rbdId = rbdId;
		this.rbd = rbd;
		this.nombre = nombre;
		this.direccion = direccion;
		this.nAlumnos = nAlumnos;
		this.observacion = observacion;
		this.comuna = comuna;
	}

	public Integer getRbdId() {
		return rbdId;
	}

	public void setRbdId(Integer rbdId) {
		this.rbdId = rbdId;
	}

	public Long getRbd() {
		return rbd;
	}

	public void setRbd(Long rbd) {
		this.rbd = rbd;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getDireccion() {
		return direccion;
	}

	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}

	public Integer getnAlumnos() {
		return nAlumnos;
	}

	public void setnAlumnos(Integer nAlumnos) {
		this.nAlumnos = nAlumnos;
	}

	public String getObservacion() {
		return observacion;
	}

	public void setObservacion(String observacion) {
		this.observacion = observacion;
	}

	public ComunaVO getComuna() {
		return comuna;
	}

	public void setComuna(ComunaVO comuna) {
		this.comuna = comuna;
	}
}
