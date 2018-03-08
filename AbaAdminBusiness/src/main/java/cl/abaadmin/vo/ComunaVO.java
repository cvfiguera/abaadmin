package cl.abaadmin.vo;

public class ComunaVO {
	
	private Integer comunaId;
	private Integer numero;
	private String nombre;
	private RegionVO region;
	
	public ComunaVO() {
		super();
	}

	public ComunaVO(Integer comunaId, Integer numero, String nombre, RegionVO region) {
		super();
		this.comunaId = comunaId;
		this.numero = numero;
		this.nombre = nombre;
		this.region = region;
	}

	public Integer getComunaId() {
		return comunaId;
	}

	public void setComunaId(Integer comunaId) {
		this.comunaId = comunaId;
	}

	public Integer getNumero() {
		return numero;
	}

	public void setNumero(Integer numero) {
		this.numero = numero;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public RegionVO getRegion() {
		return region;
	}

	public void setRegion(RegionVO region) {
		this.region = region;
	}
}
