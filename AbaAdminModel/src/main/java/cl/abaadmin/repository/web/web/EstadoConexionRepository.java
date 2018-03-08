package cl.abaadmin.repository.web.web;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.transaction.annotation.Transactional;

import cl.abaadmin.entities.web.web.EstadoConexion;

@Transactional("webTransactionManager")
public interface EstadoConexionRepository extends JpaRepository<EstadoConexion, Integer>{

}
