package cl.abaadmin.service.web.rbd;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;

import cl.abaadmin.entities.web.web.Rbd;
import cl.abaadmin.vo.RbdVO;


public interface RbdService {
	
	public Page<Rbd> getRbds(PageRequest page);
	
	public Page<Rbd> getRbds(PageRequest page, Long rbd, String nombre, Integer region, Integer comuna);
	
	public RbdVO getRbd(Integer rbdId);
	
	public RbdVO saveRbd(RbdVO rbd);
	
	public Boolean deleteRbd(Integer rbdId);

}
