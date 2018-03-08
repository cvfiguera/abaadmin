package cl.abaadmin.repository.web.web;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.transaction.annotation.Transactional;
import cl.abaadmin.entities.web.web.Contacto;

@Transactional("webTransactionManager")
public interface ContactoRepository extends JpaRepository<Contacto, Integer> {
	
	List<Contacto> findByRbdRbdId(Integer rbd);

}
