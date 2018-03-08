package cl.abaadmin.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import cl.abaadmin.service.sla.feriado.FeriadoService;
import cl.abaadmin.vo.FeriadoVO;

@RestController
public class FeriadoController {

	@Autowired
	FeriadoService feriadoService;
	
	@RequestMapping(value = "/feriados", method = RequestMethod.GET, produces = "application/json")
	public ResponseEntity<List<FeriadoVO>> getFeriados() {
		
		return new ResponseEntity<>(feriadoService.getFeriados(), HttpStatus.OK);
	}
	
	@RequestMapping(value = "/resumen/feriados", method = RequestMethod.GET, produces = "application/json")
	public ResponseEntity<List<FeriadoVO>> getFeriadosMes(@RequestParam("mes") Integer mes, 
			@RequestParam("anio") Integer anio) {
		
		return new ResponseEntity<>(feriadoService.getFeriadoByMes(mes, anio), HttpStatus.OK);
	}
	
	@RequestMapping(value = "/feriados/{id}", method = RequestMethod.GET, produces = "application/json")
	public ResponseEntity<FeriadoVO> getFeriado(@PathVariable Integer id) {
		
		return new ResponseEntity<>(feriadoService.getFeriado(id), HttpStatus.OK);
	}
	
	@RequestMapping(value = "/feriados", method = RequestMethod.POST, produces = "application/json")
	public ResponseEntity<FeriadoVO> saveFeriado(@RequestBody FeriadoVO feriado) {
		
		return new ResponseEntity<>(feriadoService.saveFeriado(feriado), HttpStatus.OK);
	}
	
	@RequestMapping(value = "/feriado/{id}", method = RequestMethod.POST, produces = "application/json")
	public ResponseEntity<FeriadoVO> updateFeriado(@PathVariable Integer id,
			@RequestBody FeriadoVO concurso) {
		
		return new ResponseEntity<>(feriadoService.saveFeriado(concurso), HttpStatus.OK);
	}
	
	@RequestMapping(value = "/feriados/{id}", method = RequestMethod.DELETE, produces = "application/json")
	public ResponseEntity<FeriadoVO> deleteFeriado(@PathVariable Integer id) {
		
		return new ResponseEntity<>(feriadoService.deleteFeriado(id), HttpStatus.OK);
	}
}
