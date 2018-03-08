package cl.abaadmin.service.security.web.usuarios;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import cl.abaadmin.repository.web.security.RoleWebRepository;
import cl.abaadmin.repository.web.security.UserWebRepository;
import cl.abaadmin.vo.UsuarioVO;

@Service
public class UsuarioWebServiceImpl implements UsuarioWebService {

	@Autowired
	private UserWebRepository userWebRepository;
	@Autowired
	private RoleWebRepository roleWebRepository;

	@Override
	public List<UsuarioVO> getUsuarios(Integer rol) {

		List<UsuarioVO> usuariosVO = new ArrayList<UsuarioVO>();

		List<cl.abaadmin.entities.web.security.User> usuarios = userWebRepository.findByRoleRoleId(rol);
		for (int i = 0; i < usuarios.size(); i++) {
			cl.abaadmin.entities.web.security.User usuario = usuarios.get(i);
			usuariosVO.add(new UsuarioVO(usuario.getUserId(), usuario.getUsername(), usuario.getPassword(),
					usuario.getEmail(), usuario.getEnabled(), usuario.getN(), usuario.getnMax(), usuario.getRut(),
					usuario.getPhone(), usuario.getOrganization(), usuario.getFirsName(), usuario.getLastName(),
					usuario.getRole().getRoleId()));
		}

		return usuariosVO;
	}

	@Override
	public UsuarioVO getUsuario(Integer usuarioId) {

		cl.abaadmin.entities.web.security.User usuario = userWebRepository.getOne(usuarioId);
		return new UsuarioVO(usuario.getUserId(), usuario.getUsername(), usuario.getPassword(), usuario.getEmail(),
				usuario.getEnabled(), usuario.getN(), usuario.getnMax(), usuario.getRut(), usuario.getPhone(),
				usuario.getOrganization(), usuario.getFirsName(), usuario.getLastName(), usuario.getRole().getRoleId());

	}

	@Override
	public UsuarioVO saveUsuario(UsuarioVO usuario) {

		cl.abaadmin.entities.web.security.User usuarioNew;
		if (usuario.getUsuarioId() != null) {
			usuarioNew = userWebRepository.getOne(usuario.getUsuarioId());
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
			usuarioNew.setRole(roleWebRepository.getOne(usuario.getRolId()));
		} else {
			usuarioNew = new cl.abaadmin.entities.web.security.User(userWebRepository.getMaxId() + 1,
					usuario.getUsername(), UUID.randomUUID().toString(), usuario.getEmail(), usuario.getBloqueado(), 0,
					usuario.getIntentosMax(), usuario.getRut(), usuario.getTelefono(), usuario.getOrganizacion(),
					usuario.getNombre(), usuario.getApellido(), roleWebRepository.getOne(usuario.getRolId()));
		}
		userWebRepository.save(usuarioNew);

		return usuario;
	}

	@Override
	public UsuarioVO deleteUsuario(Integer usuarioId) {

		cl.abaadmin.entities.web.security.User usuario;
		usuario = userWebRepository.findOne(usuarioId);
		userWebRepository.delete(usuario);
		return new UsuarioVO(usuario.getUserId(), usuario.getUsername(), usuario.getPassword(), usuario.getEmail(),
				usuario.getEnabled(), usuario.getN(), usuario.getnMax(), usuario.getRut(), usuario.getPhone(),
				usuario.getOrganization(), usuario.getFirsName(), usuario.getLastName(), usuario.getRole().getRoleId());
	}
}
