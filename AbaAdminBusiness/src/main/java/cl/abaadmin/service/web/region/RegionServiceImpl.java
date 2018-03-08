package cl.abaadmin.service.web.region;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import cl.abaadmin.entities.web.web.RegionSet;
import cl.abaadmin.repository.web.web.RegionRepository;
import cl.abaadmin.repository.web.web.RegionSetRepository;
import cl.abaadmin.vo.RegionVO;

@Service
public class RegionServiceImpl implements RegionService{

	@Autowired
	private RegionSetRepository regionSetRepository;
	
	@Override
	public Page<RegionSet> getRegiones() {
		Long n = regionSetRepository.count();
		Page<RegionSet> regiones = regionSetRepository.findAll(new PageRequest(0, n.intValue()));
		
		return regiones;
	}
	

	@Override
	public RegionVO getRegion(Integer regionId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Boolean saveRegion(RegionVO region) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Boolean deleteRegion(RegionVO region) {
		// TODO Auto-generated method stub
		return null;
	}
}
