package cl.abaadmin.service.ticket;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cl.abaadmin.entities.web.ticket.Categoria;
import cl.abaadmin.repository.web.ticket.CategoriaRepository;
import cl.abaadmin.vo.CategoriaVO;

@Service
public class CategoriaServiceImpl implements CategoriaService{

	@Autowired
	private CategoriaRepository categoriaRepository;
	
	@Override
	public List<CategoriaVO> getCategorias() {
		
		List<CategoriaVO> categoriasVO = new ArrayList<CategoriaVO> ();
		Iterable<Categoria> categorias = categoriaRepository.findAll();
		
		for(Categoria categoria:categorias) {
			categoriasVO.add(new CategoriaVO(categoria.getCategoriaId(), categoria.getCategoria()));
		}
			
		return categoriasVO;
	}

}
