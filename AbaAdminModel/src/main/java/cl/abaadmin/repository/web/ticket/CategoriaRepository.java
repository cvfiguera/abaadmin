package cl.abaadmin.repository.web.ticket;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.transaction.annotation.Transactional;

import cl.abaadmin.entities.web.ticket.Categoria;

@Transactional("webTransactionManager")
public interface CategoriaRepository extends JpaRepository<Categoria, Integer>{

}
