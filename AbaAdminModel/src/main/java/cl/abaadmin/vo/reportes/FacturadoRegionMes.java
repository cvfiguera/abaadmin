package cl.abaadmin.vo.reportes;

import java.math.BigDecimal;

public class FacturadoRegionMes implements java.io.Serializable {
	
	private static final long serialVersionUID = -5955219699383618300L;
	private Integer regionId;
	private String region;
	private Integer anio;
	private Integer mes;
	private BigDecimal total;
	
	public FacturadoRegionMes() {
		super();
	}

	public FacturadoRegionMes(Integer regionId, String region, Integer anio, Integer mes, BigDecimal total) {
		super();
		this.regionId = regionId;
		this.region = region;
		this.anio = anio;
		this.mes = mes;
		this.total = total;
	}

	public Integer getRegionId() {
		return regionId;
	}

	public void setRegionId(Integer regionId) {
		this.regionId = regionId;
	}

	public String getRegion() {
		return region;
	}

	public void setRegion(String region) {
		this.region = region;
	}

	public Integer getAnio() {
		return anio;
	}

	public void setAnio(Integer anio) {
		this.anio = anio;
	}

	public Integer getMes() {
		return mes;
	}

	public void setMes(Integer mes) {
		this.mes = mes;
	}

	public BigDecimal getTotal() {
		return total;
	}

	public void setTotal(BigDecimal total) {
		this.total = total;
	}
}
