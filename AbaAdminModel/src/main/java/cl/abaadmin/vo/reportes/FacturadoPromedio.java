package cl.abaadmin.vo.reportes;

import java.math.BigDecimal;

public class FacturadoPromedio implements java.io.Serializable {

	private static final long serialVersionUID = -4218369901383488721L;
	private Integer operadoraId;
	private Integer anio;
	private Integer mes;
	private Double descDispo;
	private Double descVel;
	private Double totalPagar;
	
	public FacturadoPromedio() {
		super();
	}

	public FacturadoPromedio(Integer operadoraId, Integer anio, Integer mes, Double descDispo, Double descVel,
			Double totalPagar) {
		super();
		this.operadoraId = operadoraId;
		this.anio = anio;
		this.mes = mes;
		this.descDispo = descDispo;
		this.descVel = descVel;
		this.totalPagar = totalPagar;
	}

	public Integer getOperadoraId() {
		return operadoraId;
	}

	public void setOperadoraId(Integer operadoraId) {
		this.operadoraId = operadoraId;
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

	public Double getDescDispo() {
		return descDispo;
	}

	public void setDescDispo(Double descDispo) {
		this.descDispo = descDispo;
	}

	public Double getDescVel() {
		return descVel;
	}

	public void setDescVel(Double descVel) {
		this.descVel = descVel;
	}

	public Double getTotalPagar() {
		return totalPagar;
	}

	public void setTotalPagar(Double totalPagar) {
		this.totalPagar = totalPagar;
	}
	
}
