package cl.abaadmin.controller;

import java.util.ArrayList;
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

import cl.abaadmin.service.security.usuarios.RolService;
import cl.abaadmin.vo.RolVO;
import cl.abaadmin.vo.SistemaVO;
import cl.abaadmin.vo.reportes.Sistemas;

@RestController
public class RolController {

	@Autowired
	private RolService rolService;
	@Autowired
	private cl.abaadmin.service.security.web.usuarios.RolWebService rolWebService;
	
	@RequestMapping(value="/roles", method= RequestMethod.GET, produces= "application/json")
	public ResponseEntity<List<SistemaVO>> getRoles() {
		List<SistemaVO> sistemas = new ArrayList<SistemaVO>();
		sistemas.add(new SistemaVO(Sistemas.ADMIN.id(), Sistemas.ADMIN.nombre(), rolService.getRoles()));
		sistemas.add(new SistemaVO(Sistemas.WEB.id(), Sistemas.WEB.nombre(), rolWebService.getRoles()));
		return new ResponseEntity<>(sistemas, HttpStatus.OK);
	}
	
	@RequestMapping(value="/roles/{id}", method= RequestMethod.GET, produces= "application/json")
	public ResponseEntity<RolVO> getRol(@PathVariable(value="id") Integer id,
			@RequestParam(value= "sistema") Integer sistema) {
		if (sistema == Sistemas.ADMIN.id())
			return new ResponseEntity<>(rolService.getRol(id), HttpStatus.OK);
		else
			return new ResponseEntity<>(rolWebService.getRol(id), HttpStatus.OK);
	}
	
	@RequestMapping(value="/roles", method= RequestMethod.POST, produces= "application/json",
			consumes= "application/json")
	public ResponseEntity<RolVO> saveRol(@RequestBody RolVO rol,
			@RequestParam(value= "sistema") Integer sistema) { 
		if (sistema == Sistemas.ADMIN.id())
			return new ResponseEntity<>(rolService.saveRol(rol), HttpStatus.OK);
		else
			return new ResponseEntity<>(rolWebService.saveRol(rol), HttpStatus.OK);
	}
	
	@RequestMapping(value="/roles/{id}", method= RequestMethod.DELETE, produces= "application/json")
	public ResponseEntity<RolVO> deleteRol(@PathVariable(value= "id") Integer id,
			@RequestParam(value= "sistema") Integer sistema) {
		if (sistema == Sistemas.ADMIN.id())
			return new ResponseEntity<>(rolService.deleteRol(id), HttpStatus.OK);
		else
			return new ResponseEntity<>(rolWebService.deleteRol(id), HttpStatus.OK);
	}
}
