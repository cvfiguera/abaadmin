package cl.abaadmin.service.security.web.usuarios;

import java.util.List;

import cl.abaadmin.vo.UsuarioVO;

public interface UsuarioWebService {
	
	public List<UsuarioVO> getUsuarios(Integer rol);
	
	public UsuarioVO getUsuario(Integer usuarioId);

	public UsuarioVO saveUsuario(UsuarioVO usuario);
	
	public UsuarioVO deleteUsuario(Integer usuarioId);

}
