package cl.abaadmin.service.web.listaEspera;

import java.util.List;

import cl.abaadmin.entities.web.web.ListaEspera;
import cl.abaadmin.vo.ListaEsperaVO;

public interface ListaEsperaService {

	public List<ListaEsperaVO> getListaEspera(Integer tipoId);
	
	public ListaEsperaVO getListaEspera(Integer tipoId, Integer listaEsperaId);
	
	public ListaEsperaVO saveListaEspera(Integer tipoId, ListaEsperaVO listaEspera);
	
	public ListaEsperaVO deleteListaEspera(Integer tipoId, Integer listaEsperaId);
}
