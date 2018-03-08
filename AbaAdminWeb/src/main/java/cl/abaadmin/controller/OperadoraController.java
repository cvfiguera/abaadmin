package cl.abaadmin.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import cl.abaadmin.entities.web.web.Operadora;
import cl.abaadmin.service.web.operadora.OperadoraService;
import cl.abaadmin.vo.OperadoraVO;

@RestController
public class OperadoraController {
	
	@Autowired
	private OperadoraService operadoraService;
	
	@RequestMapping(value = "/operadoras", method = RequestMethod.GET, produces = "application/json")
	public ResponseEntity<Page<Operadora>> getOperadoras(@RequestParam(value= "first") Integer first,
			@RequestParam(value= "rows") Integer rows, @RequestParam(value= "sortField") String sortField,
			@RequestParam(value= "sortOrder") String sortOrder,
			@RequestParam(value= "rut") String rut,
			@RequestParam(value= "nombre") String nombre) {
		
		return new ResponseEntity<>(operadoraService.getOperadoras(new PageRequest((first/rows), rows, 
				new Sort(sortOrder.contentEquals("asc")? Sort.Direction.ASC : Sort.Direction.DESC, sortField)), rut, nombre), HttpStatus.OK);
	}
	
	
	@RequestMapping(value = "/operadoras/{id}", method = RequestMethod.GET, produces = "application/json")
	public ResponseEntity<OperadoraVO> getOperadora(@PathVariable Integer id) {
		
		return new ResponseEntity<>(operadoraService.getOperadora(id), HttpStatus.OK);
	}
	
	@RequestMapping(value = "/operadoras", method = RequestMethod.POST, produces = "application/json")
	public ResponseEntity<OperadoraVO> saveOperadora(@RequestBody OperadoraVO operadora) {
		
		return new ResponseEntity<>(operadoraService.saveOperadora(operadora), HttpStatus.OK);
	}
	
	@RequestMapping(value = "/operadoras/{id}", method = RequestMethod.POST, produces = "application/json")
	public ResponseEntity<OperadoraVO> updateOperadora(@PathVariable Integer id,
			@RequestBody OperadoraVO operadora) {
		
		return new ResponseEntity<>(operadoraService.saveOperadora(operadora), HttpStatus.OK);
	}
	
	@RequestMapping(value = "/operadoras/{id}", method = RequestMethod.DELETE, produces = "application/json")
	public ResponseEntity<Page<Operadora>> deleteOperadora(@PathVariable Integer id) {
		
		HttpStatus status;
		
		if (operadoraService.deleteOperadora(id))
			status = HttpStatus.OK;
		else
			status = HttpStatus.NOT_MODIFIED;
		
		return new ResponseEntity<>(operadoraService.getOperadoras(new PageRequest((0/10),10, new Sort(Sort.Direction.ASC, "operadoraId"))), status);
	}
}
