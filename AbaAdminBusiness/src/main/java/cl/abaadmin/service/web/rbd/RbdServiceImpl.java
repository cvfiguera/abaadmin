package cl.abaadmin.service.web.rbd;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import cl.abaadmin.entities.web.web.Operadora;
import cl.abaadmin.entities.web.web.Rbd;
import cl.abaadmin.repository.web.web.ComunaRepository;
import cl.abaadmin.repository.web.web.RbdRepository;
import cl.abaadmin.vo.ComunaVO;
import cl.abaadmin.vo.OperadoraVO;
import cl.abaadmin.vo.RbdVO;
import cl.abaadmin.vo.RegionVO;

@Service
public class RbdServiceImpl implements RbdService {

	@Autowired
	private RbdRepository rbdRepository;
	@Autowired
	private ComunaRepository comunaRepository;
	
	@Override
	public Page<Rbd> getRbds(PageRequest page) {
		
		Page<Rbd> result = rbdRepository.findAll(page);
		
		return result;
	}

	@Override
	public Page<Rbd> getRbds(PageRequest page, Long rbd, String nombre, Integer region, Integer comuna) {

		Page<Rbd> result;
		
		if (rbd!=null && nombre!="" && comuna!=null)
			result = rbdRepository.findByRbdAndNombreContainingIgnoreCaseAndComunaComunaId(rbd, nombre, comuna, page);
		else if (rbd!=null && nombre!="" && region!=null)
			result = rbdRepository.findByRbdAndNombreContainingIgnoreCaseAndComunaRegionRegionId(rbd, nombre, region, page);
		else if (rbd!=null && comuna!=null)
			result = rbdRepository.findByRbdAndComunaComunaId(rbd, comuna, page);
		else if (nombre!=null && comuna!=null)
			result = rbdRepository.findByNombreContainingIgnoreCaseAndComunaComunaId(nombre, comuna, page);
		else if (rbd!=null && nombre!="")
			result = rbdRepository.findByRbdAndNombreContainingIgnoreCase(rbd, nombre, page);
		else if (rbd!=null && region!=null)
			result = rbdRepository.findByRbdAndComunaRegionRegionId(rbd, region, page);
		else if (nombre!="" && region!=null)
			result = rbdRepository.findByNombreContainingIgnoreCaseAndComunaRegionRegionId(nombre, region, page);
		else if (rbd!=null)
			result = rbdRepository.findByRbd(rbd, page);
		else if(nombre!="")
			result = rbdRepository.findByNombreContainingIgnoreCase(nombre, page);
		else if (comuna!=null)
			result = rbdRepository.findByComunaComunaId(comuna, page);
		else if (region!=null)
			result = rbdRepository.findByComunaRegionRegionId(region, page);
		else
			result = rbdRepository.findAll(page);
		
		return result;
	}

	@Override
	public RbdVO getRbd(Integer rbdId) {
		
		Rbd rbd = rbdRepository.getOne(rbdId);
		
		return new RbdVO(rbd.getRbdId(), rbd.getRbd(), rbd.getNombre(), rbd.getDireccion(), rbd.getnAlumnos(),
				rbd.getObservacion(), new ComunaVO(rbd.getComuna().getComunaId(), rbd.getComuna().getNumero(),
						rbd.getComuna().getNombre(), new RegionVO(rbd.getComuna().getRegion().getRegionId(),
								rbd.getComuna().getRegion().getNumero(), rbd.getComuna().getRegion().getNombre())));
	}

	@Override
	public RbdVO saveRbd(RbdVO rbd) {

		Rbd rbdNew = new Rbd();
		
		if (rbd.getRbdId()!= null) 
			rbdNew.setRbdId(rbd.getRbdId());
		
		rbdNew.setRbd(rbd.getRbd());
		rbdNew.setNombre(rbd.getNombre());
		rbdNew.setnAlumnos(rbd.getnAlumnos());
		rbdNew.setObservacion(rbd.getObservacion());
		rbdNew.setDireccion(rbd.getDireccion());
		rbdNew.setComuna(comunaRepository.findOne(rbd.getComuna().getComunaId()));
	
		rbdNew = rbdRepository.save(rbdNew);
		rbd.setRbdId(rbdNew.getRbdId());
		
		return rbd;
	}

	@Override
	public Boolean deleteRbd(Integer rbdId) {
		
		Rbd rbd = rbdRepository.getOne(rbdId);
		
		try {
			rbdRepository.delete(rbd);
		} catch (Exception ex) {
			return false;
		}
		return true;
	}

}
