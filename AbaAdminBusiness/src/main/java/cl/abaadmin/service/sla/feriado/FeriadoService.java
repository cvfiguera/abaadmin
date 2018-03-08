package cl.abaadmin.service.sla.feriado;

import java.util.List;

import cl.abaadmin.vo.FeriadoVO;

public interface FeriadoService {
	
	public List<FeriadoVO> getFeriados();
	
	public FeriadoVO getFeriado(Integer feriadoId);
	
	public List<FeriadoVO> getFeriadoByMes(Integer mes, Integer anio);
	
	public FeriadoVO saveFeriado(FeriadoVO feriado);
	
	public FeriadoVO deleteFeriado(Integer feriadoId);

}
