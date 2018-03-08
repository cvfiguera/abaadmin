package cl.abaadmin.service.web.operadora;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import cl.abaadmin.entities.web.web.Operadora;
import cl.abaadmin.repository.web.web.OperadoraRepository;
import cl.abaadmin.vo.FiltroOperadoraVO;
import cl.abaadmin.vo.FiltroVO;
import cl.abaadmin.vo.OperadoraVO;

@Service
public class OperadoraServiceImpl implements OperadoraService {

	@Autowired
	OperadoraRepository operadoraRepository;
	
	@Override
	public Page<Operadora> getOperadoras(PageRequest page) {
		
		Page<Operadora> result = operadoraRepository.findAll(page);
		
		return result;
	}
	
	@Override
	public Page<Operadora> getOperadoras(PageRequest page, String rut, String nombre) {
	
		Page<Operadora> result;
		
		if (rut != "" && nombre != "") 
			result = operadoraRepository.findByFilters("%" + rut.toLowerCase() + "%", "%" + nombre.toLowerCase() + "%", page);
		else if (rut != "" && nombre == "")
			result = operadoraRepository.findByRutContainingIgnoreCase(rut, page);
		else if (rut == "" && nombre != "")
			result = operadoraRepository.findByNombreContainingIgnoreCase(nombre, page);
		else
			result = operadoraRepository.findAll(page);
		
		return result;
	}

	@Override
	public OperadoraVO getOperadora(Integer operadoraId) {
		
		Operadora operadora = operadoraRepository.findOne(operadoraId);
		
		return new OperadoraVO(operadora.getOperadoraId(), operadora.getRut(),
				operadora.getNombre(), operadora.getAlias(), operadora.getObservacion());
	}

	@Override
	public OperadoraVO saveOperadora(OperadoraVO operadoraVO) {
		
		Operadora operadora = new Operadora();
		
		if (operadoraVO.getOperadoraId()!= null) 
			operadora.setOperadoraId(operadoraVO.getOperadoraId());
		
		operadora.setRut(operadoraVO.getRut());
		operadora.setNombre(operadoraVO.getNombre());
		operadora.setAlias(operadoraVO.getAlias());
		operadora.setObservacion(operadoraVO.getObservacion());
	
		
		operadora = operadoraRepository.save(operadora);
	
		return new OperadoraVO(operadora.getOperadoraId(), operadora.getRut(),
				operadora.getNombre(), operadora.getAlias(), operadora.getObservacion());
	}

	@Override
	public Boolean deleteOperadora(Integer operadoraId) {
		
		try {
			operadoraRepository.delete(operadoraId);;
		} catch (Exception ex) {
			return false;
		}
		return true;
	}

}
