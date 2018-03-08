package cl.abaadmin.vo;

import java.util.List;

public class RegionVO {
	
	private Integer regionId;
	private Integer numero;
	private String nombre;
	
	public RegionVO() {
		super();
	}

	public RegionVO(Integer regionId, Integer numero, String nombre) {
		super();
		this.regionId = regionId;
		this.numero = numero;
		this.nombre = nombre;
	}

	public Integer getRegionId() {
		return regionId;
	}

	public void setRegionId(Integer regionId) {
		this.regionId = regionId;
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
}
