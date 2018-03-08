package cl.abaadmin.vo.reportes;

import java.math.BigDecimal;

public class FacturadoVO implements java.io.Serializable {

	private static final long serialVersionUID = -4018962381240480014L;
	private Integer id;
	private Integer orden;
	private String nombre;
	private BigDecimal total;
	
	public FacturadoVO() {
		super();
	}

	public FacturadoVO(Integer id, Integer orden, String nombre, BigDecimal total) {
		super();
		this.id = id;
		this.orden = orden;
		this.nombre = nombre;
		this.total = total;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getOrden() {
		return orden;
	}

	public void setOrden(Integer orden) {
		this.orden = orden;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public BigDecimal getTotal() {
		return total;
	}

	public void setTotal(BigDecimal total) {
		this.total = total;
	}
}
