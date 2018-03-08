package cl.abaadmin.repository.web.web;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.transaction.annotation.Transactional;

import cl.abaadmin.entities.web.web.Comuna;

@Transactional("webTransactionManager")
public interface ComunaRepository extends JpaRepository<Comuna, Integer>{

	List<Comuna> findByRegionRegionId(Integer regionId);
}