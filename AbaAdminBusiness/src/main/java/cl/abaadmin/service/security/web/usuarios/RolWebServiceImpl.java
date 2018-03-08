package cl.abaadmin.service.security.web.usuarios;

import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import cl.abaadmin.vo.RolVO;

@Service
public class RolWebServiceImpl implements RolWebService {

	@Autowired
	private cl.abaadmin.repository.web.security.RoleWebRepository roleRepositoryWeb;

	@Override
	public List<RolVO> getRoles() {

		List<cl.abaadmin.entities.web.security.Role> rolesWeb = roleRepositoryWeb.findAll();
		List<RolVO> rolesVO = new ArrayList<RolVO>();

		for (int i = 0; i < rolesWeb.size(); i++) {
			cl.abaadmin.entities.web.security.Role rol = rolesWeb.get(i);
			rolesVO.add(new RolVO(rol.getRoleId(), rol.getName(), rol.getDescription()));
		}

		return rolesVO;
	}

	@Override
	public RolVO getRol(Integer rolId) {

		RolVO rolVO;
		cl.abaadmin.entities.web.security.Role rol = roleRepositoryWeb.findOne(rolId);
		rolVO = new RolVO(rol.getRoleId(), rol.getName(), rol.getDescription());
		return rolVO;
	}

	@Override
	public RolVO saveRol(RolVO rol) {

		cl.abaadmin.entities.web.security.Role rolNew = new cl.abaadmin.entities.web.security.Role();

		if (rol.getRolId() != null)
			rolNew.setRoleId(rol.getRolId());
		else
			rolNew.setRoleId(roleRepositoryWeb.getMaxId() + 1);

		rolNew.setName(rol.getNombre());
		rolNew.setDescription(rol.getDescripcion());
		rolNew = roleRepositoryWeb.save(rolNew);
		rol.setRolId(rolNew.getRoleId());

		return rol;
	}

	@Override
	public RolVO deleteRol(Integer rolId) {
		cl.abaadmin.entities.web.security.Role rol = roleRepositoryWeb.getOne(rolId);
		roleRepositoryWeb.delete(rol);
		return new RolVO(rol.getRoleId(), rol.getName(), rol.getDescription());
	}
}
