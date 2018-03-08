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

import cl.abaadmin.service.web.estado.EstadoService;
import cl.abaadmin.vo.EstadoVO;
import cl.abaadmin.vo.SubEstadoVO;
import cl.abaadmin.vo.TecnologiaVO;

@RestController
public class EstadoController {

	@Autowired
	private EstadoService estadoService;
	
	@RequestMapping(value="/estados", method = RequestMethod.GET, produces = "application/json")
	public ResponseEntity<List> getEstados(@RequestParam(value="tipo") Integer tipo) {
		
		if (tipo == 4) {
			return new ResponseEntity<>(estadoService.getSubEstados(), HttpStatus.OK);
		} else {
			return new ResponseEntity<>(estadoService.getEstados(tipo), HttpStatus.OK);
		}
		
	}
	
	@RequestMapping(value="/estados", method = RequestMethod.POST, produces = "application/json")
	public ResponseEntity<Object> saveEstado(@RequestParam(value="tipo") Integer tipo,
			@RequestBody SubEstadoVO subestado) {
		
		if (tipo == 4) {
			return new ResponseEntity<>(estadoService.saveSubEstado(subestado), HttpStatus.OK);
		} else {
			return new ResponseEntity<>(estadoService.saveEstado(tipo,
						new EstadoVO(subestado.getEstadoId(), subestado.getDescripcion())), HttpStatus.OK);
		}
	}
	
	@RequestMapping(value = "/estados/{id}", method = RequestMethod.DELETE, produces = "application/json")
	public ResponseEntity<List> deleteEstado(@PathVariable Integer id, 
			@RequestParam(value="tipo")  Integer tipo) {
		
		HttpStatus status;
		
		if (estadoService.deleteEstado(tipo, id))
			status = HttpStatus.OK;
		else
			status = HttpStatus.NOT_MODIFIED;
		
		if (tipo == 4) {
			return new ResponseEntity<>(estadoService.getSubEstados(), status);
		} else {
			return new ResponseEntity<>(estadoService.getEstados(tipo), status);
		}
	}
}
