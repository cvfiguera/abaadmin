package cl.abaadmin.service.facturaciones;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import cl.abaadmin.repository.hist.facturaciones.FacturacionRepository;
import cl.abaadmin.vo.reportes.FacturadoDetalleMesOpe;
import cl.abaadmin.vo.reportes.FacturadoRegionMes;
import cl.abaadmin.vo.reportes.FacturadoRegionOpe;
import cl.abaadmin.vo.reportes.FacturadoVO;

@Service
public class FacturacionServiceImpl implements FacturacionService {

	@Autowired
	private FacturacionRepository facturacionRepository;

	@Override
	public List<FacturadoVO> getFacturadoRegion(Integer mesIni, Integer mesFin, Integer anioIni, Integer anioFin) {
		List<FacturadoVO> facturado = facturacionRepository.findFacturadoRegion(mesIni, mesFin, anioIni, anioFin);
		return facturado;
	}

	@Override
	public List<FacturadoRegionOpe> getFacturadoRegionDetalleOpe(Integer mesIni, Integer mesFin, Integer anioIni,
			Integer anioFin, Integer region) {
		List<FacturadoRegionOpe> facturado = facturacionRepository.findFacturadoRegionDetalleOpe(mesIni, mesFin, anioIni,
				anioFin, region);
		return facturado;
	}

	@Override
	public List<FacturadoRegionMes> getFacturadoRegionDetalleMes(Integer mesIni, Integer mesFin, Integer anioIni,
			Integer anioFin, Integer region) {
		List<FacturadoRegionMes> facturado = facturacionRepository.findFacturadoRegionDetalleMes(mesIni, mesFin, anioIni,
				anioFin, region);
		return facturado;
	}

	@Override
	public List<FacturadoDetalleMesOpe> getFacturadoDetalleMes(Integer region, Integer mes, Integer anio) {
		List<FacturadoDetalleMesOpe> facturado = facturacionRepository.findFacturadoDetalleMes(mes, anio, region);
		return facturado;
	}

	@Override
	public List<FacturadoDetalleMesOpe> getFacturadoDetalleOpe(Integer mesIni, Integer mesFin, Integer anioIni,
			Integer anioFin, Integer region, Integer operadora) {
		List<FacturadoDetalleMesOpe> facturado = facturacionRepository.findFacturadoDetalleOpe(mesIni, mesFin, 
				anioIni, anioFin, region, operadora);
		return facturado;
	}

}
