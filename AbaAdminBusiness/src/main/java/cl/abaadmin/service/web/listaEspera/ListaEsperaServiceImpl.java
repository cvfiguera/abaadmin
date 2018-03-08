package cl.abaadmin.service.web.listaEspera;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cl.abaadmin.entities.web.web.ListaEspera;
import cl.abaadmin.repository.web.web.ListaEsperaRepository;
import cl.abaadmin.repository.web.web.OperadoraRepository;
import cl.abaadmin.repository.web.web.RbdConcursoRepository;
import cl.abaadmin.repository.web.web.TecnologiaRepository;
import cl.abaadmin.repository.web.web.TipoAdjudicacionRepository;
import cl.abaadmin.vo.ListaEsperaVO;

@Service
public class ListaEsperaServiceImpl implements ListaEsperaService {

	@Autowired ListaEsperaRepository listaERepository;
	@Autowired OperadoraRepository operadoraRepository;
	@Autowired TecnologiaRepository tecnologiaRepository;
	@Autowired TipoAdjudicacionRepository tipoAdjRepository;
	@Autowired RbdConcursoRepository rbdConcursoRepository;
	
	@Override
	public List<ListaEsperaVO> getListaEspera(Integer tipoId) {
		List<ListaEspera> listaEspera = listaERepository.findByTipoAdjudicacionTipoAdjudicacionId(tipoId);
		List<ListaEsperaVO> listaEsperaVO = new ArrayList<ListaEsperaVO>();
		
		for(int i=0; i<listaEspera.size(); i++) {
			ListaEspera listaE = listaEspera.get(i);
			listaEsperaVO.add(new ListaEsperaVO(listaE.getListaEsperaId(), listaE.getVelocidadSubida(),
					listaE.getVelocidadBajada(), listaE.getPrecio(), listaE.getTipoAdjudicacion().getTipoAdjudicacionId(),
					listaE.getOperadora().getOperadoraId(), listaE.getOperadora().getNombre(),
					listaE.getTecnologia().getTecnologiaId(), listaE.getTecnologia().getNombre(),
					listaE.getRbdConcurso().getRbd().getRbdId(), listaE.getRbdConcurso().getRbd().getRbd(),
					listaE.getRbdConcurso().getConcurso().getConcursoId(), listaE.getRbdConcurso().getConcurso().getNombre()));
		}
		
		return listaEsperaVO;
	}

	@Override
	public ListaEsperaVO getListaEspera(Integer tipoId, Integer listaEsperaId) {
		ListaEspera listaE = listaERepository.getOne(listaEsperaId);
		return new ListaEsperaVO(listaE.getListaEsperaId(), listaE.getVelocidadSubida(),
				listaE.getVelocidadBajada(), listaE.getPrecio(), listaE.getTipoAdjudicacion().getTipoAdjudicacionId(),
				listaE.getOperadora().getOperadoraId(), listaE.getOperadora().getNombre(),
				listaE.getTecnologia().getTecnologiaId(), listaE.getTecnologia().getNombre(),
				listaE.getRbdConcurso().getRbd().getRbdId(), listaE.getRbdConcurso().getRbd().getRbd(),
				listaE.getRbdConcurso().getConcurso().getConcursoId(), listaE.getRbdConcurso().getConcurso().getNombre());
	}

	@Override
	public ListaEsperaVO saveListaEspera(Integer tipoId, ListaEsperaVO listaEspera) {
		
		ListaEspera listaE = new ListaEspera();
		
		if(listaEspera.getListaEsperaId() != null)
			listaE.setListaEsperaId(listaEspera.getListaEsperaId());
		listaE.setVelocidadSubida(listaEspera.getVelocidadSubida());
		listaE.setVelocidadBajada(listaEspera.getVelocidadBajada());
		listaE.setPrecio(listaEspera.getPrecio());
		listaE.setTipoAdjudicacion(tipoAdjRepository.getOne(listaEspera.getTipoAdjudicacion()));
		listaE.setOperadora(operadoraRepository.findOne(listaEspera.getOperadoraId()));
		listaE.setTecnologia(tecnologiaRepository.findOne(listaEspera.getTecnologiaId()));
		listaE.setRbdConcurso(rbdConcursoRepository.findByRbdRbdIdAndConcursoConcursoId(
				listaEspera.getRbdId(), listaEspera.getConcursoId()));
		listaE = listaERepository.save(listaE);
		listaEspera.setListaEsperaId(listaE.getListaEsperaId());
		return listaEspera;
	}

	@Override
	public ListaEsperaVO deleteListaEspera(Integer tipoId, Integer listaEsperaId) {
		ListaEspera listaE = listaERepository.findOne(listaEsperaId);
		listaERepository.delete(listaEsperaId);
		return new ListaEsperaVO(listaE.getListaEsperaId(), listaE.getVelocidadSubida(),
				listaE.getVelocidadBajada(), listaE.getPrecio(), listaE.getTipoAdjudicacion().getTipoAdjudicacionId(),
				listaE.getOperadora().getOperadoraId(), listaE.getOperadora().getNombre(),
				listaE.getTecnologia().getTecnologiaId(), listaE.getTecnologia().getNombre(),
				listaE.getRbdConcurso().getRbd().getRbdId(), listaE.getRbdConcurso().getRbd().getRbd(),
				listaE.getRbdConcurso().getConcurso().getConcursoId(), listaE.getRbdConcurso().getConcurso().getNombre());
	}
}
