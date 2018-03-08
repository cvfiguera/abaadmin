package cl.abaadmin.entities.web.web;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

@Entity
@Table(name="lista_espera", schema="web")
public class ListaEspera implements java.io.Serializable {

	private static final long serialVersionUID = -389361165085130670L;
	@Id @GenericGenerator(name="idgen" , strategy="increment")
	@GeneratedValue(generator="idgen")
	@Column(name = "lista_espera_id", nullable = false, updatable = false)
	private int listaEsperaId;
	@Column(name = "velocidad_internacional_nu")
	private Double velocidadSubida;
	@Column(name = "velocidad_nacional_nu")
	private Double velocidadBajada;
	@Column(name = "precio_nu")
	private Double precio;
	@ManyToOne @JoinColumn(name= "tipo_adj_id")
	private TipoAdjudicacion tipoAdjudicacion;
	@ManyToOne @JoinColumn(name= "operadora_id")
	private Operadora operadora;
	@ManyToOne @JoinColumn(name= "tecnologia_id")
	private Tecnologia tecnologia;
	@ManyToOne @JoinColumn(name= "rbd_concurso_id")
	private RbdConcurso rbdConcurso;
	
	public ListaEspera() {
		super();
	}

	public ListaEspera(int listaEsperaId, Double velocidadSubida, Double velocidadBajada, Double precio,
			TipoAdjudicacion tipoAdjudicacion, Operadora operadora, Tecnologia tecnologia, RbdConcurso rbdConcurso) {
		super();
		this.listaEsperaId = listaEsperaId;
		this.velocidadSubida = velocidadSubida;
		this.velocidadBajada = velocidadBajada;
		this.precio = precio;
		this.tipoAdjudicacion = tipoAdjudicacion;
		this.operadora = operadora;
		this.tecnologia = tecnologia;
		this.rbdConcurso = rbdConcurso;
	}

	public int getListaEsperaId() {
		return listaEsperaId;
	}

	public void setListaEsperaId(int listaEsperaId) {
		this.listaEsperaId = listaEsperaId;
	}

	public Double getVelocidadSubida() {
		return velocidadSubida;
	}

	public void setVelocidadSubida(Double velocidadSubida) {
		this.velocidadSubida = velocidadSubida;
	}

	public Double getVelocidadBajada() {
		return velocidadBajada;
	}

	public void setVelocidadBajada(Double velocidadBajada) {
		this.velocidadBajada = velocidadBajada;
	}

	public Double getPrecio() {
		return precio;
	}

	public void setPrecio(Double precio) {
		this.precio = precio;
	}

	public TipoAdjudicacion getTipoAdjudicacion() {
		return tipoAdjudicacion;
	}

	public void setTipoAdjudicacion(TipoAdjudicacion tipoAdjudicacion) {
		this.tipoAdjudicacion = tipoAdjudicacion;
	}

	public Operadora getOperadora() {
		return operadora;
	}

	public void setOperadora(Operadora operadora) {
		this.operadora = operadora;
	}

	public Tecnologia getTecnologia() {
		return tecnologia;
	}

	public void setTecnologia(Tecnologia tecnologia) {
		this.tecnologia = tecnologia;
	}

	public RbdConcurso getRbdConcurso() {
		return rbdConcurso;
	}

	public void setRbdConcurso(RbdConcurso rbdConcurso) {
		this.rbdConcurso = rbdConcurso;
	}	
}
