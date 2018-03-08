package cl.abaadmin.service.filtro;

import java.util.List;

import cl.abaadmin.vo.FiltroOperadoraVO;
import cl.abaadmin.vo.FiltroVO;

public interface FiltroService {
	
	public List<FiltroOperadoraVO> getOperadoras();
	
	public List<FiltroVO> getTecnologias();

}
