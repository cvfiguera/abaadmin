package cl.abaadmin.entities.hist.facturaciones;

import java.math.BigDecimal;
import java.math.BigInteger;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="facturado_operadora", schema="facturaciones")
public class FacturadoOperadora implements java.io.Serializable {

	private static final long serialVersionUID = -7410630160857990740L;
	@Id
	@Column(name = "operadora_id")
	private Integer operadoraId;
	@Column(name = "operadora")
	private String operadora;
	@Column(name = "region_id")
	private Integer regionId;
	@Column(name = "n_region")
	private Integer nRegion;
	@Column(name = "region")
	private String region;
	@Column(name = "tecnologia_id")
	private Integer tecnologiaId;
	@Column(name = "tecnologia")
	private String tecnologia;
	@Column(name = "anio")
	private Integer anio;
	@Column(name = "mes")
	private Integer mes;
	@Column(name = "adjudicado")
	private BigInteger adjudicado;
	@Column(name = "desc_dispo")
	private BigDecimal descDispo;
	@Column(name = "desc_vel")
	private BigDecimal descVel;
	@Column(name = "total_pagar")
	private BigDecimal totalPagar;
	
	public FacturadoOperadora() {
		super();
	}

	public FacturadoOperadora(Integer operadoraId, String operadora, Integer regionId, Integer nRegion, String region,
			Integer tecnologiaId, String tecnologia, Integer anio, Integer mes, BigInteger adjudicado,
			BigDecimal descDispo, BigDecimal descVel, BigDecimal totalPagar) {
		super();
		this.operadoraId = operadoraId;
		this.operadora = operadora;
		this.regionId = regionId;
		this.nRegion = nRegion;
		this.region = region;
		this.tecnologiaId = tecnologiaId;
		this.tecnologia = tecnologia;
		this.anio = anio;
		this.mes = mes;
		this.adjudicado = adjudicado;
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

	public String getOperadora() {
		return operadora;
	}

	public void setOperadora(String operadora) {
		this.operadora = operadora;
	}

	public Integer getRegionId() {
		return regionId;
	}

	public void setRegionId(Integer regionId) {
		this.regionId = regionId;
	}

	public Integer getnRegion() {
		return nRegion;
	}

	public void setnRegion(Integer nRegion) {
		this.nRegion = nRegion;
	}

	public String getRegion() {
		return region;
	}

	public void setRegion(String region) {
		this.region = region;
	}

	public Integer getTecnologiaId() {
		return tecnologiaId;
	}

	public void setTecnologiaId(Integer tecnologiaId) {
		this.tecnologiaId = tecnologiaId;
	}

	public String getTecnologia() {
		return tecnologia;
	}

	public void setTecnologia(String tecnologia) {
		this.tecnologia = tecnologia;
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

	public BigInteger getAdjudicado() {
		return adjudicado;
	}

	public void setAdjudicado(BigInteger adjudicado) {
		this.adjudicado = adjudicado;
	}

	public BigDecimal getDescDispo() {
		return descDispo;
	}

	public void setDescDispo(BigDecimal descDispo) {
		this.descDispo = descDispo;
	}

	public BigDecimal getDescVel() {
		return descVel;
	}

	public void setDescVel(BigDecimal descVel) {
		this.descVel = descVel;
	}

	public BigDecimal getTotalPagar() {
		return totalPagar;
	}

	public void setTotalPagar(BigDecimal totalPagar) {
		this.totalPagar = totalPagar;
	}
}
