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

import cl.abaadmin.service.web.listaEspera.ListaEsperaService;
import cl.abaadmin.vo.ListaEsperaVO;

@RestController
public class ListaEsperaController {
	
	@Autowired
	private ListaEsperaService listaEService;
	
	@RequestMapping(value="/tiposadj/{id}/listase", method = RequestMethod.GET, produces = "application/json")
	public ResponseEntity<List<ListaEsperaVO>> getListasEspera(@PathVariable(value = "id") Integer id) {
		return new ResponseEntity<>(listaEService.getListaEspera(id), HttpStatus.OK);
	}
	
	@RequestMapping(value="/tiposadj/{id}/listase/{listaId}", method = RequestMethod.GET, produces = "application/json")
	public ResponseEntity<ListaEsperaVO> getListaEspera(@PathVariable(value = "id") Integer id,
			@PathVariable(value = "listaId") Integer listaId) {
		return new ResponseEntity<>(listaEService.getListaEspera(id, listaId), HttpStatus.OK);
	}
	
	@RequestMapping(value = "/tiposadj/{id}/listase", method = RequestMethod.POST, produces = "application/json",
			consumes = "application/json")
	public ResponseEntity<ListaEsperaVO> saveListaEspera(@PathVariable(value = "id") Integer id,
			@RequestBody ListaEsperaVO listaEVO) {
		return new ResponseEntity<>(listaEService.saveListaEspera(id, listaEVO), HttpStatus.OK);
	}
	
	@RequestMapping(value="/tiposadj/{id}/listase/{listaId}", method = RequestMethod.DELETE, produces = "application/json")
	public ResponseEntity<ListaEsperaVO> deleteListaEspera(@PathVariable(value="id") Integer id,
			@PathVariable(value = "listaId") Integer listaId) {
		return new ResponseEntity<>(listaEService.deleteListaEspera(id, listaId), HttpStatus.OK);
	}
}
