package cl.abaadmin.service.web.estado;

import java.util.List;

import cl.abaadmin.vo.EstadoVO;
import cl.abaadmin.vo.SubEstadoVO;

public interface EstadoService {
	
	public List<EstadoVO> getEstados(Integer tipo);
	
	public List<SubEstadoVO> getSubEstados();
	
	public EstadoVO getEstado(Integer tipo, Integer estadoId);
	
	public EstadoVO saveEstado(Integer tipo, EstadoVO estado);
	
	public SubEstadoVO saveSubEstado(SubEstadoVO subestado);
	
	public Boolean deleteEstado(Integer tipo, Integer estadoId);
}
