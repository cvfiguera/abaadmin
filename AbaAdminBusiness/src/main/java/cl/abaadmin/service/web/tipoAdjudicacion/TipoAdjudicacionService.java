package cl.abaadmin.service.web.tipoAdjudicacion;

import java.util.List;

import cl.abaadmin.vo.TipoAdjudicacionVO;

public interface TipoAdjudicacionService {
	
	public List<TipoAdjudicacionVO> getTipoAdjudicaciones();
	
	public TipoAdjudicacionVO getTipoAdjudicacion(Integer tipoAdjudicacionId);
	
	public TipoAdjudicacionVO saveTipoAdjudicacion(TipoAdjudicacionVO tipoAdjudicacion);
	
	public TipoAdjudicacionVO deleteTipoAdjudicacion(Integer tipoAdjudicacionId);
}
