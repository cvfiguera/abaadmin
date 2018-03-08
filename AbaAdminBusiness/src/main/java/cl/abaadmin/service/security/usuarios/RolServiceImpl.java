package cl.abaadmin.service.security.usuarios;

import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import cl.abaadmin.entities.control.security.Role;
import cl.abaadmin.repository.control.security.RoleRepository;
import cl.abaadmin.vo.RolVO;

@Service
public class RolServiceImpl implements RolService {

	@Autowired
	private RoleRepository rolRepositoryControl;

	@Override
	public List<RolVO> getRoles() {

		List<RolVO> rolesVO = new ArrayList<RolVO>();
		List<Role> rolesControl = rolRepositoryControl.findAll();

		for (int i = 0; i < rolesControl.size(); i++) {
			Role rol = rolesControl.get(i);
			rolesVO.add(new RolVO(rol.getRoleId(), rol.getName(), rol.getDescription()));
		}

		return rolesVO;
	}

	@Override
	public RolVO getRol(Integer rolId) {

		RolVO rolVO;

		Role rol = rolRepositoryControl.findOne(rolId);
		rolVO = new RolVO(rol.getRoleId(), rol.getName(), rol.getDescription());

		return rolVO;
	}

	@Override
	public RolVO saveRol(RolVO rol) {

		Role rolNew = new Role();

		if (rol.getRolId() != null)
			rolNew.setRoleId(rol.getRolId());
		else
			rolNew.setRoleId(rolRepositoryControl.getMaxId() + 1);

		rolNew.setName(rol.getNombre());
		rolNew.setDescription(rol.getDescripcion());
		rolNew = rolRepositoryControl.save(rolNew);
		rol.setRolId(rolNew.getRoleId());

		return rol;

	}

	@Override
	public RolVO deleteRol(Integer rolId) {

		Role rol = rolRepositoryControl.getOne(rolId);
		rolRepositoryControl.delete(rol);
		return new RolVO(rol.getRoleId(), rol.getName(), rol.getDescription());
	}
}
