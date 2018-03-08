package cl.abaadmin.service.web.concurso;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cl.abaadmin.entities.web.web.Concurso;
import cl.abaadmin.repository.web.web.ConcursoRepository;
import cl.abaadmin.vo.ConcursoVO;

@Service
public class ConcursoServiceImpl implements ConcursoService {

	@Autowired
	ConcursoRepository concursoRepository;
	
	@Override
	public List<ConcursoVO> getConcursos() {
		List<? extends Object> concursos = concursoRepository.findAll();
		return (List<ConcursoVO>) concursos;
	}

	@Override
	public ConcursoVO getConcurso(Integer concursoId) {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		Concurso concurso = concursoRepository.findOne(concursoId);
		return new ConcursoVO(concurso.getConcursoId(), concurso.getNombre(),
				sdf.format(concurso.getFechaInicio()), sdf.format(concurso.getFechaTermino()), concurso.getComentarios());
	}

	@Override
	public ConcursoVO saveConcurso(ConcursoVO concurso){
		
		Concurso concursoNew = new Concurso();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		
		if (concurso.getConcursoId()!= null) 
			concursoNew.setConcursoId(concurso.getConcursoId());
		concursoNew.setNombre(concurso.getNombre());
		try {
			concursoNew.setFechaInicio(concurso.getFechaInicio().equals("") ? null: sdf.parse(concurso.getFechaInicio()));
			concursoNew.setFechaTermino(concurso.getFechaTermino().equals("")  ? null: sdf.parse(concurso.getFechaTermino()));
		} catch (ParseException e) {
			e.printStackTrace();
		}
		
		concursoNew.setComentarios(concurso.getComentarios());
	
		concursoNew = concursoRepository.save(concursoNew);
		concurso.setConcursoId(concursoNew.getConcursoId());
		
		return concurso;
	}

	@Override
	public Boolean deleteConcurso(Integer concursoId) {

		Concurso concurso = concursoRepository.getOne(concursoId);
		
		try {
			concursoRepository.delete(concurso);
		} catch (Exception ex) {
			return false;
		}
		return true;
	}

}
