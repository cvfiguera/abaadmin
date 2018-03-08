package cl.abaadmin.repository.web.web;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;

import cl.abaadmin.entities.web.web.EstadoAdjudicacion;

@Transactional("webTransactionManager")
public interface EstadoAdjudicacionRepository extends JpaRepository<EstadoAdjudicacion, Integer> {
	
	@Query("from EstadoAdjudicacion ea where ea.padre.estadoId = ea.estadoId")
	List<EstadoAdjudicacion> findEstados();

}
