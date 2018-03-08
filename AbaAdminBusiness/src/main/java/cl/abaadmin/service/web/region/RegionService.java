package cl.abaadmin.service.web.region;

import org.springframework.data.domain.Page;

import cl.abaadmin.entities.web.web.RegionSet;
import cl.abaadmin.vo.RegionVO;

public interface RegionService {
	
	public Page<RegionSet> getRegiones();
	
	public RegionVO getRegion(Integer regionId);
	
	public Boolean saveRegion(RegionVO region);
	
	public Boolean deleteRegion(RegionVO region);

}
