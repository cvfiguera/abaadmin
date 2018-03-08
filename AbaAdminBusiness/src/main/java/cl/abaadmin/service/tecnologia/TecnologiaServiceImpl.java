package cl.abaadmin.service.tecnologia;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cl.abaadmin.entities.web.web.Tecnologia;
import cl.abaadmin.repository.web.web.TecnologiaRepository;
import cl.abaadmin.vo.TecnologiaVO;

@Service
public class TecnologiaServiceImpl implements TecnologiaService {

	@Autowired
	private TecnologiaRepository tecnologiaRepository;
	
	@Override
	public List<TecnologiaVO> getTecnologias() {
		List<? extends Object> tecnologias = tecnologiaRepository.findAll();
		return (List<TecnologiaVO>) tecnologias;
	}

	@Override
	public TecnologiaVO getTecnologia(Integer tecnologiaId) {
		Tecnologia tecnologia = tecnologiaRepository.findOne(tecnologiaId);
		return new TecnologiaVO(tecnologia.getTecnologiaId(), tecnologia.getNombre(),
				tecnologia.getObservacion());		
	}

	@Override
	public TecnologiaVO saveTecnologia(TecnologiaVO tecnologia) {

		Tecnologia tecnologiaNew = new Tecnologia();
		
		if (tecnologia.getTecnologiaId()!= null) 
			tecnologiaNew.setTecnologiaId(tecnologia.getTecnologiaId());
		
		tecnologiaNew.setNombre(tecnologia.getNombre());
		tecnologiaNew.setObservacion(tecnologia.getObservacion());
	
		tecnologiaNew = tecnologiaRepository.save(tecnologiaNew);
		tecnologia.setTecnologiaId(tecnologiaNew.getTecnologiaId());
		
		return tecnologia;
	}

	@Override
	public Boolean deleteTecnologia(Integer tecnologiaId) {

		Tecnologia tecnologia = tecnologiaRepository.getOne(tecnologiaId);
		
		try {
			tecnologiaRepository.delete(tecnologia);
		} catch (Exception ex) {
			return false;
		}
		return true;
	}

}
