package cl.abaadmin.service.web.tipoAdjudicacion;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cl.abaadmin.entities.web.web.TipoAdjudicacion;
import cl.abaadmin.repository.web.web.TipoAdjudicacionRepository;
import cl.abaadmin.vo.TipoAdjudicacionVO;

@Service
public class TipoAdjudicacionServiceImpl implements TipoAdjudicacionService {

	@Autowired
	private TipoAdjudicacionRepository tipoAdjRepository;
	
	@Override
	public List<TipoAdjudicacionVO> getTipoAdjudicaciones() {
		List<TipoAdjudicacion> tiposAdj = tipoAdjRepository.findAll();
		List<TipoAdjudicacionVO> tiposAdjVO = new ArrayList<TipoAdjudicacionVO>();
		
		for(int i=0; i<tiposAdj.size(); i++) {
			TipoAdjudicacion tipoAdj = tiposAdj.get(i);
			tiposAdjVO.add(new TipoAdjudicacionVO(tipoAdj.getTipoAdjudicacionId(),
					tipoAdj.getTipoAdjudicacion(), tipoAdj.getDescripcion()));
		}
		
		return tiposAdjVO;
	}

	@Override
	public TipoAdjudicacionVO getTipoAdjudicacion(Integer tipoAdjudicacionId) {
		TipoAdjudicacion tipoAdj = tipoAdjRepository.findOne(tipoAdjudicacionId);
		return new TipoAdjudicacionVO(tipoAdj.getTipoAdjudicacionId(), tipoAdj.getTipoAdjudicacion(),
				tipoAdj.getDescripcion());
	}

	@Override
	public TipoAdjudicacionVO saveTipoAdjudicacion(TipoAdjudicacionVO tipoAdjudicacion) {
		
		TipoAdjudicacion tipoAdj = new TipoAdjudicacion();
		
		if (tipoAdjudicacion.getId()!=null)
			tipoAdj.setTipoAdjudicacionId(tipoAdjudicacion.getId());
		
		tipoAdj.setTipoAdjudicacion(tipoAdjudicacion.getNombre());
		tipoAdj.setDescripcion(tipoAdjudicacion.getDescripcion());
		
		tipoAdj = tipoAdjRepository.save(tipoAdj);
		tipoAdjudicacion.setId(tipoAdj.getTipoAdjudicacionId());
		
		return tipoAdjudicacion;
	}

	@Override
	public TipoAdjudicacionVO deleteTipoAdjudicacion(Integer tipoAdjudicacionId) {
		
		TipoAdjudicacion tipoAdjudicacion = tipoAdjRepository.findOne(tipoAdjudicacionId);
		tipoAdjRepository.delete(tipoAdjudicacionId);
		return new TipoAdjudicacionVO(tipoAdjudicacion.getTipoAdjudicacionId(),
				tipoAdjudicacion.getTipoAdjudicacion(), tipoAdjudicacion.getDescripcion());
	}

}
