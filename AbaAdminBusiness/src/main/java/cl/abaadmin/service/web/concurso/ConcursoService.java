package cl.abaadmin.service.web.concurso;

import java.util.List;

import cl.abaadmin.vo.ConcursoVO;

public interface ConcursoService {
	
	public List<ConcursoVO> getConcursos();
	
	public ConcursoVO getConcurso(Integer concursoId);
	
	public ConcursoVO saveConcurso(ConcursoVO concurso);
	
	public Boolean deleteConcurso(Integer concursoId);
}
