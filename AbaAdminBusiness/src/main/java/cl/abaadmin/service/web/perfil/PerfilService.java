package cl.abaadmin.service.web.perfil;

import cl.abaadmin.vo.PerfilVO;

public interface PerfilService {
	
	public PerfilVO getPerfil(String username);
	
	public PerfilVO updatePerfilVO(PerfilVO perfil);

}
