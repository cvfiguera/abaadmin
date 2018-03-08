package cl.abaadmin.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import cl.abaadmin.entities.web.web.RegionSet;
import cl.abaadmin.service.web.region.RegionService;


@RestController
public class RegionController {

	@Autowired
	private RegionService regionService;
	
	@RequestMapping(value = "/regiones", method = RequestMethod.GET, produces = "application/json")
	public ResponseEntity<Page<RegionSet>> getOperadoras() {
		
			return new ResponseEntity<>(regionService.getRegiones(), HttpStatus.OK);
	}
}
