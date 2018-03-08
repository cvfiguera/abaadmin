package cl.abaadmin.service.web.operadora;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;

import cl.abaadmin.entities.web.web.Operadora;
import cl.abaadmin.vo.FiltroOperadoraVO;
import cl.abaadmin.vo.OperadoraVO;

public interface OperadoraService {
	
	public Page<Operadora> getOperadoras(PageRequest page);
	
	public Page<Operadora> getOperadoras(PageRequest page, String rut, String nombre);
	
	public OperadoraVO getOperadora(Integer operadoraId);
	
	public OperadoraVO saveOperadora(OperadoraVO operadora);
	
	public Boolean deleteOperadora(Integer operadoraId);
	
}
