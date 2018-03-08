package cl.abaadmin.entities.hist.facturaciones;

import java.math.BigDecimal;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import org.hibernate.annotations.GenericGenerator;

public class FacturacionRegistro implements java.io.Serializable {

	private static final long serialVersionUID = -7486147831931228652L;
	@Id
	@GenericGenerator(name="idgen" , strategy="increment")
	@GeneratedValue(generator="idgen")
	@Column(name = "facturacion_registros_id", nullable = false, updatable = false)
	private Integer id;
	private Integer rbd;
	private Integer tecnologiaId;
	private Integer bloqueId;
	@Column(name = "pertenece_ope", nullable = false)
	private Boolean perteneceOperadora;
	@Column(name = "ai_velocidad_adjudicada", nullable = false)
	private Integer velocidadAdjudicada;
	@Column(name = "ai_dispo_prefac")
	private BigDecimal dispoPrefactura;
	@Column(name = "ai_disp_porc_aba")
	private BigDecimal dispoAba;
	@Column(name = "ai_disp_descuento")
	private BigDecimal dispoDesc;
	@Column(name = "ai_vel_infor_pref")
	private BigDecimal velpPrefactura;
	@Column(name = "ai_vel_calculo_aba")
	private BigDecimal velAba;
	@Column(name = "ai_vel_descuento")
	private BigDecimal velDesc;
	@Column(name = "ri_fecha_alta_servicio")
	private Date fechaAlta;
	@Column(name = "ri_val_mensual_adj")
	private Integer valorAdjudicado;
	@Column(name = "ri_valor_pagar_mes")
	private BigDecimal valorMes;
	@Column(name = "ri_descuento_dispo")
	private BigDecimal descDispo;
	@Column(name = "ri_descuento_vel")
	private BigDecimal descVel;
	@Column(name = "ri_monto_pagar_mes")
	private BigDecimal montoAPagar;
	@ManyToOne
	@JoinColumn(name= "facturacion_id")
	private Facturacion facturacion;
	@ManyToOne
	@JoinColumn(name= "comuna_id")
	private Comuna comuna;
	@ManyToOne
	@JoinColumn(name= "conclusion_id")
	private Conclusion conclusion;
	
	public FacturacionRegistro() {
		super();
	}

	public FacturacionRegistro(Integer id, Integer rbd, Integer tecnologiaId, Integer bloqueId,
			Boolean perteneceOperadora, Integer velocidadAdjudicada, BigDecimal dispoPrefactura, BigDecimal dispoAba,
			BigDecimal dispoDesc, BigDecimal velpPrefactura, BigDecimal velAba, BigDecimal velDesc, Date fechaAlta,
			Integer valorAdjudicado, BigDecimal valorMes, BigDecimal descDispo, BigDecimal descVel,
			BigDecimal montoAPagar, Facturacion facturacion, Comuna comuna, Conclusion conclusion) {
		super();
		this.id = id;
		this.rbd = rbd;
		this.tecnologiaId = tecnologiaId;
		this.bloqueId = bloqueId;
		this.perteneceOperadora = perteneceOperadora;
		this.velocidadAdjudicada = velocidadAdjudicada;
		this.dispoPrefactura = dispoPrefactura;
		this.dispoAba = dispoAba;
		this.dispoDesc = dispoDesc;
		this.velpPrefactura = velpPrefactura;
		this.velAba = velAba;
		this.velDesc = velDesc;
		this.fechaAlta = fechaAlta;
		this.valorAdjudicado = valorAdjudicado;
		this.valorMes = valorMes;
		this.descDispo = descDispo;
		this.descVel = descVel;
		this.montoAPagar = montoAPagar;
		this.facturacion = facturacion;
		this.comuna = comuna;
		this.conclusion = conclusion;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getRbd() {
		return rbd;
	}

	public void setRbd(Integer rbd) {
		this.rbd = rbd;
	}

	public Integer getTecnologiaId() {
		return tecnologiaId;
	}

	public void setTecnologiaId(Integer tecnologiaId) {
		this.tecnologiaId = tecnologiaId;
	}

	public Integer getBloqueId() {
		return bloqueId;
	}

	public void setBloqueId(Integer bloqueId) {
		this.bloqueId = bloqueId;
	}

	public Boolean getPerteneceOperadora() {
		return perteneceOperadora;
	}

	public void setPerteneceOperadora(Boolean perteneceOperadora) {
		this.perteneceOperadora = perteneceOperadora;
	}

	public Integer getVelocidadAdjudicada() {
		return velocidadAdjudicada;
	}

	public void setVelocidadAdjudicada(Integer velocidadAdjudicada) {
		this.velocidadAdjudicada = velocidadAdjudicada;
	}

	public BigDecimal getDispoPrefactura() {
		return dispoPrefactura;
	}

	public void setDispoPrefactura(BigDecimal dispoPrefactura) {
		this.dispoPrefactura = dispoPrefactura;
	}

	public BigDecimal getDispoAba() {
		return dispoAba;
	}

	public void setDispoAba(BigDecimal dispoAba) {
		this.dispoAba = dispoAba;
	}

	public BigDecimal getDispoDesc() {
		return dispoDesc;
	}

	public void setDispoDesc(BigDecimal dispoDesc) {
		this.dispoDesc = dispoDesc;
	}

	public BigDecimal getVelpPrefactura() {
		return velpPrefactura;
	}

	public void setVelpPrefactura(BigDecimal velpPrefactura) {
		this.velpPrefactura = velpPrefactura;
	}

	public BigDecimal getVelAba() {
		return velAba;
	}

	public void setVelAba(BigDecimal velAba) {
		this.velAba = velAba;
	}

	public BigDecimal getVelDesc() {
		return velDesc;
	}

	public void setVelDesc(BigDecimal velDesc) {
		this.velDesc = velDesc;
	}

	public Date getFechaAlta() {
		return fechaAlta;
	}

	public void setFechaAlta(Date fechaAlta) {
		this.fechaAlta = fechaAlta;
	}

	public Integer getValorAdjudicado() {
		return valorAdjudicado;
	}

	public void setValorAdjudicado(Integer valorAdjudicado) {
		this.valorAdjudicado = valorAdjudicado;
	}

	public BigDecimal getValorMes() {
		return valorMes;
	}

	public void setValorMes(BigDecimal valorMes) {
		this.valorMes = valorMes;
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

	public BigDecimal getMontoAPagar() {
		return montoAPagar;
	}

	public void setMontoAPagar(BigDecimal montoAPagar) {
		this.montoAPagar = montoAPagar;
	}

	public Facturacion getFacturacion() {
		return facturacion;
	}

	public void setFacturacion(Facturacion facturacion) {
		this.facturacion = facturacion;
	}

	public Comuna getComuna() {
		return comuna;
	}

	public void setComuna(Comuna comuna) {
		this.comuna = comuna;
	}

	public Conclusion getConclusion() {
		return conclusion;
	}

	public void setConclusion(Conclusion conclusion) {
		this.conclusion = conclusion;
	}
}
