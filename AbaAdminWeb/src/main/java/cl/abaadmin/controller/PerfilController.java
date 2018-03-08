package cl.abaadmin.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import cl.abaadmin.service.web.perfil.PerfilService;
import cl.abaadmin.vo.PerfilVO;

@RestController
public class PerfilController {
	
	@Autowired
	private PerfilService perfilService;
	
	@RequestMapping(value="/perfil", method= RequestMethod.GET, produces= "application/json")
	public ResponseEntity<PerfilVO> getPerfil() {
		
		Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		UserDetails userDetails = null;
		if (principal instanceof UserDetails) {
		  userDetails = (UserDetails) principal;
		}
		String username = userDetails.getUsername();
		
		return new ResponseEntity<>(perfilService.getPerfil(username), HttpStatus.OK);
	}
	
	@RequestMapping(value= "/perfil", method= RequestMethod.POST, produces= "application/json",
			consumes= "application/json")
	public ResponseEntity<PerfilVO> updatePerfil(@RequestBody PerfilVO perfil) {
		return new ResponseEntity<>(perfilService.updatePerfilVO(perfil), HttpStatus.OK);
	}

}
