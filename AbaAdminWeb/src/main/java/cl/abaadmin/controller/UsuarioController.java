package cl.abaadmin.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.oauth2.provider.token.ConsumerTokenServices;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import cl.abaadmin.service.security.usuarios.UsuarioService;
import cl.abaadmin.vo.UsuarioVO;
import cl.abaadmin.vo.reportes.Sistemas;

@RestController
public class UsuarioController {
	
	@Autowired
	private ConsumerTokenServices consumerTokenServices;
	
	@Autowired
	private UsuarioService usuarioService;
	
	@Autowired
	private cl.abaadmin.service.security.web.usuarios.UsuarioWebService usuarioWebService;
	
	@RequestMapping(value="/roles/{rol}/usuarios", method= RequestMethod.GET, produces= "application/json")
	public ResponseEntity<List<UsuarioVO>> getUsuarios(
			@PathVariable(value= "rol") Integer rol,
			@RequestParam(value= "sistema") Integer sistema) {
		if (sistema == Sistemas.ADMIN.id())
			return new ResponseEntity<>(usuarioService.getUsuarios(rol), HttpStatus.OK);
		else
			return new ResponseEntity<>(usuarioWebService.getUsuarios(rol), HttpStatus.OK);
	}
	
	@RequestMapping(value="/roles/{rol}/usuarios/{id}", method= RequestMethod.GET, produces= "application/json")
	public ResponseEntity<UsuarioVO> getUsuario(@PathVariable(value="id") Integer id,
			@PathVariable(value= "rol") Integer rol,
			@RequestParam(value= "sistema") Integer sistema) {
		if (sistema == Sistemas.ADMIN.id())
			return new ResponseEntity<>(usuarioService.getUsuario(id), HttpStatus.OK);
		else
			return new ResponseEntity<>(usuarioWebService.getUsuario(id), HttpStatus.OK);
	}
	
	@RequestMapping(value= "/roles/{rol}/usuarios", method= RequestMethod.POST, produces= "application/json",
			consumes= "application/json")
	public ResponseEntity<UsuarioVO> saveUsuario(@RequestBody UsuarioVO usuario,
			@PathVariable(value= "rol") Integer rol,
			@RequestParam(value= "sistema") Integer sistema) {
		if (sistema == Sistemas.ADMIN.id())
			return new ResponseEntity<>(usuarioService.saveUsuario(usuario), HttpStatus.OK);
		else
			return new ResponseEntity<>(usuarioWebService.saveUsuario(usuario), HttpStatus.OK);
	}
	
	@RequestMapping(value="/roles/{rol}/usuarios/{id}", method= RequestMethod.DELETE, produces= "application/json")
	public ResponseEntity<UsuarioVO> deleteUsuario(@PathVariable(value="id") Integer id,
			@PathVariable(value= "rol") Integer rol,
			@RequestParam(value= "sistema") Integer sistema) {
		if (sistema == Sistemas.ADMIN.id())
			return new ResponseEntity<>(usuarioService.deleteUsuario(id), HttpStatus.OK);
		else
			return new ResponseEntity<>(usuarioWebService.deleteUsuario(id), HttpStatus.OK);
	}
	
	@RequestMapping(value="/revoke-token", method= RequestMethod.GET, produces= "application/json")
	public ResponseEntity<Boolean> logout(HttpServletRequest request) {
		String authorization = request.getHeader("Authorization");
        if (authorization != null && authorization.contains("Bearer")) {
            String tokenId = authorization.substring("Bearer".length() + 1);
            consumerTokenServices.revokeToken(tokenId);
        }
		return new ResponseEntity<>(true, HttpStatus.OK);
	}

}
