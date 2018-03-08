package cl.abaadmin.entities.web.ticket;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="categorias", schema = "ticket")
public class Categoria implements java.io.Serializable {

	private static final long serialVersionUID = 7919495740300197516L;
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name="categoria_id", nullable=false)
	private int categoriaId;
	@Column(name="categoria")
	private String categoria;
	
	public Categoria() {
		super();
	}

	public Categoria(int categoriaId, String categoria) {
		super();
		this.categoriaId = categoriaId;
		this.categoria = categoria;
	}

	public int getCategoriaId() {
		return categoriaId;
	}

	public void setCategoriaId(int categoriaId) {
		this.categoriaId = categoriaId;
	}

	public String getCategoria() {
		return categoria;
	}

	public void setCategoria(String categoria) {
		this.categoria = categoria;
	}
		
}
