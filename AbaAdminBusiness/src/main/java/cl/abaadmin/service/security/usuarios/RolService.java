package cl.abaadmin.service.security.usuarios;

import java.util.List;

import cl.abaadmin.vo.RolVO;

public interface RolService {
	
	public List<RolVO> getRoles();
	
	public RolVO getRol(Integer rolId);
	
	public RolVO saveRol(RolVO rol);
	
	public RolVO deleteRol(Integer rolId);

}
