package cl.abaadmin.repository.web.web;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.transaction.annotation.Transactional;
import cl.abaadmin.entities.web.web.RegionSet;

@Transactional("webTransactionManager")
public interface RegionSetRepository extends JpaRepository<RegionSet, Integer>{

}
