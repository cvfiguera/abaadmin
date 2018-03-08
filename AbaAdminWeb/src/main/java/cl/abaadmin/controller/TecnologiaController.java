package cl.abaadmin.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import cl.abaadmin.service.tecnologia.TecnologiaService;
import cl.abaadmin.vo.TecnologiaVO;

@RestController
public class TecnologiaController {

	@Autowired
	TecnologiaService tecnologiaService;
	
	@RequestMapping(value = "/tecnologias", method = RequestMethod.GET, produces = "application/json")
	public ResponseEntity<List<TecnologiaVO>> getTecnologias() {
		
		return new ResponseEntity<>(tecnologiaService.getTecnologias(), HttpStatus.OK);
	}
	
	
	@RequestMapping(value = "/tecnologias/{id}", method = RequestMethod.GET, produces = "application/json")
	public ResponseEntity<TecnologiaVO> getTecnologia(@PathVariable Integer id) {
		
		return new ResponseEntity<>(tecnologiaService.getTecnologia(id), HttpStatus.OK);
	}
	
	@RequestMapping(value = "/tecnologias", method = RequestMethod.POST, produces = "application/json")
	public ResponseEntity<TecnologiaVO> saveTecnologia(@RequestBody TecnologiaVO tecnologia) {
		
		return new ResponseEntity<>(tecnologiaService.saveTecnologia(tecnologia), HttpStatus.OK);
	}
	
	@RequestMapping(value = "/tecnologias/{id}", method = RequestMethod.POST, produces = "application/json")
	public ResponseEntity<TecnologiaVO> updateTecnologia(@PathVariable Integer id,
			@RequestBody TecnologiaVO tecnologia) {
		
		return new ResponseEntity<>(tecnologiaService.saveTecnologia(tecnologia), HttpStatus.OK);
	}
	
	@RequestMapping(value = "/tecnologias/{id}", method = RequestMethod.DELETE, produces = "application/json")
	public ResponseEntity<List<TecnologiaVO>> deleteTecnologia(@PathVariable Integer id) {
		
		HttpStatus status;
		
		if (tecnologiaService.deleteTecnologia(id))
			status = HttpStatus.OK;
		else
			status = HttpStatus.NOT_MODIFIED;
		
		return new ResponseEntity<>(tecnologiaService.getTecnologias(), status);
	}
}
