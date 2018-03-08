package cl.abaadmin.vo.reportes;

import java.math.BigDecimal;

public class FacturadoRegionOpe implements java.io.Serializable {

	private static final long serialVersionUID = 3850573991412127560L;
	private Integer regionId;
	private String region;
	private Integer operadoraId;
	private String operadora;
	private BigDecimal total;
	
	public FacturadoRegionOpe() {
		super();
	}

	public FacturadoRegionOpe(Integer regionId, String region, Integer operadoraId, String operadora,
			BigDecimal total) {
		super();
		this.regionId = regionId;
		this.region = region;
		this.operadoraId = operadoraId;
		this.operadora = operadora;
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

	public BigDecimal getTotal() {
		return total;
	}

	public void setTotal(BigDecimal total) {
		this.total = total;
	}
}
