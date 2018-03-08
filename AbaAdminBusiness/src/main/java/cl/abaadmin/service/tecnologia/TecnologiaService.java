package cl.abaadmin.service.tecnologia;

import java.util.List;

import cl.abaadmin.vo.TecnologiaVO;

public interface TecnologiaService {
	
	public List<TecnologiaVO> getTecnologias();
	
	public TecnologiaVO getTecnologia(Integer tecnologiaId);
	
	public TecnologiaVO saveTecnologia(TecnologiaVO tecnologia);
	
	public Boolean deleteTecnologia(Integer tecnologiaId);

}
