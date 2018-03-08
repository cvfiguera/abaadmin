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

import cl.abaadmin.entities.web.web.Rbd;
import cl.abaadmin.service.web.rbd.RbdService;
import cl.abaadmin.vo.RbdVO;

@RestController
public class RbdController {

	@Autowired
	private RbdService rbdService;
	
	@RequestMapping(value = "/rbds", method = RequestMethod.GET, produces = "application/json")
	public ResponseEntity<Page<Rbd>> getRbds(@RequestParam(value= "first") Integer first,
			@RequestParam(value= "rows") Integer rows, @RequestParam(value= "sortField") String sortField,
			@RequestParam(value= "sortOrder") String sortOrder,
			@RequestParam(value= "rbd") Long rbd,
			@RequestParam(value= "nombre") String nombre,
			@RequestParam(value= "region") Integer region,
			@RequestParam(value= "comuna") Integer comuna) {
		
		return new ResponseEntity<>(rbdService.getRbds(new PageRequest((first/rows), rows, 
				new Sort(sortOrder.contentEquals("asc")? Sort.Direction.ASC : Sort.Direction.DESC, sortField)), rbd, nombre, region, comuna), HttpStatus.OK);
	}
	
	@RequestMapping(value = "/rbds/{id}", method = RequestMethod.GET, produces = "application/json")
	public ResponseEntity<RbdVO> getRbd(@PathVariable Integer id) {
		
		return new ResponseEntity<>(rbdService.getRbd(id), HttpStatus.OK);
	}
	
	@RequestMapping(value = "/rbds", method = RequestMethod.POST, produces = "application/json")
	public ResponseEntity<RbdVO> saveRbd(@RequestBody RbdVO rbd) {
		
		return new ResponseEntity<>(rbdService.saveRbd(rbd), HttpStatus.OK);
	}
	
	@RequestMapping(value = "/rbds/{id}", method = RequestMethod.POST, produces = "application/json")
	public ResponseEntity<RbdVO> updateRbd(@PathVariable Integer id,
			@RequestBody RbdVO rbd) {
		
		return new ResponseEntity<>(rbdService.saveRbd(rbd), HttpStatus.OK);
	}
	
	@RequestMapping(value = "/rbds/{id}", method = RequestMethod.DELETE, produces = "application/json")
	public ResponseEntity<Page<Rbd>> deleteRbd(@PathVariable Integer id) {
		
		HttpStatus status;
		
		if (rbdService.deleteRbd(id))
			status = HttpStatus.OK;
		else
			status = HttpStatus.NOT_MODIFIED;
		
		return new ResponseEntity<>(rbdService.getRbds(new PageRequest(0/10,10, new Sort(Sort.Direction.ASC, "rbd"))), status);
	}
}
