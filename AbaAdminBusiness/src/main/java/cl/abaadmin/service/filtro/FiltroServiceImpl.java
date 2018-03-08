package cl.abaadmin.service.filtro;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cl.abaadmin.entities.web.web.Operadora;
import cl.abaadmin.entities.web.web.Rbd;
import cl.abaadmin.entities.web.web.Tecnologia;
import cl.abaadmin.repository.web.web.OperadoraRepository;
import cl.abaadmin.repository.web.web.RbdRepository;
import cl.abaadmin.repository.web.web.TecnologiaRepository;
import cl.abaadmin.vo.FiltroOperadoraVO;
import cl.abaadmin.vo.FiltroVO;

@Service
public class FiltroServiceImpl implements FiltroService {

	@Autowired OperadoraRepository operadoraRepository;
	@Autowired TecnologiaRepository tecnologiaRepository;
	@Autowired RbdRepository rbdRepository;
	
	@Override
	public List<FiltroOperadoraVO> getOperadoras() {
		List<Operadora> operadoras = operadoraRepository.findAll();
		List<FiltroOperadoraVO> operadorasFiltro = new ArrayList<FiltroOperadoraVO> (); 
		for(int i=0; i<operadoras.size(); i++) {
			Operadora operadora = operadoras.get(i);
			operadorasFiltro.add(new FiltroOperadoraVO(operadora.getOperadoraId(), 
					operadora.getUsuarioSFTP(), operadora.getAlias()));
		}
		
		return operadorasFiltro;
	}

	@Override
	public List<FiltroVO> getTecnologias() {
		List<Tecnologia> tecnologias = tecnologiaRepository.findAll();
		List<FiltroVO> tecnologiasVO = new ArrayList<FiltroVO>();
		for(int i=0; i<tecnologias.size(); i++) {
			Tecnologia tecnologia = tecnologias.get(i);
			tecnologiasVO.add(new FiltroVO(tecnologia.getTecnologiaId(), tecnologia.getNombre()));
		}
		return tecnologiasVO;
	}

}
