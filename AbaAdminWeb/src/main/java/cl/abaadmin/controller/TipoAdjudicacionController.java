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

import cl.abaadmin.service.web.tipoAdjudicacion.TipoAdjudicacionService;
import cl.abaadmin.vo.TipoAdjudicacionVO;

@RestController
public class TipoAdjudicacionController {

	@Autowired
	TipoAdjudicacionService tipoAdjService;
	
	@RequestMapping(value="/tiposadj", method = RequestMethod.GET, produces= "application/json")
	public ResponseEntity<List<TipoAdjudicacionVO>> getTipoAdjudicaciones() {
		return new ResponseEntity<>(tipoAdjService.getTipoAdjudicaciones(), HttpStatus.OK);
	}
	
	@RequestMapping(value="/tiposadj/{id}", method = RequestMethod.GET, produces= "application/json")
	public ResponseEntity<TipoAdjudicacionVO> getTipoAdjudicacion(@PathVariable(value="id") Integer id) {
		return new ResponseEntity<>(tipoAdjService.getTipoAdjudicacion(id), HttpStatus.OK);
	}
	
	@RequestMapping(value= "/tiposadj", method = RequestMethod.POST, produces = "application/json",
			consumes = "application/json")
	public ResponseEntity<TipoAdjudicacionVO> saveTipoAdjudicacion(@RequestBody TipoAdjudicacionVO tipoAdjudicacion) {
		return new ResponseEntity<>(tipoAdjService.saveTipoAdjudicacion(tipoAdjudicacion), HttpStatus.OK);
	}
	
	@RequestMapping(value = "/tiposadj/{id}", method = RequestMethod.DELETE, produces = "application/json")
	public ResponseEntity<TipoAdjudicacionVO> deleteTipoAdjudicacion(@PathVariable(value = "id") Integer id) {
		return new ResponseEntity<>(tipoAdjService.deleteTipoAdjudicacion(id), HttpStatus.OK);
	}
}
