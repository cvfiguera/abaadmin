package cl.abaadmin.service.security.web.usuarios;

import java.util.List;

import cl.abaadmin.vo.RolVO;

public interface RolWebService {
	
	public List<RolVO> getRoles();
	
	public RolVO getRol(Integer rolId);
	
	public RolVO saveRol(RolVO rol);
	
	public RolVO deleteRol(Integer rolId);

}
