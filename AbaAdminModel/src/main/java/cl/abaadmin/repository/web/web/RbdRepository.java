package cl.abaadmin.repository.web.web;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.transaction.annotation.Transactional;

import cl.abaadmin.entities.web.web.Rbd;

@Transactional("webTransactionManager")
public interface RbdRepository extends JpaRepository<Rbd, Integer>{
	
	Page<Rbd> findByRbdAndNombreContainingIgnoreCaseAndComunaComunaId(Long rbd, String nombre, Integer comunaId, Pageable page);
	
	Page<Rbd> findByRbdAndNombreContainingIgnoreCaseAndComunaRegionRegionId(Long rbd, String nombre, Integer regionId, Pageable page);
	
	Page<Rbd> findByRbdAndComunaComunaId(Long rbd, Integer comunaId, Pageable page);
	
	Page<Rbd> findByNombreContainingIgnoreCaseAndComunaComunaId(String nombre, Integer comunaId, Pageable page);
	
	Page<Rbd> findByRbdAndNombreContainingIgnoreCase(Long rbd, String nombre, Pageable page);
	
	Page<Rbd> findByRbdAndComunaRegionRegionId(Long rbd, Integer regionId, Pageable page);
	
	Page<Rbd> findByNombreContainingIgnoreCaseAndComunaRegionRegionId(String nombre, Integer comuna, Pageable page);
	
	Page<Rbd> findByRbd(Long rbd, Pageable page);

    Page<Rbd> findByNombreContainingIgnoreCase(String nombre, Pageable page);
    
    Page<Rbd> findByComunaRegionRegionId(Integer regionId, Pageable page);
	
	Page<Rbd> findByComunaComunaId(Integer comunaId, Pageable page);
}
