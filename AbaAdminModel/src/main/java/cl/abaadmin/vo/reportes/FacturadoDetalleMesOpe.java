package cl.abaadmin.vo.reportes;

import java.math.BigDecimal;

public class FacturadoDetalleMesOpe implements java.io.Serializable {
	
	private static final long serialVersionUID = 2530993833623392089L;
	private Integer regionId;
	private String region;
	private Integer operadoraId;
	private String operadora;
	private Integer mes;
	private Integer anio;
	private BigDecimal total;
	
	public FacturadoDetalleMesOpe() {
		super();
	}

	public FacturadoDetalleMesOpe(Integer regionId, String region, Integer operadoraId, String operadora, Integer mes,
			Integer anio, BigDecimal total) {
		super();
		this.regionId = regionId;
		this.region = region;
		this.operadoraId = operadoraId;
		this.operadora = operadora;
		this.mes = mes;
		this.anio = anio;
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

	public Integer getOperadoraId() {
		return operadoraId;
	}

	public void setOperadoraId(Integer operadoraId) {
		this.operadoraId = operadoraId;
	}

	public String getOperadora() {
		return operadora;
	}

	public void setOperadora(String operadora) {
		this.operadora = operadora;
	}

	public Integer getMes() {
		return mes;
	}

	public void setMes(Integer mes) {
		this.mes = mes;
	}

	public Integer getAnio() {
		return anio;
	}

	public void setAnio(Integer anio) {
		this.anio = anio;
	}

	public BigDecimal getTotal() {
		return total;
	}

	public void setTotal(BigDecimal total) {
		this.total = total;
	}
}
