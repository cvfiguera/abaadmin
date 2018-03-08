package cl.abaadmin.service.security.usuarios;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cl.abaadmin.entities.control.security.User;
import cl.abaadmin.repository.control.security.RoleRepository;
import cl.abaadmin.repository.control.security.UserRepository;
import cl.abaadmin.vo.UsuarioVO;

@Service
public class UsuarioServiceImpl implements UsuarioService {

	@Autowired
	private UserRepository userControlRepository;
	@Autowired
	private RoleRepository roleControlRepository;

	@Override
	public List<UsuarioVO> getUsuarios(Integer rol) {

		List<UsuarioVO> usuariosVO = new ArrayList<UsuarioVO>();

		List<User> usuarios = userControlRepository.findByRoleRoleId(rol);
		for (int i = 0; i < usuarios.size(); i++) {
			User usuario = usuarios.get(i);
			usuariosVO.add(new UsuarioVO(usuario.getUserId(), usuario.getUsername(), usuario.getPassword(),
					usuario.getEmail(), usuario.getEnabled(), usuario.getN(), usuario.getnMax(), usuario.getRut(),
					usuario.getPhone(), usuario.getOrganization(), usuario.getFirsName(), usuario.getLastName(),
					usuario.getRole().getRoleId()));
		}
		return usuariosVO;
	}

	@Override
	public UsuarioVO getUsuario(Integer usuarioId) {

		User usuario = userControlRepository.getOne(usuarioId);
		return new UsuarioVO(usuario.getUserId(), usuario.getUsername(), usuario.getPassword(), usuario.getEmail(),
				usuario.getEnabled(), usuario.getN(), usuario.getnMax(), usuario.getRut(), usuario.getPhone(),
				usuario.getOrganization(), usuario.getFirsName(), usuario.getLastName(), usuario.getRole().getRoleId());
	}

	@Override
	public UsuarioVO saveUsuario(UsuarioVO usuario) {

		User usuarioNew;
		if (usuario.getUsuarioId() != null) {
			usuarioNew = userControlRepository.getOne(usuario.getUsuarioId());
			usuarioNew.setRut(usuario.getRut());
			usuarioNew.setFirsName(usuario.getNombre());
			usuarioNew.setLastName(usuario.getApellido());
			usuarioNew.setEmail(usuario.getEmail());
			usuarioNew.setUsername(usuario.getUsername());
			usuarioNew.setPhone(usuario.getTelefono());
			usuarioNew.setOrganization(usuario.getOrganizacion());
			usuarioNew.setN(0);
			usuarioNew.setnMax(usuario.getIntentosMax());
			usuarioNew.setEnabled(usuario.getBloqueado());
			usuarioNew.setRole(roleControlRepository.getOne(usuario.getRolId()));
		} else {
			usuarioNew = new User(userControlRepository.getMaxId() + 1, usuario.getUsername(),
					UUID.randomUUID().toString(), usuario.getEmail(), usuario.getBloqueado(), 0,
					usuario.getIntentosMax(), usuario.getRut(), usuario.getTelefono(), usuario.getOrganizacion(),
					usuario.getNombre(), usuario.getApellido(), roleControlRepository.getOne(usuario.getRolId()));
		}
		userControlRepository.save(usuarioNew);

		return usuario;
	}

	@Override
	public UsuarioVO deleteUsuario(Integer usuarioId) {

		User usuario;
		usuario = userControlRepository.findOne(usuarioId);
		userControlRepository.delete(usuario);
		return new UsuarioVO(usuario.getUserId(), usuario.getUsername(), usuario.getPassword(), usuario.getEmail(),
				usuario.getEnabled(), usuario.getN(), usuario.getnMax(), usuario.getRut(), usuario.getPhone(),
				usuario.getOrganization(), usuario.getFirsName(), usuario.getLastName(), usuario.getRole().getRoleId());
	}
}
