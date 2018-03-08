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
import cl.abaadmin.service.web.contacto.ContactoService;
import cl.abaadmin.vo.ContactoVO;

@RestController
public class ContactoController {
	
	@Autowired
	ContactoService contactoService;
	
	@RequestMapping(value = "/rbds/{id}/contactos", method = RequestMethod.GET, produces = "application/json")
	public ResponseEntity<List<ContactoVO>> getContactos(@PathVariable Integer id) {
		
		return new ResponseEntity<>(contactoService.getContactos(id), HttpStatus.OK);
	}
	
	
	@RequestMapping(value = "/rbds/{id}/contactos/{contactoId}", method = RequestMethod.GET, produces = "application/json")
	public ResponseEntity<ContactoVO> getContacto(@PathVariable Integer id, @PathVariable Integer contactoId) {
		
		return new ResponseEntity<>(contactoService.getContacto(id, contactoId), HttpStatus.OK);
	}
	
	@RequestMapping(value = "/rbds/{id}/contactos", method = RequestMethod.POST, produces = "application/json")
	public ResponseEntity<ContactoVO> saveContacto(@PathVariable Integer id, @RequestBody ContactoVO contacto) {
		
		return new ResponseEntity<>(contactoService.saveContacto(id, contacto), HttpStatus.OK);
	}
	
	@RequestMapping(value = "/rbds/{id}/contactos/{contactoId}", method = RequestMethod.DELETE, produces = "application/json")
	public ResponseEntity<List<ContactoVO>> deleteTecnologia(@PathVariable Integer id, @PathVariable Integer contactoId) {
		
		HttpStatus status;
		
		if (contactoService.deleteContacto(id, contactoId))
			status = HttpStatus.OK;
		else
			status = HttpStatus.NOT_MODIFIED;
		
		return new ResponseEntity<>(contactoService.getContactos(id), status);
	}
}
