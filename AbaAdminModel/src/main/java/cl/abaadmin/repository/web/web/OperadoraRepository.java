package cl.abaadmin.repository.web.web;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import cl.abaadmin.entities.web.web.Operadora;

@Transactional("webTransactionManager")
public interface OperadoraRepository extends JpaRepository<Operadora,Integer> {

	@Query("select max(o.operadoraId) from Operadora o")
    Integer getMaxId();
	
	@Query("from Operadora o where (lower(o.rut) like :rut or :rut is null) and (lower(o.nombre) like :nombre or :nombre is null)")
    Page<Operadora> findByFilters(@Param("rut") String rut, @Param("nombre") String nombre, Pageable page);
	
	Page<Operadora> findByRutContainingIgnoreCase(String rut, Pageable page);

    Page<Operadora> findByNombreContainingIgnoreCase(String nombre, Pageable page);
}
