package cl.abaadmin.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import cl.abaadmin.service.filtro.FiltroService;
import cl.abaadmin.service.web.operadora.OperadoraService;
import cl.abaadmin.vo.FiltroOperadoraVO;
import cl.abaadmin.vo.FiltroVO;

@RestController
public class FilterController {

	@Autowired
	private FiltroService filtroService;
	
	@RequestMapping(value = "/filtros/operadoras", method = RequestMethod.GET, produces = "application/json")
	public ResponseEntity<List<FiltroOperadoraVO>> getFiltroOperadoras() {
		
			return new ResponseEntity<>(filtroService.getOperadoras(), HttpStatus.OK);
	}
	
	@RequestMapping(value = "/filtros/tecnologias", method = RequestMethod.GET, produces = "application/json")
	public ResponseEntity<List<FiltroVO>> getFiltroTecnologias() {
		
			return new ResponseEntity<>(filtroService.getTecnologias(), HttpStatus.OK);
	}
	
}
