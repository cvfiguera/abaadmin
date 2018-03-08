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
import cl.abaadmin.service.web.concurso.ConcursoService;
import cl.abaadmin.vo.ConcursoVO;

@RestController
public class ConcursoController {

	@Autowired
	ConcursoService concursoService;
	
	@RequestMapping(value = "/concursos", method = RequestMethod.GET, produces = "application/json")
	public ResponseEntity<List<ConcursoVO>> getConcursos() {
		
		return new ResponseEntity<>(concursoService.getConcursos(), HttpStatus.OK);
	}
	
	
	@RequestMapping(value = "/concursos/{id}", method = RequestMethod.GET, produces = "application/json")
	public ResponseEntity<ConcursoVO> getConcurso(@PathVariable Integer id) {
		
		return new ResponseEntity<>(concursoService.getConcurso(id), HttpStatus.OK);
	}
	
	@RequestMapping(value = "/concursos", method = RequestMethod.POST, produces = "application/json")
	public ResponseEntity<ConcursoVO> saveConcurso(@RequestBody ConcursoVO concurso) {
		
		return new ResponseEntity<>(concursoService.saveConcurso(concurso), HttpStatus.OK);
	}
	
	@RequestMapping(value = "/concursos/{id}", method = RequestMethod.POST, produces = "application/json")
	public ResponseEntity<ConcursoVO> updateConcurso(@PathVariable Integer id,
			@RequestBody ConcursoVO concurso) {
		
		return new ResponseEntity<>(concursoService.saveConcurso(concurso), HttpStatus.OK);
	}
	
	@RequestMapping(value = "/concursos/{id}", method = RequestMethod.DELETE, produces = "application/json")
	public ResponseEntity<List<ConcursoVO>> deleteConcurso(@PathVariable Integer id) {
		
		HttpStatus status;
		
		if (concursoService.deleteConcurso(id))
			status = HttpStatus.OK;
		else
			status = HttpStatus.NOT_MODIFIED;
		
		return new ResponseEntity<>(concursoService.getConcursos(), status);
	}
}
