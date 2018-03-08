package cl.abaadmin.repository.web.web;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.transaction.annotation.Transactional;

import cl.abaadmin.entities.web.web.ListaEspera;

@Transactional("webTransactionManager")
public interface ListaEsperaRepository extends JpaRepository<ListaEspera, Integer>{
	
	List<ListaEspera> findByTipoAdjudicacionTipoAdjudicacionId(Integer tipo);

}
