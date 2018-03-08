package cl.abaadmin.service.web.contacto;

import java.util.List;

import cl.abaadmin.vo.ContactoVO;

public interface ContactoService {
	
	public List<ContactoVO> getContactos(Integer rbdId);
	
	public ContactoVO getContacto(Integer rbdId, Integer contactoId);
	
	public ContactoVO saveContacto(Integer rbdId, ContactoVO contacto);
	
	public Boolean deleteContacto(Integer rbdId, Integer contactoId);
 
}
