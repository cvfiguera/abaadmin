package cl.abaadmin.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import cl.abaadmin.service.facturaciones.FacturacionService;
import cl.abaadmin.vo.reportes.FacturadoDetalleMesOpe;
import cl.abaadmin.vo.reportes.FacturadoPromedio;
import cl.abaadmin.vo.reportes.FacturadoRegionMes;
import cl.abaadmin.vo.reportes.FacturadoRegionOpe;
import cl.abaadmin.vo.reportes.FacturadoVO;

@RestController
public class FacturacionesController {
	
	@Autowired
	private FacturacionService facturacionService;
	
	@RequestMapping(value = "/facturaciones/regiones", method = RequestMethod.GET, produces = "application/json")
	public ResponseEntity<List<FacturadoVO>> getFRegiones(@RequestParam(value= "mesi") Integer mesIni, 
			@RequestParam(value= "mesf") Integer mesFin,
			@RequestParam(value= "anioi") Integer anioIni, 
			@RequestParam(value= "aniof") Integer anioFin) {
		
		return new ResponseEntity<>(facturacionService.getFacturadoRegion(mesIni, mesFin, anioIni, anioFin), HttpStatus.OK);
	}
	
	@RequestMapping(value = "/facturaciones/regiones/{region}/operadoras", method = RequestMethod.GET, produces = "application/json")
	public ResponseEntity<List<FacturadoRegionOpe>> getRDetalleOperadoras(
			@PathVariable Integer region, @RequestParam(value= "mesi") Integer mesIni, 
			@RequestParam(value= "mesf") Integer mesFin,
			@RequestParam(value= "anioi") Integer anioIni, 
			@RequestParam(value= "aniof") Integer anioFin) {
		
		return new ResponseEntity<>(facturacionService.getFacturadoRegionDetalleOpe(mesIni, mesFin, anioIni, anioFin, region), HttpStatus.OK);
	}
	
	@RequestMapping(value = "/facturaciones/regiones/{region}/meses", method = RequestMethod.GET, produces = "application/json")
	public ResponseEntity<List<FacturadoRegionMes>> getRDetalleMes(
			@PathVariable Integer region, @RequestParam(value= "mesi") Integer mesIni, 
			@RequestParam(value= "mesf") Integer mesFin,
			@RequestParam(value= "anioi") Integer anioIni, 
			@RequestParam(value= "aniof") Integer anioFin) {
		
		return new ResponseEntity<>(facturacionService.getFacturadoRegionDetalleMes(mesIni, mesFin, anioIni, anioFin, region), HttpStatus.OK);
	}
	
	@RequestMapping(value = "/facturaciones/regiones/{region}/meses/{periodo}", method = RequestMethod.GET, produces = "application/json")
	public ResponseEntity<List<FacturadoDetalleMesOpe>> getDetalleMes(
			@PathVariable Integer region, @PathVariable String periodo,
			@RequestParam(value= "mes") Integer mes,
			@RequestParam(value= "anio") Integer anio) {
		
		return new ResponseEntity<>(facturacionService.getFacturadoDetalleMes(region, mes, anio), HttpStatus.OK);
	}
	
	@RequestMapping(value = "/facturaciones/regiones/{region}/operadoras/{operadora}", method = RequestMethod.GET, produces = "application/json")
	public ResponseEntity<List<FacturadoDetalleMesOpe>> getDetalleOpe(
			@PathVariable Integer region,  @PathVariable Integer operadora,
			@RequestParam(value= "mesi") Integer mesIni, 
			@RequestParam(value= "mesf") Integer mesFin,
			@RequestParam(value= "anioi") Integer anioIni, 
			@RequestParam(value= "aniof") Integer anioFin) {
		
		return new ResponseEntity<>(facturacionService.getFacturadoDetalleOpe(mesIni, mesFin, anioIni, anioFin, region, operadora), HttpStatus.OK);
	}
	
}
