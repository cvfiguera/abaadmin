package cl.abaadmin.service.web.perfil;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import cl.abaadmin.entities.control.security.User;
import cl.abaadmin.repository.control.security.UserRepository;
import cl.abaadmin.vo.PerfilVO;

@Service
public class PerfilServiceImpl implements PerfilService {

	@Autowired
	private UserRepository userRepository;
	
	@Override
	public PerfilVO getPerfil(String username) {

		User usuario = userRepository.findOneByUsername(username);
		
		return new PerfilVO(usuario.getUserId(), usuario.getUsername(),
				usuario.getPassword(), usuario.getPassword(),
				usuario.getEmail(), usuario.getRut(), usuario.getPhone(),
				usuario.getOrganization(), usuario.getFirsName(), usuario.getLastName(),
				usuario.getRole().getName());
	}

	@Override
	public PerfilVO updatePerfilVO(PerfilVO perfil) {

		User usuario = userRepository.findOneByUsername(perfil.getUsername());
		
		usuario.setEmail(perfil.getEmail());
		usuario.setPhone(perfil.getTelefono());
		usuario.setPassword(perfil.getPass());
		usuario.setFirsName(perfil.getNombre());
		usuario.setLastName(perfil.getApellido());
		
		userRepository.saveAndFlush(usuario);
		
		return perfil;
	}
	

}
