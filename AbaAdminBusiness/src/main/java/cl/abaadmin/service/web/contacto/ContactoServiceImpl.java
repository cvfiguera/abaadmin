package cl.abaadmin.service.web.contacto;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cl.abaadmin.entities.web.web.Contacto;
import cl.abaadmin.entities.web.web.Rbd;
import cl.abaadmin.repository.web.web.ContactoRepository;
import cl.abaadmin.repository.web.web.RbdRepository;
import cl.abaadmin.vo.ContactoVO;

@Service
public class ContactoServiceImpl implements ContactoService {

	@Autowired
	private ContactoRepository contactoRepository;
	@Autowired
	private RbdRepository rbdRepository;
	SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
	
	@Override
	public List<ContactoVO> getContactos(Integer rbdId) {
		List<Contacto> contactos = contactoRepository.findByRbdRbdId(rbdId);
		List<ContactoVO> contactosVO = new ArrayList<ContactoVO>();
		
		for(int i=0; i<contactos.size(); i++) {
			Contacto contacto = contactos.get(i);
			contactosVO.add(new ContactoVO(contacto.getContactoId(), contacto.getNombre(),
					contacto.getCargo(), contacto.getTelefono1(), contacto.getTelefono2(),
					contacto.getEmail(), contacto.getFechaBaja()==null?null:this.sdf.format(contacto.getFechaBaja()), contacto.getRbd().getRbdId()));
		}
		
		return contactosVO;
	}

	@Override
	public ContactoVO getContacto(Integer rbdId, Integer contactoId) {
		
		Contacto contacto = contactoRepository.findOne(contactoId);
		return new ContactoVO(contacto.getContactoId(), contacto.getNombre(),
				contacto.getCargo(), contacto.getTelefono1(), contacto.getTelefono2(),
				contacto.getEmail(), this.sdf.format(contacto.getFechaBaja()), contacto.getRbd().getRbdId());
	}

	@Override
	public ContactoVO saveContacto(Integer rbdId, ContactoVO contacto) {
		
		Contacto contactoNew = new Contacto();
		Rbd rbd = rbdRepository.findOne(rbdId);
		
		if (contacto.getContactoId()!=null)
			contactoNew.setContactoId(contacto.getContactoId());
		contactoNew.setNombre(contacto.getNombre());
		contactoNew.setCargo(contacto.getCargo());
		contactoNew.setTelefono1(contacto.getTelefono1());
		contactoNew.setTelefono2(contacto.getTelefono2());
		contactoNew.setEmail(contacto.getEmail());
		try {
			contactoNew.setFechaBaja((contacto.getFechaBaja()==null || contacto.getFechaBaja()=="")?null:this.sdf.parse(contacto.getFechaBaja()));
		} catch (ParseException e) {
			e.printStackTrace();
		}
		contactoNew.setRbd(rbd);
		
		contactoNew = contactoRepository.save(contactoNew);
		contacto.setContactoId(contactoNew.getContactoId());
		return contacto;
	}

	@Override
	public Boolean deleteContacto(Integer rbdId, Integer contactoId) {

		Contacto contacto = contactoRepository.getOne(contactoId);
		
		try {
			contactoRepository.delete(contacto);
		} catch (Exception ex) {
			return false;
		}
		return true;
	}


}
