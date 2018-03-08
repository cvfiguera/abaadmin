package cl.abaadmin.vo;

public class FiltroOperadoraVO {
	
	private Integer id;
	private String sftp;
	private String nombre;
	
	public FiltroOperadoraVO() {
		super();
	}

	public FiltroOperadoraVO(Integer id, String sftp, String nombre) {
		super();
		this.id = id;
		this.sftp = sftp;
		this.nombre = nombre;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getSftp() {
		return sftp;
	}

	public void setSftp(String sftp) {
		this.sftp = sftp;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
}
