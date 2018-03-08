package cl.abaadmin.service.facturaciones;

import java.util.List;
import cl.abaadmin.vo.reportes.FacturadoDetalleMesOpe;
import cl.abaadmin.vo.reportes.FacturadoRegionMes;
import cl.abaadmin.vo.reportes.FacturadoRegionOpe;
import cl.abaadmin.vo.reportes.FacturadoVO;

public interface FacturacionService {
	
	public List<FacturadoVO> getFacturadoRegion(Integer mesIni, Integer mesFin, Integer anioIni, Integer anioFin);
	
	public List<FacturadoRegionOpe> getFacturadoRegionDetalleOpe(Integer mesIni, Integer mesFin, Integer anioIni, Integer anioFin, Integer region);
	
	public List<FacturadoRegionMes> getFacturadoRegionDetalleMes(Integer mesIni, Integer mesFin, Integer anioIni, Integer anioFin, Integer region);
	
	public List<FacturadoDetalleMesOpe> getFacturadoDetalleMes(Integer region, Integer mes, Integer anio);
	
	public List<FacturadoDetalleMesOpe> getFacturadoDetalleOpe(Integer mesIni, Integer mesFin, Integer anioIni, Integer anioFin,
			Integer region, Integer operadora);

}
